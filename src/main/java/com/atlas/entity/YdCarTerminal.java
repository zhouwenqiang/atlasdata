package com.atlas.entity;

/**
 * Created by Administrator on 2018/3/22.
 */
public class YdCarTerminal {
    private int CT_ID;
    private String CT_CODE;
    private String CT_TYPE;
    private String CT_SIM;
    private String CT_TXID;
    private int TEAM_ID;
    private String CT_STATE;
    private String CT_SIM_SIGN;

    public int getCT_ID() {
        return CT_ID;
    }

    public void setCT_ID(int CT_ID) {
        this.CT_ID = CT_ID;
    }

    public String getCT_CODE() {
        return CT_CODE;
    }

    public void setCT_CODE(String CT_CODE) {
        this.CT_CODE = CT_CODE;
    }

    public String getCT_TYPE() {
        return CT_TYPE;
    }

    public void setCT_TYPE(String CT_TYPE) {
        this.CT_TYPE = CT_TYPE;
    }

    public String getCT_SIM() {
        return CT_SIM;
    }

    public void setCT_SIM(String CT_SIM) {
        this.CT_SIM = CT_SIM;
    }

    public String getCT_TXID() {
        return CT_TXID;
    }

    public void setCT_TXID(String CT_TXID) {
        this.CT_TXID = CT_TXID;
    }

    public int getTEAM_ID() {
        return TEAM_ID;
    }

    public void setTEAM_ID(int TEAM_ID) {
        this.TEAM_ID = TEAM_ID;
    }

    public String getCT_STATE() {
        return CT_STATE;
    }

    public void setCT_STATE(String CT_STATE) {
        this.CT_STATE = CT_STATE;
    }

    public String getCT_SIM_SIGN() {
        return CT_SIM_SIGN;
    }

    public void setCT_SIM_SIGN(String CT_SIM_SIGN) {
        this.CT_SIM_SIGN = CT_SIM_SIGN;
    }
}
