package com.hengaiw.model.dao.mapper;

import com.hengaiw.model.dao.model.PotevioApp;
import com.hengaiw.model.dao.model.PotevioAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PotevioAppMapper {
    long countByExample(PotevioAppExample example);

    int deleteByExample(PotevioAppExample example);

    int deleteByPrimaryKey(Integer app_id);

    int insert(PotevioApp record);

    int insertSelective(PotevioApp record);

    List<PotevioApp> selectByExample(PotevioAppExample example);

    PotevioApp selectByPrimaryKey(Integer app_id);

    int updateByExampleSelective(@Param("record") PotevioApp record, @Param("example") PotevioAppExample example);

    int updateByExample(@Param("record") PotevioApp record, @Param("example") PotevioAppExample example);

    int updateByPrimaryKeySelective(PotevioApp record);

    int updateByPrimaryKey(PotevioApp record);
}