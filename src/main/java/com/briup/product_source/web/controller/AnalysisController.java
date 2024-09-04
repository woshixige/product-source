package com.briup.product_source.web.controller;

import com.briup.product_source.service.AnalysisService;
import com.briup.product_source.util.Result;
import com.briup.product_source.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 首页大屏控制器类：
 * 如何编写控制器代码：阅读接口文档中每个请求对应的信息设置对应的映射方法
 */
@Api(tags = "首页大屏")
@RestController
@RequestMapping("/analysis")
public class AnalysisController {
    //4个方法...
    //
    @Autowired
    private AnalysisService analysisService;
    @ApiOperation("统计数量")
    @GetMapping("/count")
    public Result count(){
        Map<String, List<Object>> map=analysisService.countNum();
        return ResultUtil.success(map);
    }
    @ApiOperation("统计动物体重")
    @GetMapping("/indexCount")
    public Result countWeight(){
        Map<String,Integer> map=analysisService.countWeight();
        return ResultUtil.success(map);
    }
    @ApiOperation("统计动物病症数量接口")
    @GetMapping("/countDisease")
    public Result countDisease(){
        Map<String,Integer> map=analysisService.countDisease();
        return ResultUtil.success(map);
    }
    @ApiOperation("统计本年度12个月销售动物接口")
    @GetMapping("/countSales")
    public Result countSales(){
        Map<String,List<Object>> map=analysisService.countSales();
        return ResultUtil.success(map);
    }



}
