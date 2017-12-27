package com.hengaiw.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hengaiw.model.dao.mapper.RefundOrderMapper;
import com.hengaiw.model.dao.model.RefundOrder;
import com.hengaiw.model.dao.model.RefundOrderExample;
import com.hengaiw.pub.constant.PayConstants;

import java.util.List;

/**
 
 */
@Component
public class RefundOrderService {

    @Autowired
    private RefundOrderMapper refundOrderMapper;

    public int createRefundOrder(RefundOrder refundOrder) {
        return refundOrderMapper.insertSelective(refundOrder);
    }

    public RefundOrder selectRefundOrder(String refundOrderId) {
        return refundOrderMapper.selectByPrimaryKey(refundOrderId);
    }

    public RefundOrder selectRefundOrderByMchIdAndRefundOrderId(String mchId, String refundOrderId) {
        RefundOrderExample example = new RefundOrderExample();
        RefundOrderExample.Criteria criteria = example.createCriteria();
        criteria.andMchIdEqualTo(mchId);
        criteria.andRefundOrderIdEqualTo(refundOrderId);
        List<RefundOrder> RefundOrderList = refundOrderMapper.selectByExample(example);
        return CollectionUtils.isEmpty(RefundOrderList) ? null : RefundOrderList.get(0);
    }

    

    public int updateStatus4Ing(String RefundOrderId, String channelOrderNo) {
        RefundOrder refundOrder = new RefundOrder();
        refundOrder.setStatus(PayConstants.PAY_STATUS_PAYING);
        if(channelOrderNo != null) refundOrder.setChannelOrderNo(channelOrderNo);
       // RefundOrder.setRefundSuccTime(System.currentTimeMillis());
        RefundOrderExample example = new RefundOrderExample();
        RefundOrderExample.Criteria criteria = example.createCriteria();
        criteria.andRefundOrderIdEqualTo(RefundOrderId);
        criteria.andStatusEqualTo(PayConstants.PAY_STATUS_INIT);
        return refundOrderMapper.updateByExampleSelective(refundOrder, example);
    }

    
    public int updateStatus4Success(String refundOrderId) {
        RefundOrder refundOrder = new RefundOrder();
        refundOrder.setRefundOrderId(refundOrderId);
        refundOrder.setStatus(PayConstants.PAY_STATUS_SUCCESS);
        
        //.setPaySuccTime(System.currentTimeMillis());
        RefundOrderExample example = new RefundOrderExample();
        RefundOrderExample.Criteria criteria = example.createCriteria();
        criteria.andRefundOrderIdEqualTo(refundOrderId);
        criteria.andStatusEqualTo(PayConstants.PAY_STATUS_PAYING);
        return refundOrderMapper.updateByExampleSelective(refundOrder, example);
    }

    public int updateStatus4Complete(String refundOrderId,String channelOrderNo) {
        RefundOrder refundOrder = new RefundOrder();
        refundOrder.setRefundOrderId(refundOrderId);
        refundOrder.setChannelOrderNo(channelOrderNo);
        refundOrder.setStatus(PayConstants.PAY_STATUS_REFUND);
        refundOrder.setResult((byte) 2);
        RefundOrderExample example = new RefundOrderExample();
        RefundOrderExample.Criteria criteria = example.createCriteria();
        criteria.andRefundOrderIdEqualTo(refundOrderId);
        criteria.andStatusEqualTo(PayConstants.PAY_STATUS_SUCCESS);
        return refundOrderMapper.updateByExampleSelective(refundOrder, example);
    }

}
