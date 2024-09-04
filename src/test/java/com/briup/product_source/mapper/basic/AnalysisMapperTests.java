package com.briup.product_source.mapper.basic;

import com.briup.product_source.dao.ext.AnalysisMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-23 14:05
 */
@SpringBootTest
public class AnalysisMapperTests {
    @Autowired
    private AnalysisMapper analysisMapper;
    @Test
    public void method5(){
        List<Map<Integer, Object>> maps = analysisMapper.countSales();
        System.out.println(maps);
    }
    @Test
    public void method4(){
        List<Map<String, Object>> maps = analysisMapper.countDisease();
        System.out.println(maps);
    }
    @Test
    public void method3(){
        Map map = analysisMapper.countNum();
        System.out.println(map);
    }
    @Test
    public void method2(){
        List<Map<String, Object>> maps = analysisMapper.countWeight();
        System.out.println(maps.get(0).get("count").getClass());
        Long longCount = (Long) maps.get(0).get("count");
        Integer integerCount = longCount.intValue();
        System.out.println(integerCount.getClass());
    }
    @Test
    public void method(){
        List<Integer> list = new ArrayList<>(Collections.nCopies(12, 0));
        System.out.println(list);
    }
}
