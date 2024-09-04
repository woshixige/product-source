package com.briup.product_source.service.impl;

import com.briup.product_source.bean.basic.Disease;
import com.briup.product_source.bean.basic.DiseaseRecord;
import com.briup.product_source.bean.ext.DiseaseRecordExt;
import com.briup.product_source.dao.ext.DiseaseRecordExtMapper;
import com.briup.product_source.service.DiseaseRecordService;
import com.briup.product_source.util.BriupAssert;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.briup.product_source.util.ResultCode.*;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-09-01 21:30
 */
@Service
public class DiseaseRecordServiceImpl implements DiseaseRecordService {
    @Autowired
    private DiseaseRecordExtMapper diseaseRecordExtMapper;
    @Override
    public List<Disease> findAll() {
        return null;
    }

    @Override
    public PageInfo<DiseaseRecordExt> findByPage(Integer pageNum, Integer pageSize, String drStatus, Integer drDId) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByBatch(List<Integer> ids) {
        BriupAssert.isTure(ids.size()!=0,ID_IS_NULL);
        for (Integer id : ids) {
            DiseaseRecord diseaseRecord = diseaseRecordExtMapper.selectByPrimaryKey(id);
            BriupAssert.notNull(diseaseRecord,DISEASE_ID_NOT_FIND);
        }
        diseaseRecordExtMapper.deleteByBatch(ids);
    }

    @Override
    public void saveOrUpdate(DiseaseRecord record) {

    }
}
