package com.hengaiw.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hengaiw.model.dao.mapper.EntpayOrderMapper;
import com.hengaiw.model.dao.mapper.PayChannelMapper;
import com.hengaiw.model.dao.model.EntpayOrder;
import com.hengaiw.model.dao.model.EntpayOrderExample;
import com.hengaiw.model.dao.model.PayChannel;
import com.hengaiw.model.dao.model.PayChannelExample;
import com.hengaiw.model.dao.model.PayOrder;
import com.hengaiw.model.dao.model.PayOrderExample;
import com.hengaiw.pub.constant.PayConstants;

import java.util.List;

/**
 * @Description:
 
 */
@Component
public class EntpayOrderService {

    @Autowired
    private EntpayOrderMapper entpayOrderMapper;

    public int createEntpayOrder(EntpayOrder entpayOrder) {
        return entpayOrderMapper.insertSelective(entpayOrder);
    }

    public EntpayOrder selectEntpayOrder(String entPayOrderId) {
        return entpayOrderMapper.selectByPrimaryKey(entPayOrderId);
    }
    
    public int updateStatusSuccess(String entPayOrderId,String paymentNo) {
    		EntpayOrder entpayOrder = new EntpayOrder();
    		entpayOrder.setEntPayOrderId(entPayOrderId);
    		entpayOrder.setStatus((byte) 1);
    		entpayOrder.setPaymentNo(paymentNo);
    		entpayOrder.setEntPaySuccTime(System.currentTimeMillis());
        EntpayOrderExample example = new EntpayOrderExample();
        EntpayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andEntPayOrderIdEqualTo(entPayOrderId);
        criteria.andStatusEqualTo((byte) 0);
        return entpayOrderMapper.updateByExampleSelective(entpayOrder, example);
    }
}
