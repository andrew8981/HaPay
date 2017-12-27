package com.hengaiw.model.dao.mapper;

import com.hengaiw.model.dao.model.PotevioOrder;
import com.hengaiw.model.dao.model.PotevioOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PotevioOrderMapper {
    long countByExample(PotevioOrderExample example);

    int deleteByExample(PotevioOrderExample example);

    int deleteByPrimaryKey(Integer order_id);

    int insert(PotevioOrder record);

    int insertSelective(PotevioOrder record);

    List<PotevioOrder> selectByExample(PotevioOrderExample example);

    PotevioOrder selectByPrimaryKey(Integer order_id);

    int updateByExampleSelective(@Param("record") PotevioOrder record, @Param("example") PotevioOrderExample example);

    int updateByExample(@Param("record") PotevioOrder record, @Param("example") PotevioOrderExample example);

    int updateByPrimaryKeySelective(PotevioOrder record);

    int updateByPrimaryKey(PotevioOrder record);
}