package com.briup.product_source.service.impl;

import com.briup.product_source.aop.Logging;
import com.briup.product_source.bean.basic.BaseAccount;
import com.briup.product_source.dao.basic.BaseAccountMapper;
import com.briup.product_source.dao.ext.BaserAccountExtMapper;
import com.briup.product_source.exception.CustomException;
import com.briup.product_source.service.AccountService;
import com.briup.product_source.util.BriupAssert;
import com.briup.product_source.util.JwtUtil;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.briup.product_source.constant.BriupConstant.ACCOUNT_ENABLE;
import static com.briup.product_source.constant.BriupConstant.ACCOUNT_UNENABLE;
import static com.briup.product_source.util.ResultCode.*;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-28 18:59
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BaseAccountMapper baseAccountMapper;
    @Autowired
    private BaserAccountExtMapper baserAccountExtMapper;
    /*
        1.当用户名错误时，提示用户名不存在
        2.当用户密码错误时,提示用户密码错误
        3.当用户状态为锁定时，提示用户账号状态锁定，无法登录
     */
    @Override
    public String login(String username, String password) {
        BaseAccount user=baserAccountExtMapper.findUserByName(username);
        //BriupAssert.notNull(user,FIND_USER_NULL);
        if (user!=null){//查询到用户
            //比较密码是否正确
            //Objects.equals(password,user.getPassword());
            if (user.getPassword().equals(password)){//正确 生成jwt令牌
                //状态是否异常
                /*if (user.getStatus()==ACCOUNT_UNENABLE){
                    throw new CustomException(USER_DISABLED);
                }*/
                //使用自定义的断言简化代码
                BriupAssert.isTure(user.getStatus()==ACCOUNT_ENABLE,USER_DISABLED);
                /*Map<String, Object> map = new HashMap<>();
                map.put("username",username);*/
                ImmutableMap map = ImmutableMap.of("username", username);
                //可以用用户名和id生成 jwt，只要保证签名的唯一性就可以了
                String jwt = JwtUtil.sign("username", map);
                return jwt;
            }else {
                throw new CustomException(PASSWORD_ERROR);
            }


        }else {//没有该用户
            throw new CustomException(FIND_USER_NULL);
        }
        //获得里面的用户名和密码
        //通过名字查询用户信息
        //获取该用户名对应的密码
        //比较用户名和密码是否一致
        //一致返回用用户名生成的jwt
    }

    @Override
    public BaseAccount findLoginUser(String token) {
        Map<String, Object> map = JwtUtil.getInfo(token);
        if (map !=null){//该token查询不到，map为空，解决空指针问题
            //token里面放置了用户名信息，可以通过用户名来查询用户信息并返回
            String username = (String) map.get("username");
            BaseAccount user = baserAccountExtMapper.findUserByName(username);
            return user;
        }
        return null;
/*        String userId = JwtUtil.getUserId(token);
        return baseAccountMapper.selectByPrimaryKey(userId);*/
    }
}
