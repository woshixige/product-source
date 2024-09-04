package com.briup.product_source;

import com.briup.product_source.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-09-04 10:29
 */
@SpringBootTest
public class AopTests {
    @Autowired
    private AccountService accountService;
    @Test
    public void method(){

    }
}
