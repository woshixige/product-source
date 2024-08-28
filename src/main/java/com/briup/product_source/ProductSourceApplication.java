package com.briup.product_source;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableSwagger2Doc //开启swagger
@MapperScan("com.briup.product_source.dao.basic")
@SpringBootApplication
public class ProductSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductSourceApplication.class, args);
    }

}
