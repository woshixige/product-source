package com.briup.product_source.dao.ext;

import com.briup.product_source.bean.basic.FenceHouse;
import com.briup.product_source.bean.ext.FenceHouseExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FenceHouseExtMapper {
    int deleteByPrimaryKey(String fhId);

    int insert(FenceHouseExt record);

    int insertSelective(FenceHouseExt record);

    FenceHouseExt selectByPrimaryKey(String fhId);

    int updateByPrimaryKeySelective(FenceHouseExt record);

    int updateByPrimaryKey(FenceHouseExt record);


    FenceHouseExt findById(String id);


    List<FenceHouse> selectByCondition(String fhName);


    FenceHouse selectFenceHouseByName(String fhName);

    void deleteByBatch(@Param("ids") List<String> ids);
}