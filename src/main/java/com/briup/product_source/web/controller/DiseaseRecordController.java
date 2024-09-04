package com.briup.product_source.web.controller;

import com.briup.product_source.service.DiseaseRecordService;
import com.briup.product_source.util.Result;
import com.briup.product_source.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-09-01 21:27
 */
@Api(tags = "病症记录")
@RestController
@RequestMapping("/diseaseRecord")
public class DiseaseRecordController {
    @Autowired
    private DiseaseRecordService diseaseRecordService;
    @ApiOperation("批量删除病症记录接口")
    @DeleteMapping("/deleteByIdAll")
    public Result deleteByBatch(@RequestBody List<Integer> ids){
        diseaseRecordService.deleteByBatch(ids);
        return ResultUtil.success();
    }
    
}
