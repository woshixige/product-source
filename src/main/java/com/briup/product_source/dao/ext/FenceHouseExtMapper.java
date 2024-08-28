package com.briup.product_source.dao.ext;

import com.briup.product_source.bean.ext.FenceHouseExt;

public interface FenceHouseExtMapper {
    int deleteByPrimaryKey(String fhId);

    int insert(FenceHouseExt record);

    int insertSelective(FenceHouseExt record);

    FenceHouseExt selectByPrimaryKey(String fhId);

    int updateByPrimaryKeySelective(FenceHouseExt record);

    int updateByPrimaryKey(FenceHouseExt record);
}