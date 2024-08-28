package com.briup.product_source.service;

import java.util.List;
import java.util.Map;

/**
 * 统计分析（首页大屏）接口
 */
public interface AnalysisService {
    /**
     * 统计栏舍数量(对应manager_fence_house表)
     * 栏圈数量(对应manager_hurdles表)
     * 动物数量(对应manager_animal表)
     * 冷库数量(对应manager_freezer表)
     * 员工数量(对应base_account表)
     * @return
     */
    Map<String, List<Object>> countNum();
}