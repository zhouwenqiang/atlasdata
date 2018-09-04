package com.atlas.entity;

import com.atlas.util.DateUtils;
import com.atlas.util.RSAUtils;
import org.springframework.util.StringUtils;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/29.
 */
public class Terminal {
    private String appKey;
    private  String timeStamp;
    private  String userName;
    private  String contact_iccid;
    private String request_method;
    private String bat_id;
    private String send_time;
    private String date_begin;
    private String date_end;
    private String res_code;
    private String page_number;
    private String page_size;
    private String login_no;
    private String sign;
    private String  privatekey;


    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getTimeStamp() {
        if (StringUtils.isEmpty(timeStamp)){
            try {
                this.timeStamp= DateUtils.date2String(new Date(),DateUtils.yyyyMMddHHmmss);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContact_iccid() {
        return contact_iccid;
    }

    public void setContact_iccid(String contact_iccid) {
        this.contact_iccid = contact_iccid;
    }

    public String getRequest_method() {
        return request_method;
    }

    public void setRequest_method(String request_method) {
        this.request_method = request_method;
    }

    public String getBat_id() {
        return bat_id;
    }

    public void setBat_id(String bat_id) {
        this.bat_id = bat_id;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public String getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(String date_begin) {
        this.date_begin = date_begin;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getRes_code() {
        return res_code;
    }

    public void setRes_code(String res_code) {
        this.res_code = res_code;
    }

    public String getPage_number() {
        return page_number;
    }

    public void setPage_number(String page_number) {
        this.page_number = page_number;
    }

    public String getPage_size() {
        return page_size;
    }

    public void setPage_size(String page_size) {
        this.page_size = page_size;
    }

    public String getLogin_no() {
        return login_no;
    }

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
    }

    public void setLogin_no(String login_no) {
        this.login_no = login_no;
    }

    public String getSign() {
        try {
            sign=RSAUtils.toSign(toSignString(), privatekey);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    public String toSignString() {
        return
                "appKey=" + appKey +
                "&timeStamp=" + timeStamp +
                "&userName=" + userName +
                "&contact_iccid=" + contact_iccid +
                "&request_method=" + request_method +
                "&bat_id=" + bat_id +
                "&send_time=" + send_time +
                "&date_begin=" + date_begin +
                "&date_end=" + date_end +
                "&res_code=" + res_code +
                "&page_number=" + page_number +
                "&page_size=" + page_size +
                "&login_no=" + login_no
                ;
    }
    public  String toUrlString() throws Exception {
        appKey = StringUtils.isEmpty(getAppKey()) ? "" : getAppKey();
        timeStamp= StringUtils.isEmpty(getTimeStamp()) ? "" : getTimeStamp();
        userName = StringUtils.isEmpty(getUserName()) ? "" : getUserName();
        contact_iccid = StringUtils.isEmpty(getContact_iccid()) ? "" : getContact_iccid();
        request_method = StringUtils.isEmpty(getRequest_method()) ? "" : getRequest_method();
        bat_id =StringUtils.isEmpty(getBat_id()) ? "" : getBat_id();
        send_time = StringUtils.isEmpty(getSend_time()) ? "" : getSend_time();
        date_begin = StringUtils.isEmpty(getDate_begin()) ? "" : getDate_begin();
        date_end = StringUtils.isEmpty(getDate_end()) ? "" : getDate_end ();
        res_code = StringUtils.isEmpty(getRes_code()) ? "" : getRes_code();
        page_number =StringUtils.isEmpty(getPage_number()) ? "" : getPage_number();
        page_size = StringUtils.isEmpty(getPage_size()) ? "" : getPage_size();
        login_no =StringUtils.isEmpty(getLogin_no()) ? "" : getLogin_no();
        sign=getSign();
        return
                "appKey=" + appKey +
                "&timeStamp=" + timeStamp +
                "&userName=" + userName +
                "&contact_iccid=" + contact_iccid +
                "&request_method=" + request_method +
                "&bat_id=" + bat_id +
                "&send_time=" + send_time +
                "&date_begin=" + date_begin +
                "&date_end=" + date_end +
                "&res_code=" + res_code +
                "&page_number=" + page_number +
                "&page_size=" + page_size +
                "&login_no=" + login_no +
                "&sign=" + sign
                ;
    }
}
