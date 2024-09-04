package com.briup.product_source;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-26 14:27
 */
public class UUIDTests {
    @Test
    public void test(){
        String str = UUID.randomUUID().toString();
        System.out.println(str);

        System.out.println(str.replace("-",""));
    }
}
