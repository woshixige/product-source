package com.briup.product_source;

import com.briup.product_source.config.QiniuyunProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-29 13:03
 */
@SpringBootTest
public class QiniuyunTests {
    @Autowired
    private QiniuyunProperties qiniuyunProperties;
    @Test
    public void method(){
        System.out.println(qiniuyunProperties);
    }
}
