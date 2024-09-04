package com.briup.product_source.bean.ext;

import com.briup.product_source.bean.basic.Animal;
import com.briup.product_source.bean.basic.Batch;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-27 9:16
 */
@Data
public class AnimalExt {
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
    //栏圈
    private String managerHurdles;
    //栏舍
    private String managerFenceHouse;
    //二维码http://localhost:8082/image/aa22df4e-bcb7-4e0f-9bd2-df2b63779fee.jpg
    private String aBackup3;
    //批次信息
    private Batch managerBatch;
}
