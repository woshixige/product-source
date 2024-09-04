package com.briup.product_source.mapper.ext;

import com.briup.product_source.bean.ext.ManagerAnimalExt;
import com.briup.product_source.dao.ext.AnimalExtMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-30 9:52
 */
@SpringBootTest
public class AnimalExtMapperTests {
    @Autowired
    private AnimalExtMapper animalExtMapper;
    @Test
    public void method4(){
        animalExtMapper.createQRcodeByAnimalId("333","666");
    }
    @Test
    public void method3(){
        /*Map map = animalExtMapper.findByAnimalId("000cec87a71d41cebf0eabf38f6054f4");
        Set set = map.entrySet();
        for (Object o : set) {
            System.out.println(o);
        }*/
        ManagerAnimalExt animalExt = animalExtMapper.findByAnimalId("000cec87a71d41cebf0eabf38f6054f4");
        System.out.println(animalExt);
    }
    @Test
    public void method2(){
        List<Map<String, Object>> list = animalExtMapper.findAnimalExtByCondition("健康", "");
        System.out.println(list);
    }
    @Test
    public void method(){
        animalExtMapper.deleteByBatchId(Arrays.asList("3333","4444"));
    }
}
