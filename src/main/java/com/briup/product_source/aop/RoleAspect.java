package com.briup.product_source.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-09-04 15:35
 * 模拟：当系统中执行删除操作时，要求用户是管理员
 * 对每个接口分配权限，是否是管理员操作
 */
@Component
@Aspect
public class RoleAspect {

}
