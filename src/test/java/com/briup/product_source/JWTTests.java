package com.briup.product_source;

import com.briup.product_source.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-28 20:02
 */

public class JWTTests {
   @Test
   public void method(){
       Map<String, Object> map = new HashMap<>();
       map.put("username","zhangsan");
       map.put("age",33);
       String jwt=JwtUtil.sign("username",map);
       System.out.println(jwt);
   }
}
