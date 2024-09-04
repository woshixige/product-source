package com.briup.product_source.bean.ext;

import com.briup.product_source.bean.basic.FenceHouse;
import com.briup.product_source.bean.basic.Hurdles;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FenceHouseExt extends FenceHouse {

    @JsonProperty("mhs") //将该属性的名称在前端显示的json改成括号里的名字
    private List<Hurdles> hurdlesList;



}