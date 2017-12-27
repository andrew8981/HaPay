package com.hengaiw.model.dao.mapper;

import com.hengaiw.model.dao.model.PotevioModel;
import com.hengaiw.model.dao.model.PotevioModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PotevioModelMapper {
    long countByExample(PotevioModelExample example);

    int deleteByExample(PotevioModelExample example);

    int deleteByPrimaryKey(Integer m_id);

    int insert(PotevioModel record);

    int insertSelective(PotevioModel record);

    List<PotevioModel> selectByExampleWithBLOBs(PotevioModelExample example);

    List<PotevioModel> selectByExample(PotevioModelExample example);

    PotevioModel selectByPrimaryKey(Integer m_id);

    int updateByExampleSelective(@Param("record") PotevioModel record, @Param("example") PotevioModelExample example);

    int updateByExampleWithBLOBs(@Param("record") PotevioModel record, @Param("example") PotevioModelExample example);

    int updateByExample(@Param("record") PotevioModel record, @Param("example") PotevioModelExample example);

    int updateByPrimaryKeySelective(PotevioModel record);

    int updateByPrimaryKeyWithBLOBs(PotevioModel record);

    int updateByPrimaryKey(PotevioModel record);
}