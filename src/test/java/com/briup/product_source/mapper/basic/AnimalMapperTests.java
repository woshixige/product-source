package com.briup.product_source.mapper.basic;

import com.briup.product_source.bean.basic.Hurdles;
import com.briup.product_source.dao.basic.AnimalMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-27 11:16
 */
@SpringBootTest
public class AnimalMapperTests {
    @Autowired
    private AnimalMapper animalMapper;

    @Test
    public void method(){
        Date date = new Date();//Tue Aug 27 11:17:37 CST 2024
        System.out.println(date);
    }
}
