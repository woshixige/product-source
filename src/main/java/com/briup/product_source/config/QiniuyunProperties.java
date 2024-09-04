package com.briup.product_source.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-29 12:17
 */
@Data
@Component
@ConfigurationProperties(prefix = "qiniuyun")
public class QiniuyunProperties {

    private String accessKey;//dir值通过读取配置file.upload.dir值赋值给组件对象属性

    private String secretKey;

    private String bucket;
}
