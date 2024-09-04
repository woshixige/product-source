package com.briup.product_source.web.controller;

import com.briup.product_source.bean.basic.FenceHouse;
import com.briup.product_source.bean.ext.FenceHouseExt;
import com.briup.product_source.service.FenceHouseService;
import com.briup.product_source.util.Result;
import com.briup.product_source.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.REUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-24 13:50
 */
@Api(tags = "栏舍管理")
@RestController
@RequestMapping("/fenceHouse")
public class FenceHouseController {
    @Autowired
    private FenceHouseService fenceHouseService;

    @ApiOperation("分页多条件查询栏舍信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true),
            @ApiImplicitParam(name = "fhName", value = "栏舍名字")
    })
    @GetMapping("/query")
    public Result findByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, String fhName) {
        PageInfo<FenceHouse> pageInfo = fenceHouseService.findByPage(pageNum, pageSize, fhName);
        return ResultUtil.success(pageInfo);
    }

    @ApiOperation("根据栏舍编号查询栏舍信息以及栏圈信息接口")
    @ApiImplicitParam(name = "fhId", value = "栏舍编号", required = true)
    @GetMapping("/selectById")
    public Result findById(@RequestParam(required = true) String fhId) {
        FenceHouseExt fenceHouseExt = fenceHouseService.findById(fhId);
        return ResultUtil.success(fenceHouseExt);
    }
    @ApiOperation("新增或修改栏舍接口")
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody FenceHouse fh){
        fenceHouseService.saveOrUpdate(fh);
        return ResultUtil.success();
    }
    @ApiOperation("批量删除栏舍接口")
    @DeleteMapping("/deleteByIdAll")
    public Result deleteByIdAll(@RequestBody List<String> ids){
        fenceHouseService.deleteByBatch(ids);
        return ResultUtil.success();
    }

    @ApiOperation("根据id删除栏舍信息接口")
    //方法的参数和前端传递的参数不同时用前端的参数hId
    @ApiImplicitParam(name = "hId",value = "栏舍编号",required = true)
    @DeleteMapping("/deleteById/{hId}")
    public Result deleteById(@PathVariable("hId") String id){
        fenceHouseService.deleteById(id);
        return ResultUtil.success();
    }
    /**
     * 1.修改栏舍时，栏舍的名称不能重复
     * 2.参数中如果包含fhId栏舍编号，表示修改操作，否则就是新增操作
     *
     * @param fhId
     * @param fhName
     * @param fhDesc
     * @param fhTime
     * @return
     */
    /*@ApiOperation("新增或修改栏舍接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fhId", value = "栏舍编号", required = false),
            @ApiImplicitParam(name = "fhName", value = "栏舍名称", required = true),
            @ApiImplicitParam(name = "fhDesc", value = "栏舍描述信息", required = true),
            @ApiImplicitParam(name = "fhTime", value = "创建时间", required = false)
    })
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody String fhId, @RequestParam String fhName, @RequestParam String fhDesc, String fhTime) {
        //新增栏舍时，栏舍的名称不能重复
        if (fhId == null) {
            FenceHouse fenceHouse = fenceHouseService.selectFenceHouseByName(fhName);
            if (fenceHouse != null) {
                throw new RuntimeException("栏舍的名称已存在，请重新添加名称");
            }
        }
        //修改栏舍时，栏舍的名称不能重复
        if (fhId != null) {
            PageInfo<FenceHouse> byPage = fenceHouseService.findByPage(0, 2, "");
            List<FenceHouse> list = byPage.getList();
            for (FenceHouse fenceHouse : list) {
                if (fenceHouse.getFhName().equals(fhName)){
                    throw new RuntimeException("该栏舍名称已存在，请换一个名字");
                }
            }
        }

        // 假设这是你的时间字符串
        //String timeStr = "2024-08-24 15:30:45";

        // 创建SimpleDateFormat实例，指定时间字符串的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            // 使用parse方法将字符串时间转换为Date对象
            // 注意：parse方法会抛出ParseException，如果字符串格式与指定的格式不匹配
            Date date = sdf.parse(fhTime);
            *//*System.out.println(date); // 输出转换后的Date对象，默认输出格式依赖于JVM的Locale设置

            // 如果你需要特定的日期时间格式输出，可以再次使用SimpleDateFormat进行格式化
            SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = sdfOutput.format(date);*//*
            //System.out.println(formattedDate); // 输出格式化后的日期时间字符串
            FenceHouse fenceHouse = new FenceHouse(fhId, fhName, fhDesc, date);
            fenceHouseService.saveOrUpdate(fenceHouse);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("时间字符串格式错误");
            //System.err.println("时间字符串格式错误: " + e.getMessage());
        }
        return ResultUtil.success();

    }*/


}
