package com.hengaiw.model.dao.mapper;

import com.hengaiw.model.dao.model.EntpayOrder;
import com.hengaiw.model.dao.model.EntpayOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntpayOrderMapper {
    long countByExample(EntpayOrderExample example);

    int deleteByExample(EntpayOrderExample example);

    int deleteByPrimaryKey(String entPayOrderId);

    int insert(EntpayOrder record);

    int insertSelective(EntpayOrder record);

    List<EntpayOrder> selectByExample(EntpayOrderExample example);

    EntpayOrder selectByPrimaryKey(String entPayOrderId);

    int updateByExampleSelective(@Param("record") EntpayOrder record, @Param("example") EntpayOrderExample example);

    int updateByExample(@Param("record") EntpayOrder record, @Param("example") EntpayOrderExample example);

    int updateByPrimaryKeySelective(EntpayOrder record);

    int updateByPrimaryKey(EntpayOrder record);
}