package com.atlas.entity;

import java.util.Date;

public class YdLogOperation {
    private int logId;

    private String logName;

    private String logType;

    private String logContent;

    private Date logDate;

    private String logAccount;

    private int centerId;

    private String logAccountIp;

    private Long logVehicle;

    private String logCph;

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getLogAccount() {
        return logAccount;
    }

    public void setLogAccount(String logAccount) {
        this.logAccount = logAccount;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getLogAccountIp() {
        return logAccountIp;
    }

    public void setLogAccountIp(String logAccountIp) {
        this.logAccountIp = logAccountIp;
    }

    public Long getLogVehicle() {
        return logVehicle;
    }

    public void setLogVehicle(Long logVehicle) {
        this.logVehicle = logVehicle;
    }

    public String getLogCph() {
        return logCph;
    }

    public void setLogCph(String logCph) {
        this.logCph = logCph;
    }
}