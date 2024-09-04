package com.briup.product_source.web.controller;

import com.briup.product_source.aop.Logging;
import com.briup.product_source.bean.basic.BaseAccount;
import com.briup.product_source.service.AccountService;
import com.briup.product_source.util.Result;
import com.briup.product_source.util.ResultUtil;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.Map;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-28 18:55
 */
@Api(tags = "登录模块")
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    @ApiOperation("获取当前登录用户信息接口")

    /*@GetMapping("/me")
    public Result findLoginUser(HttpServletRequest request){*//*@RequestHeader String token*//*
        String token = request.getHeader("token");*/
    @GetMapping("/me")
    public Result findInfo(@RequestHeader String token){/*@RequestHeader String token*/
        BaseAccount baseAccount=accountService.findLoginUser(token);
        return ResultUtil.success(baseAccount);
    }
    @ApiOperation("退出登录接口")
    @ApiImplicitParam(name = "token",value = "请求头中的token")
    @GetMapping("/logout")
    public Result logout(@RequestHeader String token){
        return ResultUtil.success();
    }
    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = true),
            @ApiImplicitParam(name = "password",value = "密码",required = true)
    })
    @Logging(value = "用户登录操作")
    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Result<Map<String,String>> login(@RequestParam String username, @RequestParam String password){
        String jwt =accountService.login(username,password);
        return ResultUtil.success(ImmutableMap.of("token",jwt));
    }

}
