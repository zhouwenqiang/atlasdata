package com.atlas.entity;

/**
 * Created by Administrator on 2018/3/30.
 */
public class TerminalEquipment {
    private int te_id;
    private String mt_name;
    private String brand_name;
    private String te_model;
    private String te_name;
    private String model_code;
    private String tac_code;
    private String contact_information;
    private String remarks;
    private int enable;
    private int terminaltypeid;

    public int getTe_id() {
        return te_id;
    }

    public void setTe_id(int te_id) {
        this.te_id = te_id;
    }

    public String getMt_name() {
        return mt_name;
    }

    public void setMt_name(String mt_name) {
        this.mt_name = mt_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getTe_model() {
        return te_model;
    }

    public void setTe_model(String te_model) {
        this.te_model = te_model;
    }

    public String getTe_name() {
        return te_name;
    }

    public void setTe_name(String te_name) {
        this.te_name = te_name;
    }

    public String getModel_code() {
        return model_code;
    }

    public void setModel_code(String model_code) {
        this.model_code = model_code;
    }

    public String getTac_code() {
        return tac_code;
    }

    public void setTac_code(String tac_code) {
        this.tac_code = tac_code;
    }

    public String getContact_information() {
        return contact_information;
    }

    public void setContact_information(String contact_information) {
        this.contact_information = contact_information;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getTerminaltypeid() {
        return terminaltypeid;
    }

    public void setTerminaltypeid(int terminaltypeid) {
        this.terminaltypeid = terminaltypeid;
    }
}
