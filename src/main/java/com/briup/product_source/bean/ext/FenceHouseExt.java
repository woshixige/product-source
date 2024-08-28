package com.briup.product_source.bean.ext;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FenceHouseExt {
    private String fhId;

    private String fhName;

    private String fhDesc;

    private Date fhTime;

    public String getFhId() {
        return fhId;
    }

    public void setFhId(String fhId) {
        this.fhId = fhId;
    }

    public String getFhName() {
        return fhName;
    }

    public void setFhName(String fhName) {
        this.fhName = fhName;
    }

    public String getFhDesc() {
        return fhDesc;
    }

    public void setFhDesc(String fhDesc) {
        this.fhDesc = fhDesc;
    }

    public Date getFhTime() {
        return fhTime;
    }

    public void setFhTime(Date fhTime) {
        this.fhTime = fhTime;
    }
}