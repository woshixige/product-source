package com.briup.product_source;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-24 16:17
 */
public class StringToLocalDateTime {
    @Test
    public void StringToDate(){
        // 假设这是你的时间字符串
        String timeStr = "2024-08-24 15:30:45";

        // 创建SimpleDateFormat实例，指定时间字符串的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            // 使用parse方法将字符串时间转换为Date对象
            // 注意：parse方法会抛出ParseException，如果字符串格式与指定的格式不匹配
            Date date = sdf.parse(timeStr);
            System.out.println(date); // 输出转换后的Date对象，默认输出格式依赖于JVM的Locale设置

            // 如果你需要特定的日期时间格式输出，可以再次使用SimpleDateFormat进行格式化
            SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = sdfOutput.format(date);
            System.out.println(formattedDate); // 输出格式化后的日期时间字符串
        } catch (ParseException e) {
            System.err.println("时间字符串格式错误: " + e.getMessage());
        }
    }
    @Test
    public void stringToLocalDateTime(){
        // 假设这是你的时间字符串
        String timeStr = "2024-08-24 15:30:45";

        // 创建DateTimeFormatter实例，指定时间字符串的格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 使用parse方法将字符串时间转换为LocalDateTime对象
        // 注意：parse方法会抛出DateTimeParseException，如果字符串格式与指定的格式不匹配
        try {
            LocalDateTime dateTime = LocalDateTime.parse(timeStr, formatter);
            System.out.println(dateTime); // 输出转换后的LocalDateTime对象
        } catch (java.time.format.DateTimeParseException e) {
            System.err.println("时间字符串格式错误: " + e.getMessage());
        }
    }
}
