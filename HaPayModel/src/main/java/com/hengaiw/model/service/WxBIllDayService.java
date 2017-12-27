package com.hengaiw.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hengaiw.model.dao.mapper.WxBillDayMapper;
import com.hengaiw.model.dao.model.WxBillDay;

/**
 * @Description:

 */
@Component
public class WxBIllDayService {

    @Autowired
    private WxBillDayMapper wxBillDayMapper;

    public int createWxBillDay(WxBillDay wxBillDay) {
        return wxBillDayMapper.insertSelective(wxBillDay);
    }

}
