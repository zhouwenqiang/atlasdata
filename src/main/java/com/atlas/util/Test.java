package com.atlas.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.atlas.entity.Terminal;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Administrator on 2018/3/28.
 */
public class Test {
    public static void main(String[] args) {
        try {
            /*String PUBLICKEY="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCuLVNak4CUXxissWWC8Q3MhgK9Eg6Ctp5y6rUH98S0QvMtKChd6bGKz8L6yqj9hqCnUlgN5ZDhG83g6ZrqGFCA8LR36qoRXVKktKYtFotCb9NIAU1da1EFIkNPUbcsPNwsaPF2+e8ho3M1Aq2nHwkYsdD3H+aFXuiV1AJIpWNu8QIDAQAB";
            String PRIVATEKEY="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK4tU1qTgJRfGKyxZYLxDcyGAr0SDoK2nnLqtQf3xLRC8y0oKF3psYrPwvrKqP2GoKdSWA3lkOEbzeDpmuoYUIDwtHfqqhFdUqS0pi0Wi0Jv00gBTV1rUQUiQ09Rtyw83Cxo8Xb57yGjczUCracfCRix0Pcf5oVe6JXUAkilY27xAgMBAAECgYEAk/V88VyLxX5i/5BSo0ESb8MHYIWOPgvT3drznakkN90HpjyOzfhPEZQcFd9CXtuWbYzNsEBrKk7sPTs0ldfByd+6zsJ7V3LqFqfd1GtHrvBAmHlAOqRvDZ0kjBBwPPlDNwoDMc3E640nBLKpj7nXlSBZd7b0AHpXH9OLQr7F5mECQQDaT7U6l65xqKabSURVlQCh3JRGUAkAtp1qnnPanGOIEa5+PjZjSjXKmJecgQky/mo7fkg3Dvct0KoeehK6fYJjAkEAzD8ZAJazMpUETpwW4SGxMhAeVJJV5zq2iEoPykKQAr3V9ejxkNZ3l0mz56wSjsDa3UJZfQoRA3rB1Vaqog6fmwJAcaGLczQAWKiwD6PTLbig2580jmSaSwTCavyO0PsV031gldVL+eJmnU1PnOaNIz3Jja3taLshbXdvFO31UZyCgQJAU3wnGBqBPNe0Xv1mTLec2j3EaAU4n79cBPFg6ueyPayi3FVPCEjhsTErHDM1kqw5yd7o/Tc0JRv0RuOZ84vOqQJBAId373hpkYd0b70VHzT0X1hcsKhMw6xRpWgnhFDvj4yytaLoN/Le2EuV4DkMSQPCsX3X4CklahkRVidPnQRS6gQ=";

            String str="appKey=11000592&contact_iccid=13408552114&bat_id=&date_begin=20180201&date_end=20180301010101&login_no=aagh27&page_number=1&page_size=10&request_method=&res_code=86535502&send_time=20180328213825&timeStamp=20180328213825&userName=linfeng";

            String appKey="11000592";
            String timeStamp="20180328111120";
            String userName="linfeng";
            String contact_iccid="13408552114";
            String request_method="";
            String bat_id="";
            String send_time="";
            String date_begin="2018-02-01 12:01:01";
            String date_end="2018-03-28 12:01:01";
            String res_code="86486902";
            String page_number="";
            String page_size="";
            String login_no="aagh27";
            String sign="";
            //sign = RSAUtils.toSign(str,PRIVATEKEY);//生成sign
            String url="http://218.205.252.26:32000/rest/1.0/WsGetActTermiMean?";
            Terminal terminal=new Terminal();
            System.out.println(url+terminal.toUrlString());*/


            /*String json="{\"resCode\":\"0000000\",\"resMsg\":\"ok!\",\"detailMsg\":\"OK!\",\"outData\":{\"PAGE_NUMBER\":\"1\",\"PAGE_COUNT\":\"6\",\"IMEI_LIST\":{\"IMEI_INFO\":[{\"IMEI_NO\":\"861677033180129\",\"BAND_NAME\":\"CZH-车智汇(定制)\",\"TYPE_CODE\":\"CZH-A280(政企)(一库)\",\"DATE_TIME\":\"20170928111537\",\"STATUS\":\"10\"},{\"IMEI_NO\":\"861677033180137\",\"BAND_NAME\":\"CZH-车智汇(定制)\",\"TYPE_CODE\":\"CZH-A280(政企)(一库)\",\"DATE_TIME\":\"20170928111537\",\"STATUS\":\"10\"},{\"IMEI_NO\":\"861677033180145\",\"BAND_NAME\":\"CZH-车智汇(定制)\",\"TYPE_CODE\":\"CZH-A280(政企)(一库)\",\"DATE_TIME\":\"20170928111537\",\"STATUS\":\"10\"},{\"IMEI_NO\":\"861677033180160\",\"BAND_NAME\":\"CZH-车智汇(定制)\",\"TYPE_CODE\":\"CZH-A280(政企)(一库)\",\"DATE_TIME\":\"20170928111537\",\"STATUS\":\"10\"},{\"IMEI_NO\":\"861677033180186\",\"BAND_NAME\":\"CZH-车智汇(定制)\",\"TYPE_CODE\":\"CZH-A280(政企)(一库)\",\"DATE_TIME\":\"20170928111537\",\"STATUS\":\"10\"},{\"IMEI_NO\":\"861677033180277\",\"BAND_NAME\":\"CZH-车智汇(定制)\",\"TYPE_CODE\":\"CZH-A280(政企)(一库)\",\"DATE_TIME\":\"20170928111537\",\"STATUS\":\"10\"},{\"IMEI_NO\":\"861677033180319\",\"BAND_NAME\":\"CZH-车智汇(定制)\",\"TYPE_CODE\":\"CZH-A280(政企)(一库)\",\"DATE_TIME\":\"20170928111537\",\"STATUS\":\"10\"},{\"IMEI_NO\":\"861677033181325\",\"BAND_NAME\":\"CZH-车智汇(定制)\",\"TYPE_CODE\":\"CZH-A280(政企)(一库)\",\"DATE_TIME\":\"20170928111537\",\"STATUS\":\"10\"},{\"IMEI_NO\":\"861677033181341\",\"BAND_NAME\":\"CZH-车智汇(定制)\",\"TYPE_CODE\":\"CZH-A280(政企)(一库)\",\"DATE_TIME\":\"20170928111537\",\"STATUS\":\"10\"},{\"IMEI_NO\":\"861677033181358\",\"BAND_NAME\":\"CZH-车智汇(定制)\",\"TYPE_CODE\":\"CZH-A280(政企)(一库)\",\"DATE_TIME\":\"20170928111537\",\"STATUS\":\"10\"}]}}}";
            JSONObject jsonObject= JSON.parseObject(json);
            System.out.println("-------------"+jsonObject.get("resCode"));
            System.out.println("-------------"+jsonObject.get("resMsg"));
            System.out.println("-------------"+jsonObject.get("detailMsg"));

            if(jsonObject.get("resCode").equals("0000000") && jsonObject.get("outData") != null){
                JSONObject outData=JSON.parseObject(JSON.toJSONString(jsonObject.get("outData")));
                System.out.println("-------------"+outData.get("PAGE_NUMBER"));
                System.out.println("-------------"+outData.get("PAGE_COUNT"));
                if(outData.get("IMEI_LIST")!=null){
                    System.out.println("-------------"+outData.get("IMEI_LIST"));
                    JSONObject IMEI_LIST=JSON.parseObject(JSON.toJSONString(outData.get("IMEI_LIST")));
                   *//* List<IMEI_INFO> imellist=JSON.parseArray(IMEI_LIST.getString("IMEI_INFO"),IMEI_INFO.class);*//*
                    JSONArray imelInfoList=JSON.parseArray(IMEI_LIST.getString("IMEI_INFO"));


                    for (int i = 0; i < imelInfoList.size(); i++) {
                        JSONObject imeiInfo =  JSON.parseObject(imelInfoList.getString(i));
                        *//*System.out.println("-------"+i+"------" + j.get(i)+"-------"+imellist.get(i).getiMEI_NO()+
                                "-------"+imellist.get(i).gettYPE_CODE()+"-------"+imellist.get(i).getdATE_TIME()+"-------"+imellist.get(i).getsTATUS());*//*
                        System.out.println("-------"+i+"------" + imeiInfo.get("BAND_NAME")+"-------"+imeiInfo.get("IMEI_NO") +
                                "-------"+imeiInfo.get("DATE_TIME")+"-------"+imeiInfo.get("TYPE_CODE")+"-------"+imeiInfo.get("STATUS"));
                    }
                }
            }*/


        String a="861677033181531";

            System.out.println(a.substring(2,a.length()-1));
            System.out.println(a.substring(2,a.length()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
