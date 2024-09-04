package com.briup.product_source.bean.basic;

import lombok.Data;

@Data
public class Qrcode {
    private Integer qId;

    private String qAnimalId;

    private String qImageUrl;

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public String getqAnimalId() {
        return qAnimalId;
    }

    public void setqAnimalId(String qAnimalId) {
        this.qAnimalId = qAnimalId;
    }

    public String getqImageUrl() {
        return qImageUrl;
    }

    public void setqImageUrl(String qImageUrl) {
        this.qImageUrl = qImageUrl;
    }
}