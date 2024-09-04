package com.briup.product_source.service.impl;

import com.briup.product_source.dao.ext.AnalysisMapper;
import com.briup.product_source.service.AnalysisService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 首页大屏的业务层实现类
 */
@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    private AnalysisMapper analysisMapper;

    public Map<String, List<Object>> countNum() {
        //思路1：统计5张表中每个表的数量 5条sql  调用5个mapper对象 返回值int
        //思路2：使用一条sql实现5张表查询，返回值map集合
        /**
         * {栏舍={num=3, name=栏舍}, 栏圈={num=10, name=栏圈}, 冷库={num=6, name=冷库},
         * 员工={num=1, name=员工}, 动物={num=18, name=动物}}
         */
        Map<String,Map<String,Object>> map = analysisMapper.countNum();
        Set<String> names = map.keySet();
        List<Object> nums = map.values().stream().map(v -> v.get("num")).
                                collect(Collectors.toList());
        Map srcMap = new HashMap<String, List<Object>>();
        srcMap.put("name",names);
        srcMap.put("value",nums);

        return srcMap;
    }

    @Override
    public Map<String, Integer> countWeight() {
        Map<String, Integer> map = new HashMap<>();
        List<Map<String, Object>> mapList = analysisMapper.countWeight();
        for (int i = 0; i < mapList.size(); i++) {
            String weight_group = (String) mapList.get(i).get("weight_group");
            /*
             Integer count = (Integer) mapList.get(i).get("count");
             数据查询的接收到的数据是Long类型，不能直接转化成Integer类型
             要通过intValue()转化成基本类型
             */
            Long longCount = (Long) mapList.get(i).get("count");
            Integer integerCount = longCount.intValue();
            map.put(weight_group,integerCount);
        }
        return map;
    }

    @Override
    public Map<String, Integer> countDisease() {
        Map<String, Integer> map = new HashMap<>();
        List<Map<String, Object>> mapList = analysisMapper.countDisease();
        for (int i = 0; i < mapList.size(); i++) {
            String name = (String) mapList.get(i).get("name");
            Long longCount = (Long) mapList.get(i).get("count");
            Integer integerCount = (Integer)longCount.intValue();
            map.put(name,integerCount);
        }
        return map;
    }

    @Override
    public Map<String, List<Object>> countSales() {
        Map<String, List<Object>> map = new HashMap<String, List<Object>>();
        List<Map<Integer, Object>> mapList = analysisMapper.countSales();
        List nameList=Arrays.asList("1月", "2月", "3月", "4月", "5月", "6月",
                "7月", "8月", "9月", "10月", "11月", "12月");
        List valueList = new ArrayList<>(Collections.nCopies(12, 0));
        for (int i = 0; i < mapList.size(); i++) {
            Integer month = (Integer) mapList.get(i).get("month");

            BigDecimal num = (BigDecimal) mapList.get(i).get("num");
            valueList.set(month-1,num);
        }
        map.put("name",nameList);
        map.put("value",valueList);
        return map;
    }
}
