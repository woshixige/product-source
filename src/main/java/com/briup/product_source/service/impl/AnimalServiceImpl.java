package com.briup.product_source.service.impl;

import com.briup.product_source.bean.basic.Animal;
import com.briup.product_source.bean.basic.Hurdles;
import com.briup.product_source.bean.ext.AnimalExt;
import com.briup.product_source.bean.ext.ManagerAnimalExt;
import com.briup.product_source.dao.basic.AnimalMapper;
import com.briup.product_source.dao.basic.HurdlesMapper;
import com.briup.product_source.dao.ext.AnimalExtMapper;
import com.briup.product_source.exception.CustomException;
import com.briup.product_source.service.AnimalService;
import com.briup.product_source.util.BriupAssert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import static com.briup.product_source.util.ResultCode.*;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-27 9:40
 */
@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalMapper animalMapper;
    @Autowired
    private AnimalExtMapper animalExtMapper;
    @Autowired
    private HurdlesMapper hurdlesMapper;
    @Override
    public void saveOrUpdate(Animal animal) {
        String hurdlesId = animal.getaHurdlesId();
        if(animal.getaAnimalId()==null){//新增操作
            String uuid = UUID.randomUUID().toString().replace("-", "");
            animal.setaAnimalId(uuid);
            animal.setaTime(new Date());
            //根据动物栏圈id查询该栏圈id下的栏圈是否已满，如果未满则添加量，如果已满则返回 插入失败,该栏圈已存满
            Hurdles hurdles = hurdlesMapper.selectByPrimaryKey(hurdlesId);
            //不能向不存在的栏舍插入动物，栏舍为空
            BriupAssert.notNull(hurdles,HURDLE_NOT_EXIST);
            if (hurdles.gethSaved()==hurdles.gethMax()){//栏圈已满
                throw new CustomException(HURDLE_IS_FULL);
            }else {
                animalMapper.insert(animal);
            }
        }else {//修改操作
            animalMapper.updateByPrimaryKey(animal);
        }
    }

    @Override
    public void deleteById(String id) {
        animalMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteById(List<String> ids) {
        animalExtMapper.deleteByBatchId(ids);
    }

    @Override
    public PageInfo<AnimalExt> findByPage(Integer pageNum, int pageSize, String aHealthy, String aGender) {
        PageInfo<AnimalExt> pageInfo=PageHelper
                .startPage(pageNum,pageSize,true)
                .doSelectPageInfo(()->animalExtMapper.findAnimalExtByCondition(aHealthy,aGender));
        return pageInfo;
    }

    @Override
    public ManagerAnimalExt findById(String id) {
        return animalExtMapper.findByAnimalId(id);
    }

    @Override
    public String createQRcodeByAnimalId(String id) {
        BriupAssert.hasText(id,ANIMAL_ID_NULL);
        try {
            // 创建一个包含二维码配置的Hashtable
            Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
            hints.put(EncodeHintType.CHARACTER_SET, StandardCharsets.UTF_8.name());

            // 使用ZXing库的QRCodeWriter生成二维码
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(id, BarcodeFormat.QR_CODE, 200, 200, hints);

            // 将BitMatrix转换为二维码图片
            OutputStream os = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", os);

            // 将二维码图片转换为Base64字符串
            byte[] pngImage = ((ByteArrayOutputStream) os).toByteArray();
            String base64String = Base64.getEncoder().encodeToString(pngImage);

            ///return base64String;
            animalExtMapper.createQRcodeByAnimalId(id,base64String);
            return base64String;
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "暂无";
    }
}
