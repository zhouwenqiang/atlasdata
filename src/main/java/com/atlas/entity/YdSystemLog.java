package com.atlas.entity;

import java.util.Date;

public class YdSystemLog {
    private int slId;

    private int slCode;

    private String slObject;

    private int slType;

    private String slContent;

    private Date slDate;

    private String slAccount;

    private int centerId;

    public int getSlId() {
        return slId;
    }

    public void setSlId(int slId) {
        this.slId = slId;
    }

    public int getSlCode() {
        return slCode;
    }

    public void setSlCode(int slCode) {
        this.slCode = slCode;
    }

    public String getSlObject() {
        return slObject;
    }

    public void setSlObject(String slObject) {
        this.slObject = slObject;
    }

    public int getSlType() {
        return slType;
    }

    public void setSlType(int slType) {
        this.slType = slType;
    }

    public String getSlContent() {
        return slContent;
    }

    public void setSlContent(String slContent) {
        this.slContent = slContent;
    }

    public Date getSlDate() {
        return slDate;
    }

    public void setSlDate(Date slDate) {
        this.slDate = slDate;
    }

    public String getSlAccount() {
        return slAccount;
    }

    public void setSlAccount(String slAccount) {
        this.slAccount = slAccount;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }
}