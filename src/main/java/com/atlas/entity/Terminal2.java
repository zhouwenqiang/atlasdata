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
public class Terminal2 {
    private String appKey;
    private  String timeStamp;
    private  String userName;
    private  String contact_iccid;
    private String imei_no;
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

    public String getImei_no() {
        return imei_no;
    }

    public void setImei_no(String imei_no) {
        this.imei_no = imei_no;
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
                 "&imei_no=" + imei_no +
                "&login_no=" + login_no
                ;
    }
    public  String toUrlString() throws Exception {
        appKey = StringUtils.isEmpty(getAppKey()) ? "" : getAppKey();
        timeStamp= StringUtils.isEmpty(getTimeStamp()) ? "" : getTimeStamp();
        userName = StringUtils.isEmpty(getUserName()) ? "" : getUserName();
        contact_iccid = StringUtils.isEmpty(getContact_iccid()) ? "" : getContact_iccid();
        imei_no=  StringUtils.isEmpty(getImei_no()) ? "" : getImei_no() ;
        login_no =StringUtils.isEmpty(getLogin_no()) ? "" : getLogin_no();
        sign=getSign();
        return
                "appKey=" + appKey +
                "&timeStamp=" + timeStamp +
                "&userName=" + userName +
                "&contact_iccid=" + contact_iccid +
                "&imei_no=" + imei_no +
                "&login_no=" + login_no +
                "&sign=" + sign
                ;
    }
}
