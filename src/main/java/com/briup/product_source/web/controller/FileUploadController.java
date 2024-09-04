package com.briup.product_source.web.controller;

import com.briup.product_source.config.UploadProperties;
import com.briup.product_source.util.OSSUtil;
import com.briup.product_source.util.Result;
import com.briup.product_source.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-28 20:40
 */
@Api(tags = "文件上传")
@RestController
public class FileUploadController {
    @Autowired
    private OSSUtil ossUtil;
    @ApiOperation("文件上传接口")
    @PostMapping(value = "/file/upload")
    public Result upload(@RequestPart MultipartFile file) throws IOException {
        InputStream is = file.getInputStream();
        String fileName = file.getOriginalFilename();
        String newFileName = ossUtil.upload(fileName, is);
        return ResultUtil.success(newFileName);
        /*//获取文件名
        String fileName = file.getOriginalFilename();
        //拼接uuid，保证图片名字的唯一性，防止被覆盖
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String newFileName = uuid + fileName;

        String pathName = prop.getDir() + newFileName;
        //将其他文件夹上的图片或文件上传至该路径（路径和图片、文件名）
        file.transferTo(new File(pathName));
        FileInputStream fis = new FileInputStream(pathName);
        *//*byte[] bytes = new byte[1024];
        while ((fis.read(bytes))!=-1){

        }*//*
        OSSUtil qiniuyunUtil = new OSSUtil();
        qiniuyunUtil.upload(newFileName, fis);
        return ResultUtil.success(newFileName);*/
    }
}
