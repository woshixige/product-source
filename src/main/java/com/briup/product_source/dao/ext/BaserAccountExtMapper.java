package com.briup.product_source.dao.ext;

import com.briup.product_source.bean.basic.BaseAccount;
import com.briup.product_source.dao.basic.BaseAccountMapper;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-29 11:32
 */
public interface BaserAccountExtMapper extends BaseAccountMapper {
    BaseAccount findUserByName(String username);
}
