package com.briup.product_source.web.controller;

import com.briup.product_source.service.LogService;
import com.briup.product_source.util.Result;
import com.briup.product_source.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-09-04 9:19
 */
@Api(tags = "日志模块")
@RestController
public class LogController {
    @Autowired
    private LogService logService;
    @ApiOperation("分页查询日志信息接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNum",value = "当前页码",required = true),
        @ApiImplicitParam(name = "pageSize",value = "每页大小",required = true)
    })
    @GetMapping("/log/page")
    public Result findLogByPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize, String originalIp){
        PageInfo pageInfo = logService.findByPage(originalIp, pageNum, pageSize);
        return ResultUtil.success(pageInfo);
    }
}
