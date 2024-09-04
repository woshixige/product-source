package com.briup.product_source.dao.ext;

import javafx.beans.binding.ObjectBinding;
import org.apache.ibatis.annotations.MapKey;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-22 14:45
 */

public interface AnalysisMapper {

    @MapKey("name")
    Map countNum();

    List<Map<String,Object>> countWeight();
    //统计动物生疾病分别对应的数量
    List<Map<String, Object>> countDisease();
    List<Map<Integer, Object>> countSales();
}
