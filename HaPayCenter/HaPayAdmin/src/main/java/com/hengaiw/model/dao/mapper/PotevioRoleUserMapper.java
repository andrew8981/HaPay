package com.hengaiw.model.dao.mapper;

import com.hengaiw.model.dao.model.PotevioRoleUser;
import com.hengaiw.model.dao.model.PotevioRoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PotevioRoleUserMapper {
    long countByExample(PotevioRoleUserExample example);

    int deleteByExample(PotevioRoleUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PotevioRoleUser record);

    int insertSelective(PotevioRoleUser record);

    List<PotevioRoleUser> selectByExample(PotevioRoleUserExample example);

    PotevioRoleUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PotevioRoleUser record, @Param("example") PotevioRoleUserExample example);

    int updateByExample(@Param("record") PotevioRoleUser record, @Param("example") PotevioRoleUserExample example);

    int updateByPrimaryKeySelective(PotevioRoleUser record);

    int updateByPrimaryKey(PotevioRoleUser record);
}