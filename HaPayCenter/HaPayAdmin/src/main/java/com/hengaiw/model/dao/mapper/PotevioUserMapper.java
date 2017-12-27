package com.hengaiw.model.dao.mapper;

import com.hengaiw.model.dao.model.PotevioUser;
import com.hengaiw.model.dao.model.PotevioUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PotevioUserMapper {
    int countByExample(PotevioUserExample example);

    int deleteByExample(PotevioUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PotevioUser record);

    int insertSelective(PotevioUser record);

    List<PotevioUser> selectByExample(PotevioUserExample example);

    PotevioUser selectByPrimaryKey(Integer id);
    PotevioUser selectByUserName(String username);
    int updateByExampleSelective(@Param("record") PotevioUser record, @Param("example") PotevioUserExample example);

    int updateByExample(@Param("record") PotevioUser record, @Param("example") PotevioUserExample example);

    int updateByPrimaryKeySelective(PotevioUser record);

    int updateByPrimaryKey(PotevioUser record);
}