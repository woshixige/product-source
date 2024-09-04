package com.briup.product_source.service;

import com.briup.product_source.bean.basic.Disease;
import com.briup.product_source.bean.basic.DiseaseRecord;
import com.briup.product_source.bean.ext.DiseaseRecordExt;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 病症记录管理
 */
public interface DiseaseRecordService {
    /**
     * 查询所有病症类型信息
     * @return
     */
    List<Disease> findAll();
    /**
     * 分页多条件查询多条病症记录，病症记录中包含病症类型信息
     * @param pageNum 当前页码
     * @param pageSize 每页大小
     * @param drStatus 治疗状态
     * @param drDId 病症类型编号
     * @return 分页数据  思考如何设计DiseaseRecordExt表实现包含病症类型信息
     */
    PageInfo<DiseaseRecordExt> findByPage(Integer pageNum, Integer pageSize, String drStatus, Integer drDId);
    /**
     * 根据记录ID删除病症记录
     * @param id
     */
    void deleteById(Integer id);
    /**
     * 批量删除病症记录
     * @param ids 记录id
     */
    void deleteByBatch(List<Integer> ids);
    /**
     * 新增或更新病症记录
     * @param record 病症记录信息
     */
    void saveOrUpdate(DiseaseRecord record);


}