package com.briup.product_source.service.impl;

import com.briup.product_source.service.LogService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-09-04 9:24
 */
@Service
public class LogServiceImpl implements LogService {
    @Override
    public PageInfo findByPage(String host, Integer pageNum, Integer pageSize) {
        return null;
    }
}
