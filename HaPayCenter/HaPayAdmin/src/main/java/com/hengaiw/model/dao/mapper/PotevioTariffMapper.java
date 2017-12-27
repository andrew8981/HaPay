package com.hengaiw.model.dao.mapper;

import com.hengaiw.model.dao.model.PotevioTariff;
import com.hengaiw.model.dao.model.PotevioTariffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PotevioTariffMapper {
    long countByExample(PotevioTariffExample example);

    int deleteByExample(PotevioTariffExample example);

    int deleteByPrimaryKey(Integer tariff_id);

    int insert(PotevioTariff record);

    int insertSelective(PotevioTariff record);

    List<PotevioTariff> selectByExampleWithBLOBs(PotevioTariffExample example);

    List<PotevioTariff> selectByExample(PotevioTariffExample example);

    PotevioTariff selectByPrimaryKey(Integer tariff_id);

    int updateByExampleSelective(@Param("record") PotevioTariff record, @Param("example") PotevioTariffExample example);

    int updateByExampleWithBLOBs(@Param("record") PotevioTariff record, @Param("example") PotevioTariffExample example);

    int updateByExample(@Param("record") PotevioTariff record, @Param("example") PotevioTariffExample example);

    int updateByPrimaryKeySelective(PotevioTariff record);

    int updateByPrimaryKeyWithBLOBs(PotevioTariff record);

    int updateByPrimaryKey(PotevioTariff record);
}