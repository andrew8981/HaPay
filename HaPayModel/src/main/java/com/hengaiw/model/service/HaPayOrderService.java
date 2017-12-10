package com.hengaiw.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hengaiw.model.dao.mapper.PayOrderMapper;
import com.hengaiw.model.dao.model.PayOrder;
import com.hengaiw.model.dao.model.PayOrderExample;
import com.hengaiw.pub.constant.PayConstants;

import java.util.List;

/**
 
 */
@Component
public class HaPayOrderService {

    @Autowired
    private PayOrderMapper payOrderMapper;

    public int createPayOrder(PayOrder payOrder) {
        return payOrderMapper.insertSelective(payOrder);
    }

    public PayOrder selectPayOrder(String payOrderId) {
        return payOrderMapper.selectByPrimaryKey(payOrderId);
    }

    public PayOrder selectPayOrderByMchIdAndPayOrderId(String mchId, String payOrderId) {
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andMchIdEqualTo(mchId);
        criteria.andPayOrderIdEqualTo(payOrderId);
        List<PayOrder> payOrderList = payOrderMapper.selectByExample(example);
        return CollectionUtils.isEmpty(payOrderList) ? null : payOrderList.get(0);
    }

    public PayOrder selectPayOrderByMchIdAndMchOrderNo(String mchId, String mchOrderNo) {
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andMchIdEqualTo(mchId);
        criteria.andMchOrderNoEqualTo(mchOrderNo);
        List<PayOrder> payOrderList = payOrderMapper.selectByExample(example);
        return CollectionUtils.isEmpty(payOrderList) ? null : payOrderList.get(0);
    }

    public int updateStatus4Ing(String payOrderId, String channelOrderNo) {
        PayOrder payOrder = new PayOrder();
        payOrder.setStatus(PayConstants.PAY_STATUS_PAYING);
        if(channelOrderNo != null) payOrder.setChannelOrderNo(channelOrderNo);
        payOrder.setPaySuccTime(System.currentTimeMillis());
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayOrderIdEqualTo(payOrderId);
        criteria.andStatusEqualTo(PayConstants.PAY_STATUS_INIT);
        return payOrderMapper.updateByExampleSelective(payOrder, example);
    }

    
    public int updateStatus4Success(String payOrderId) {
        PayOrder payOrder = new PayOrder();
        payOrder.setPayOrderId(payOrderId);
        payOrder.setStatus(PayConstants.PAY_STATUS_SUCCESS);
        payOrder.setPaySuccTime(System.currentTimeMillis());
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayOrderIdEqualTo(payOrderId);
        criteria.andStatusEqualTo(PayConstants.PAY_STATUS_PAYING);
        return payOrderMapper.updateByExampleSelective(payOrder, example);
    }

    public int updateStatus4Complete(String payOrderId) {
        PayOrder payOrder = new PayOrder();
        payOrder.setPayOrderId(payOrderId);
        payOrder.setStatus(PayConstants.PAY_STATUS_COMPLETE);
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayOrderIdEqualTo(payOrderId);
        criteria.andStatusEqualTo(PayConstants.PAY_STATUS_SUCCESS);
        return payOrderMapper.updateByExampleSelective(payOrder, example);
    }

    public int updateStatus4Refund(String payOrderId) {
    		PayOrder payOrder = new PayOrder();
        payOrder.setPayOrderId(payOrderId);
        payOrder.setStatus(PayConstants.PAY_STATUS_REFUND);
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayOrderIdEqualTo(payOrderId);
        criteria.andStatusEqualTo(PayConstants.PAY_STATUS_COMPLETE);
        return payOrderMapper.updateByExampleSelective(payOrder, example);
    	
    }
    public int updateNotify(String payOrderId, byte count) {
        PayOrder newPayOrder = new PayOrder();
        // TODO 并发下次数问题待解决
        newPayOrder.setNotifyCount(count);
        newPayOrder.setLastNotifyTime(System.currentTimeMillis());
        newPayOrder.setPayOrderId(payOrderId);
        return payOrderMapper.updateByPrimaryKeySelective(newPayOrder);
    }

    public int updateNotify(PayOrder payOrder) {
        return payOrderMapper.updateByPrimaryKeySelective(payOrder);
    }

}
