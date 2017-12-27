package com.hengaiw.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hengaiw.model.dao.mapper.WxBillMapper;
import com.hengaiw.model.dao.model.WxBill;

/**
 * @Description:

 */
@Component
public class WxBIllService {

    @Autowired
    private WxBillMapper wxBillMapper;

    public int createWxBill(WxBill wxBill) {
        return wxBillMapper.insertSelective(wxBill);
    }

}
