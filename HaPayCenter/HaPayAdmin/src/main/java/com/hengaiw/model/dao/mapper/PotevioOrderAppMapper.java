package com.hengaiw.model.dao.mapper;

import com.hengaiw.model.dao.model.PotevioOrderApp;
import com.hengaiw.model.dao.model.PotevioOrderAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PotevioOrderAppMapper {
    long countByExample(PotevioOrderAppExample example);

    int deleteByExample(PotevioOrderAppExample example);

    int insert(PotevioOrderApp record);

    int insertSelective(PotevioOrderApp record);

    List<PotevioOrderApp> selectByExample(PotevioOrderAppExample example);

    int updateByExampleSelective(@Param("record") PotevioOrderApp record, @Param("example") PotevioOrderAppExample example);

    int updateByExample(@Param("record") PotevioOrderApp record, @Param("example") PotevioOrderAppExample example);
}