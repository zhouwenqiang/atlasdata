package com.atlas.util;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/8.
 */
public class ImeiInfo implements Serializable {

    @JsonProperty(value = "IMEI_NO")
    private String imei_no;

    @JSONField(name="IMEI_NO")
    @JsonIgnore
    public String getImei_no() {
        return imei_no;
    }

    public void setImei_no(String imei_no) {
        this.imei_no = imei_no;
    }
}
