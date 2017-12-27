package com.hengaiw.model.dao.mapper;

import com.hengaiw.model.dao.model.PotevioRole;
import com.hengaiw.model.dao.model.PotevioRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PotevioRoleMapper {
    long countByExample(PotevioRoleExample example);

    int deleteByExample(PotevioRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PotevioRole record);

    int insertSelective(PotevioRole record);

    List<PotevioRole> selectByExample(PotevioRoleExample example);

    PotevioRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PotevioRole record, @Param("example") PotevioRoleExample example);

    int updateByExample(@Param("record") PotevioRole record, @Param("example") PotevioRoleExample example);

    int updateByPrimaryKeySelective(PotevioRole record);

    int updateByPrimaryKey(PotevioRole record);
}