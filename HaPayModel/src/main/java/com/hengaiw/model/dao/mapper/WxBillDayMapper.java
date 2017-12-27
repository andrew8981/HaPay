package com.hengaiw.model.dao.mapper;

import com.hengaiw.model.dao.model.WxBillDay;
import com.hengaiw.model.dao.model.WxBillDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxBillDayMapper {
    long countByExample(WxBillDayExample example);

    int deleteByExample(WxBillDayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxBillDay record);

    int insertSelective(WxBillDay record);

    List<WxBillDay> selectByExample(WxBillDayExample example);

    WxBillDay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxBillDay record, @Param("example") WxBillDayExample example);

    int updateByExample(@Param("record") WxBillDay record, @Param("example") WxBillDayExample example);

    int updateByPrimaryKeySelective(WxBillDay record);

    int updateByPrimaryKey(WxBillDay record);
}