package com.briup.product_source.mapper.basic;

import com.briup.product_source.dao.basic.BaseAccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-28 19:54
 */
@SpringBootTest
public class BaseAccountMapperTests {
    @Autowired
    private BaseAccountMapper baseAccountMapper;
    @Test
    public void method(){
        System.out.println(baseAccountMapper.findUserByName("admin"));
    }
}
