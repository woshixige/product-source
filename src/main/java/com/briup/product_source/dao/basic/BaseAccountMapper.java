package com.briup.product_source.dao.basic;

import com.briup.product_source.bean.basic.BaseAccount;

public interface BaseAccountMapper {
    int deleteByPrimaryKey(String accountId);

    int insert(BaseAccount record);

    int insertSelective(BaseAccount record);

    BaseAccount selectByPrimaryKey(String accountId);

    int updateByPrimaryKeySelective(BaseAccount record);

    int updateByPrimaryKey(BaseAccount record);

    BaseAccount findUserByName(String username);
}