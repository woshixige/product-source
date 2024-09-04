package com.briup.product_source.config;

import com.briup.product_source.interceptor.LoginInterceptor;
import com.briup.product_source.web.interceptor.JWTInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springboot配置类
 *
 * @author zzx
 * @version 1.0
 * @date 2024-08-28 11:33
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private JWTInterceptor jwtInterceptor;

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册器registry 把指定的拦截器添加到springboot中
        System.out.println("注册拦截器");
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/v2/api-docs/**",
                        "/swagger-ui.html",
                        "/login",
                        "/csrf",
                        "/error",
                        "/log/page");//请求路径的拦截规则
    }

    /**
     * 解决跨域问题（还是之前的代码，没有修改）
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
        // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
        // 是否允许cookie
                .allowCredentials(true)
        // 设置允许的请求方式
                .allowedMethods("GET", "POST", "DELETE",
                        "PUT", "HEAD", "OPTIONS")
        // 设置允许的header属性
                .allowedHeaders("*")
        // 跨域允许时间
                .maxAge(3600);
    }
}
