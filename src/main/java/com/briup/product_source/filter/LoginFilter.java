/*
package com.briup.product_source.filter;

import com.briup.product_source.exception.CustomException;
import com.briup.product_source.util.JwtUtil;
import com.briup.product_source.util.Result;
import com.briup.product_source.util.ResultCode;
import com.briup.product_source.util.ResultUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

*/
/**
 * @author zzx
 * @version 1.0
 * @date 2024-09-02 10:14
 *//*

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        boolean flag=false;
        Result result=null;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");
        String uri = request.getRequestURI();
        List<String> pathList = Arrays.asList("/login",
                "/swagger-resources",
                "/webjars",
                "/swagger-ui.html",
                "/login",
                "/csrf",
                "/error");
        flag = pathList.stream().anyMatch(path -> path.startsWith(uri));

        if (!flag){
            if (token==null){

                result = ResultUtil.error(ResultCode.USER_NOT_LOGIN);
            }
            try {
                flag=JwtUtil.checkSign(token);
            } catch (Exception e) {
                result = ResultUtil.error(ResultCode.USER_TOKEN_FAILURE);
            }
        }
        if (flag){
            filterChain.doFilter(servletRequest,servletResponse);

        }else {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            PrintWriter writer = response.getWriter();
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(result);
            writer.write(s);
        }





    }
}
*/
