package com.hengaiw.model.dao.mapper;

import com.hengaiw.model.dao.model.PotevioShopApp;
import com.hengaiw.model.dao.model.PotevioShopAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PotevioShopAppMapper {
    long countByExample(PotevioShopAppExample example);

    int deleteByExample(PotevioShopAppExample example);

    int insert(PotevioShopApp record);

    int insertSelective(PotevioShopApp record);

    List<PotevioShopApp> selectByExample(PotevioShopAppExample example);

    int updateByExampleSelective(@Param("record") PotevioShopApp record, @Param("example") PotevioShopAppExample example);

    int updateByExample(@Param("record") PotevioShopApp record, @Param("example") PotevioShopAppExample example);
}