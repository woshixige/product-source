package com.briup.product_source.bean.ext;

import com.briup.product_source.bean.basic.Batch;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-27 9:28
 */
@Data
public class ManagerAnimalExt {
    private String aAnimalId;

    private String aWeight;

    private String aGender;

    private String aHealthy;

    private String aStatus;

    private String aInoculate;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date aTime;

    private String aBatchId;

    private String aHurdlesId;
    //动物对应的栏圈名称
    private String  managerHurdles;
    //动物对应的栏舍名称
    private String managerFenceHouse;
    //动物对应的批次
    private Batch managerBatch;
}
