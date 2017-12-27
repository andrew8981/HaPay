package com.hengaiw.model.dao.mapper;

import com.hengaiw.model.dao.model.WxBill;
import com.hengaiw.model.dao.model.WxBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxBillMapper {
    long countByExample(WxBillExample example);

    int deleteByExample(WxBillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxBill record);

    int insertSelective(WxBill record);

    List<WxBill> selectByExample(WxBillExample example);

    WxBill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxBill record, @Param("example") WxBillExample example);

    int updateByExample(@Param("record") WxBill record, @Param("example") WxBillExample example);

    int updateByPrimaryKeySelective(WxBill record);

    int updateByPrimaryKey(WxBill record);
}