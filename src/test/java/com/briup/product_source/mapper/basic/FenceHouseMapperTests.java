package com.briup.product_source.mapper.basic;

import com.briup.product_source.bean.basic.FenceHouse;
import com.briup.product_source.bean.ext.FenceHouseExt;
import com.briup.product_source.dao.basic.FenceHouseMapper;
import com.briup.product_source.dao.ext.FenceHouseExtMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-24 14:25
 */
@SpringBootTest
public class FenceHouseMapperTests {
    @Autowired
    private FenceHouseMapper fenceHouseMapper;
    @Autowired
    private FenceHouseExtMapper fenceHouseExtMapper;
    @Test
    public void deleteBatch(){
        fenceHouseExtMapper.deleteByBatch(Arrays.asList("111","222"));
    }
/*    @Test
    public void method5(){
        // 假设这是你的时间字符串
        String timeStr = "2024-08-24 15:30:45";
        // 创建SimpleDateFormat实例，指定时间字符串的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            // 使用parse方法将字符串时间转换为Date对象
            // 注意：parse方法会抛出ParseException，如果字符串格式与指定的格式不匹配
            Date date = sdf.parse(timeStr);
            FenceHouse fenceHouse = new FenceHouse("111", "测试舍222", "测试测试222", date);
            fenceHouseMapper.updateFenceHouse(fenceHouse);
        } catch (ParseException e) {
            System.err.println("时间字符串格式错误: " + e.getMessage());
        }
    }
    @Test
    public void method4(){
        // 假设这是你的时间字符串
        String timeStr = "2024-08-24 15:30:45";

        // 创建SimpleDateFormat实例，指定时间字符串的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            // 使用parse方法将字符串时间转换为Date对象
            // 注意：parse方法会抛出ParseException，如果字符串格式与指定的格式不匹配
            Date date = sdf.parse(timeStr);
            FenceHouse fenceHouse = new FenceHouse("", "测试舍2", "测试测试2", date);
            fenceHouseMapper.insertFenceHouse(fenceHouse);
        } catch (ParseException e) {
            System.err.println("时间字符串格式错误: " + e.getMessage());
        }

    }*/
/*    @Test
    public void method4(){
        // 假设这是你的时间字符串
        String timeStr = "2024-08-24 15:30:45";

        // 创建SimpleDateFormat实例，指定时间字符串的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            // 使用parse方法将字符串时间转换为Date对象
            // 注意：parse方法会抛出ParseException，如果字符串格式与指定的格式不匹配
            Date date = sdf.parse(timeStr);
            FenceHouse fenceHouse = new FenceHouse("", "测试舍2", "测试测试2", date);
            fenceHouseMapper.saveOrUpdate(fenceHouse);
        } catch (ParseException e) {
            System.err.println("时间字符串格式错误: " + e.getMessage());
        }

    }*/
/*    @Test
    public void method3(){
        // 假设这是你的时间字符串
        String timeStr = "2024-08-24 15:30:45";

        // 创建SimpleDateFormat实例，指定时间字符串的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            // 使用parse方法将字符串时间转换为Date对象
            // 注意：parse方法会抛出ParseException，如果字符串格式与指定的格式不匹配
            Date date = sdf.parse(timeStr);
            FenceHouse fenceHouse = new FenceHouse("111", "修改测试舍", "修改测试测试", date);
            fenceHouseMapper.saveOrUpdate(fenceHouse);
        } catch (ParseException e) {
            System.err.println("时间字符串格式错误: " + e.getMessage());
        }
    }*/
    @Test
    public void method2(){
        FenceHouseExt byId = fenceHouseExtMapper.findById("851d58388f974d95b6c67d93189b7222");
        System.out.println(byId);
    }
    @Test
    public void method(){
        List<FenceHouse> fenceHouses = fenceHouseExtMapper.selectByCondition("保舍");
        System.out.println(fenceHouses);
    }
    @Test
    public void findByName(){
        FenceHouse fenceHouse = fenceHouseExtMapper.selectFenceHouseByName("保育舍");
        System.out.println(fenceHouse);
    }
}
