package com.briup.product_source.aop;

import com.briup.product_source.bean.basic.BaseAccount;
import com.briup.product_source.bean.basic.Log;
import com.briup.product_source.dao.basic.BaseAccountMapper;
import com.briup.product_source.dao.basic.LogMapper;
import com.briup.product_source.util.JwtUtil;
import com.briup.product_source.web.interceptor.JWTInterceptor;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-09-04 9:14
 */
@Slf4j
@Component
@Aspect
public class LogAspect {
    @Autowired
    private HttpServletRequest httpServletRequest;//从ioc容器中获取
    @Autowired
    private LogMapper logMapper;
    @Autowired
    private BaseAccountMapper baseAccountMapper;

    @Pointcut("execution(* com.briup.product_source.web.controller.*.*(..)) && " +
            "@annotation(Logging)")
    public void logPointCut() {

    }

    //用前置通知，完成日志记录
    @Before("logPointCut()")
    public void beforeAdvice() {
        //获取用户的日志信息
        String method = httpServletRequest.getMethod();
        String requestURI = httpServletRequest.getRequestURI();
        String ip = httpServletRequest.getRemoteHost();
        //String remoteAddr = httpServletRequest.getRemoteAddr();
        Date date = new Date();
        String token = httpServletRequest.getHeader("token");
        String username = null;
        String realname = null;
        if (token == null) {//登录
            username = httpServletRequest.getParameter("username");
            BaseAccount user = baseAccountMapper.findUserByName(username);
            if (user!=null){
                realname=user.getRealname();
            }
        } else {
            String userId = JwtUtil.getUserId(token);
            BaseAccount user = baseAccountMapper.selectByPrimaryKey(userId);
            username = user.getUsername();
            realname = user.getRealname();
        }
        Log log = Log.builder()
                .logRealname(realname)
                .logTime(date)
                .logUsername(username)
                .logHost(ip)
                .logRequestUri(requestURI)
                .logRequestMethod(method).build();
        /*Log log = new Log();
        log.setLogHost(ip);
        log.setLogRealname(realname);
        log.setLogTime(date);
        log.setLogUsername(username);
        log.setLogRequestMethod(method);
        log.setLogRequestUri(requestURI);*/
        logMapper.insertSelective(log);
        //
    }
    /*@After("logPointCut()")
    public Object afterAdvice(ProceedingJoinPoint pjp) throws Throwable {
        //连接点执行的核心方法
        Object ret = pjp.proceed();
        return ret;
    }*/
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        Method method = signature.getMethod();
        //获取method上面的注解信息
        /*ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        String methodDesc = apiOperation.value();
        log.info("当前用户的操作：{}",methodDesc);*/
        Logging logging = method.getAnnotation(Logging.class);
        String methodDesc = logging.value();
        log.info("当前用户的操作：{}",methodDesc);
        Object[] args = pjp.getArgs();
        log.info("当前用户的参数：{}",args);
        Object result = pjp.proceed();
        return result;
    }
}
