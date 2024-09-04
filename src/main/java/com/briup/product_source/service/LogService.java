package com.briup.product_source.service;

import com.github.pagehelper.PageInfo;

/**
 * 日志业务接口
 */
public interface LogService {
    /**
     * 分页查询日志信息
     * @param host   用户访问的ip地址
     * @param pageNum  当前页码
     * @param pageSize 每页大小
     * @return 分页数据
     */
    PageInfo findByPage(String host, Integer pageNum, Integer pageSize);
}