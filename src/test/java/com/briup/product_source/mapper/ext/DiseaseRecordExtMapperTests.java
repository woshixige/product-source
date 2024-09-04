package com.briup.product_source.mapper.ext;

import com.briup.product_source.dao.ext.DiseaseRecordExtMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-09-01 21:44
 */
@SpringBootTest
public class DiseaseRecordExtMapperTests {
    @Autowired
    private DiseaseRecordExtMapper diseaseRecordExtMapper;
    @Test
    public void method(){
        diseaseRecordExtMapper.deleteByBatch(Arrays.asList(27,28));
    }
}
