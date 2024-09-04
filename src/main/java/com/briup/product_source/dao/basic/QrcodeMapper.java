package com.briup.product_source.dao.basic;

import com.briup.product_source.bean.basic.Qrcode;

public interface QrcodeMapper {
    int deleteByPrimaryKey(Integer qId);

    int insert(Qrcode record);

    int insertSelective(Qrcode record);

    Qrcode selectByPrimaryKey(Integer qId);

    int updateByPrimaryKeySelective(Qrcode record);

    int updateByPrimaryKey(Qrcode record);
}