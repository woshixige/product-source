package com.briup.product_source.dao.ext;

import com.briup.product_source.bean.basic.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-09-04 19:56
 */
public interface LogExtMapper {
    List<Log> selectByHost(@Param("logHost") String logHost);
}
