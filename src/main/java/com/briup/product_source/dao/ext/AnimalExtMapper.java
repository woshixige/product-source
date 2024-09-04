package com.briup.product_source.dao.ext;

import com.briup.product_source.bean.ext.ManagerAnimalExt;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-30 9:40
 */
public interface AnimalExtMapper {
    void deleteByBatchId(@Param("ids") List<String> ids);
    //多条件查询动物的详细信息（基本信息和其关联的扩展信息）
    List<Map<String,Object>> findAnimalExtByCondition(@Param("aHealthy") String aHealthy, @Param("aGender") String aGender);
    /*根据id查询的动物信息只有一条，其实都可以不用mapkey
    注意这里的值是数据库的字段名
     */
    /*@MapKey("a_batch_id")
    Map<String,Map<String,Object>> findByAnimalId(@Param("id") String animalId);*/
    //既然返回值是用动物的扩展类来实现返回的，那直接用list集合存储这一行数据
    //Map<String,Object> findByAnimalId(@Param("id") String animalId);
    ManagerAnimalExt findByAnimalId(@Param("id") String animalId);




    void createQRcodeByAnimalId(@Param("animalId") String id, @Param("imgUrl") String base64String);
}
