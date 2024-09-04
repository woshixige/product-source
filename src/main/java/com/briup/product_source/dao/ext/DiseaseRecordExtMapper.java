package com.briup.product_source.dao.ext;

import com.briup.product_source.dao.basic.DiseaseRecordMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-09-01 21:40
 */
public interface DiseaseRecordExtMapper extends DiseaseRecordMapper {
    void deleteByBatch(@Param("ids") List<Integer> ids);
}
