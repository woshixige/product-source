package com.briup.product_source.web.controller;

import com.briup.product_source.bean.basic.Animal;
import com.briup.product_source.bean.ext.AnimalExt;
import com.briup.product_source.bean.ext.ManagerAnimalExt;
import com.briup.product_source.service.AnimalService;
import com.briup.product_source.util.Result;
import com.briup.product_source.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-27 9:07
 */
@Api(tags = "动物管理")
@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;
    @ApiOperation("新增或修改动物接口")
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody Animal animal){
        animalService.saveOrUpdate(animal);
        return ResultUtil.success();
    }
    @ApiOperation("批量删除动物接口")
    @DeleteMapping("/deleteByIdAll")
    public Result deleteByIdAll(@RequestBody List<String> ids){
        animalService.deleteById(ids);
        return ResultUtil.success();
    }
    @ApiOperation("根据ID删除动物接口")
    @ApiImplicitParam(name = "aAnimalId",value = "动物编号",required = true)
    @DeleteMapping("/deleteById/{aAnimalId}")
    public Result deleteById(@PathVariable String aAnimalId){
        animalService.deleteById(aAnimalId);
        return ResultUtil.success();
    }
    @ApiOperation("分页并根据条件查询动物基本信息以及对应批次和栏圈信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页大小",required = true),
            @ApiImplicitParam(name = "aHealthy",value = "健康状态",required = false),
            @ApiImplicitParam(name = "aGender",value = "性别",required = false)
    })
    @GetMapping("/query")
    public Result findByPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,String aHealthy,String aGender){
        PageInfo<AnimalExt> pageInfo=animalService.findByPage(pageNum,pageSize,aHealthy,aGender);
        return ResultUtil.success(pageInfo);
    }
    @ApiOperation("根据动物编号查询动物基本信息以及对应批次和栏舍栏圈信息")
    @ApiImplicitParam(name = "animalId",value = "动物编号",required = true)
    @GetMapping("/findByAnimalId")
    public Result findByAnimalId(@RequestParam String animalId){
        ManagerAnimalExt managerAnimalExt = animalService.findById(animalId);
        return ResultUtil.success(managerAnimalExt);
    }
    @ApiOperation("根据动物ID生成对应的二维码信息接口")
    @ApiImplicitParam(name = "animalId",value = "动物编号",required = true)
    @GetMapping("/QRcode")
    public Result createQRcodeByAnimalId(@RequestParam String animalId){
        animalService.createQRcodeByAnimalId(animalId);
        return ResultUtil.success();
    }



}
