package com.briup.product_source.service.impl;

import com.briup.product_source.bean.basic.FenceHouse;
import com.briup.product_source.bean.basic.Hurdles;
import com.briup.product_source.bean.ext.FenceHouseExt;
import com.briup.product_source.dao.basic.FenceHouseMapper;
import com.briup.product_source.dao.basic.HurdlesMapper;
import com.briup.product_source.dao.ext.FenceHouseExtMapper;
import com.briup.product_source.dao.ext.HurdlesExtMapper;
import com.briup.product_source.exception.CustomException;
import com.briup.product_source.service.FenceHouseService;
import com.briup.product_source.util.BriupAssert;
import com.briup.product_source.util.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

import static com.briup.product_source.util.ResultCode.*;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-24 13:55
 */
//@Transactional //事务管理，编译异常失效
//@Transactional(rollbackFor =Exception.class) 作用范围在Exception类和子类，包含编译异常
@Service
public class FenceHouseServiceImpl implements FenceHouseService {
    @Autowired
    private FenceHouseMapper fenceHouseMapper;
    @Autowired
    private FenceHouseExtMapper fenceHouseExtMapper;
    @Autowired
    private HurdlesExtMapper hurdlesExtMapper;

    @Override
    public PageInfo<FenceHouse> findByPage(int pageNum, int pageSize, String fhName) {
        //开启分页查询，并统计数据的总数
        /*PageHelper.startPage(pageNum, pageSize, true);
        List<FenceHouse> fenceHouses = fenceHouseExtMapper.selectByCondition(fhName);
        PageInfo<FenceHouse> pageInfo = new PageInfo<>(fenceHouses);
        return pageInfo;*/
        return PageHelper.startPage(pageNum,pageSize,true).doSelectPageInfo(()->fenceHouseExtMapper.selectByCondition(fhName));
    }

    @Override
    public FenceHouseExt findById(String id) {
        FenceHouseExt fenceHouseExt = fenceHouseExtMapper.findById(id);
        return fenceHouseExt;
    }

    @Override
    public void saveOrUpdate(FenceHouse fenceHouse) {
        String fhId = fenceHouse.getFhId();
        //StringUtils Assert
        //名字不能为空，描述不能为空
        BriupAssert.hasText(fenceHouse.getFhName(), NAME_NOT_EMPTY);
        BriupAssert.hasText(fenceHouse.getFhDesc(),DESC_NOT_EMPTY);
        if (fhId==null){//新增栏舍
            String uuid = UUID.randomUUID().toString().replace("-", "");
            fenceHouse.setFhId(uuid);
            fenceHouseMapper.insert(fenceHouse);
        }else {//修改栏舍
            fenceHouseMapper.updateByPrimaryKey(fenceHouse);
        }

    }

    @Override
    public void deleteById(String id) {
        //脏数据没有刷新
        FenceHouse fenceHouse = fenceHouseMapper.selectByPrimaryKey(id);
        BriupAssert.notNull(fenceHouse,DATA_NOT_EXSISTS);
        //在代码层面，删除的表关联其他表
        //先删除关联的表数据 级联置空
        hurdlesExtMapper.updateNull(fenceHouse.getFhId());
        //删除
        fenceHouseMapper.deleteByPrimaryKey(id);
    }
    //@Transactional(rollbackFor =Exception.class) //作用范围在Exception类和子类，包含编译异常
    @Override
    public void deleteByBatch(List<String> ids) {
        for (String id : ids) {
            FenceHouseExt fenceHouseExt = fenceHouseExtMapper.findById(id);
            if (fenceHouseExt!=null){//解决空指针问题，万一查询的数据没有栏圈信息，就空指针了
                List<Hurdles> mhs = fenceHouseExt.getHurdlesList();
                for (Hurdles mh : mhs) {
                    if (mh !=null){
                        throw new CustomException(FENCE_INNER_HURDLE_NOT_NULL);
                    }
                }
            }
        }
        fenceHouseExtMapper.deleteByBatch(ids);
    }


    @Override
    public FenceHouse selectFenceHouseByName(String fhName) {
        FenceHouse fenceHouse=fenceHouseExtMapper.selectFenceHouseByName(fhName);
        return fenceHouse;
    }
}
