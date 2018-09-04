package com.atlas;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.atlas.entity.ImeiInfo;
import com.atlas.entity.Terminal;
import com.atlas.entity.Terminal2;
import com.atlas.service.ImeiInfoService;
import com.atlas.service.ScheduledService;
import com.atlas.service.YdCarInfoService;
import com.atlas.util.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=AtlasdataApplication.class)
@Slf4j
public class AtlasdataTest {
    @Autowired
    private YdCarInfoService ydCarInfoService;
    @Autowired
    private ScheduledService scheduledService;
    @Autowired
    private ImeiInfoService imeiInfoService;
    @Autowired
    private Environment env;

    @Test
    public void test(){
        ImeiInfo imeiInfo= new ImeiInfo();
        imeiInfo.setModelCode("20012975");
        imeiInfo.setImeiNo("ZYWLW-中移物联网(定制)");
        imeiInfo.setBandName("865355024921308");
        imeiInfo.setTypeCode("ZYWLW-D02(一库)");
        imeiInfo.setDateTime("20180614162858");
        imeiInfo.setStatus("10");
        imeiInfo.setEnable(1);
        imeiInfo.setCreateDate(new Date());
        int imeiid=imeiInfoService.insert(imeiInfo);
        System.out.println("------------"+imeiid);
        /*System.out.println(System.getProperty("sun.jnu.encoding"));
        *//*System.out.println("-----mysql条数---"+ydCarInfoService.findAllBuleData().size()+
                "-------oracle条数-------"+ydCarInfoService.oraclefindAllBuleData().size());*//*

        //scheduledService.httpGetTerminalEquipment(false);
        //Map<String ,Object> map= ydCarInfoService.insert("535502491598",93,1);

        String json="{\"IMEI_LIST\":{\"IMEI_INFO\":" +
                "{\"IMEI_NO\":\"865355024654685\",\"BAND_NAME\":\"ZYWLW-中移物联网(定制)\",\"TYPE_CODE\":\"ZYWLW-D02(一库)\",\"DATE_TIME\":\"20171205142229\",\"STATUS\":\"30\"}" +
                "}}";
        JSONObject IMEI_LIST= JSON.parseObject(json);

        JSONArray imelInfoList=JSON.parseArray(JSON.toJSONString(IMEI_LIST.getString("IMEI_INFO")));
        JSONObject IMEI_INFO= (JSONObject) IMEI_LIST.get("IMEI_LIST");
        JSONObject IMEI_INFO2= (JSONObject) IMEI_INFO.get("IMEI_INFO");
        IMEI_INFO2.getString("BAND_NAME");
        System.out.println(imelInfoList.size());
*/
       /* Terminal2 terminals=new Terminal2();
        terminals.setAppKey(env.getProperty("ras.appKey"));
        terminals.setUserName(env.getProperty("ras.userName"));
        terminals.setContact_iccid(env.getProperty("ras.contact_iccid"));
        terminals.setLogin_no(env.getProperty("ras.login_no"));
        terminals.setPrivatekey(env.getProperty("ras.privatekey"));
        terminals.setImei_no("865355024867253");
        try {
            System.out.println("----------------------"+"http://218.205.252.26:32000/rest/1.0/WsGetActTermiMean" + "?" + terminals.toUrlString());
            String httpGetStr= HttpUtils.httpGet("http://218.205.252.26:32000/rest/1.0/WsGetActTermiMean" + "?" + terminals.toUrlString(), MediaType.APPLICATION_JSON);
            System.out.println("----------------------"+httpGetStr);
        } catch (Exception e) {
            e.printStackTrace();
        }*/





    }
}
