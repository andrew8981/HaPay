package com.hengaiw.model.dao.mapper;

import com.hengaiw.model.dao.model.PotevioShop;
import com.hengaiw.model.dao.model.PotevioShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PotevioShopMapper {
    long countByExample(PotevioShopExample example);

    int deleteByExample(PotevioShopExample example);

    int deleteByPrimaryKey(Integer shop_id);

    int insert(PotevioShop record);

    int insertSelective(PotevioShop record);

    List<PotevioShop> selectByExample(PotevioShopExample example);

    PotevioShop selectByPrimaryKey(Integer shop_id);

    int updateByExampleSelective(@Param("record") PotevioShop record, @Param("example") PotevioShopExample example);

    int updateByExample(@Param("record") PotevioShop record, @Param("example") PotevioShopExample example);

    int updateByPrimaryKeySelective(PotevioShop record);

    int updateByPrimaryKey(PotevioShop record);
}