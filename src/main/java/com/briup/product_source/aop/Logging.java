package com.briup.product_source.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-09-04 9:15
 * 日志注解
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {
    //用户日志操作的含义
    String value() default "";
}
