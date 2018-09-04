package com.atlas.service.impl;


import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.atlas.entity.ImeiInfo;
import com.atlas.entity.Terminal;
import com.atlas.entity.TerminalBoss;
import com.atlas.entity.TerminalEquipment;

import com.atlas.service.*;
import com.atlas.util.DateUtils;
import com.atlas.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/9.
 */
@Service
public class ScheduledServiceImpl implements ScheduledService {
    private Logger logger = LoggerFactory.getLogger(ScheduledServiceImpl.class);
    @Autowired
    private TerminalBossService terminalBossService;
    @Autowired
    private TerminalEquipmentService terminalEquipmentService;
    @Autowired
    private YdCarInfoService ydCarInfoService;
    @Autowired
    private ImeiInfoService imeiInfoService;
    @Autowired
    private Environment env;


    /**
     * 取所以有终端tac码去能力平台查数据
     * ishour 为true 按小时 来取数据 否则从上次取数据直到现在的时间来取数据
     * 每次都按第一页开始取数据，每页100条数据
     *
     * */
    @Override
    public void httpGetTerminalEquipment(boolean ishour){

        try {
            List<TerminalEquipment> list=terminalEquipmentService.findAllBuleData();
            logger.info("本次要取远程终端数据的所有TAC码条数为：{}", list.size());
            if(list.size()>0){
                logger.info("开始执行获取远程终端数据时间为：{}", new Date());
                for (int i = 0; i < list.size(); i++) {
                    try{
                        Terminal terminals=terminal(list.get(i).getModel_code(),ishour);
                        int date_begin=Integer.parseInt(terminals.getDate_end());
                        int newdate=Integer.parseInt(DateUtils.date2String(new Date(), "yyyyMMddHH"));
                        if( date_begin>newdate){
                            continue;
                        }
                        int pagenumber=1,pagecount=2;
                        for (int k=pagenumber; k < pagecount; k++) {
                            terminals.setPage_number(k+"");
                            terminals.setPage_size("20");
                            String httpGetStr= HttpUtils.httpGet(env.getProperty("ras.url") + "?" + terminals.toUrlString(), MediaType.APPLICATION_JSON);
                            logger.info("移动业支能力平台返回接口数据：{}", httpGetStr);
                            try {
                                JSONObject jsonObject= JSON.parseObject(httpGetStr);
                                if(jsonObject.get("resCode").equals("0000000") && jsonObject.get("outData") != null){
                                    try {
                                        JSONObject outData=JSON.parseObject(JSON.toJSONString(jsonObject.get("outData")));
                                        pagenumber=Integer.parseInt((String) outData.get("PAGE_NUMBER"));
                                        pagecount=Integer.parseInt((String) outData.get("PAGE_COUNT"))+1;

                                        if(outData.get("IMEI_LIST")!=null){
                                            JSONObject IMEI_LIST=JSON.parseObject(JSON.toJSONString(outData.get("IMEI_LIST")));
                                            if(IMEI_LIST.get("IMEI_INFO")!=null){
                                                JSONArray imelInfoList=JSON.parseArray(IMEI_LIST.getString("IMEI_INFO"));
                                                for (int j = 0; j < imelInfoList.size(); j++) {
                                                    try {
                                                        TerminalBoss terminalBoss1=new TerminalBoss();
                                                        terminalBoss1.setSelectBeginDate(terminals.getDate_begin());
                                                        terminalBoss1.setSelectEndDate(terminals.getDate_end());
                                                        terminalBoss1.setCreateDate(new Date());
                                                        terminalBoss1.setTerminalCode(list.get(i).getModel_code());
                                                        //terminalBoss.setRemarks(httpGetStr);
                                                        terminalBoss1.setRescode(jsonObject.get("resCode")+"");
                                                        terminalBoss1.setResmsg(jsonObject.get("resMsg") + "");
                                                        terminalBoss1.setDetailmsg(jsonObject.get("detailMsg") + "");
                                                        terminalBoss1.setPagenumber(pagenumber);
                                                        terminalBoss1.setPagecount(pagecount);

                                                        JSONObject imeiInfoobj =  JSON.parseObject(imelInfoList.getString(j));
                                                        //logger.info("第{}:imeiInfo：{}", j,imeiInfo.toJSONString());
                                                        terminalBoss1.setImeiinfo(imeiInfoobj.toJSONString());
                                                        terminalBoss1.setImeino(imeiInfoobj.getString("IMEI_NO"));
                                                        terminalBoss1.setBandname(imeiInfoobj.getString("BAND_NAME"));
                                                        terminalBoss1.setTypecode(imeiInfoobj.getString("TYPE_CODE"));
                                                        terminalBoss1.setInputdate(DateUtils.stringDate(imeiInfoobj.getString("DATE_TIME"),DateUtils.yyyyMMddHHmmss));
                                                        terminalBoss1.setStatus(imeiInfoobj.getInteger("STATUS"));
                                                        try {
                                                            if(imeiInfoobj.getString("IMEI_NO") !=null){
                                                                String imeino=imeiInfoobj.getString("IMEI_NO");
                                                                Map<String ,Object> map= ydCarInfoService.insert(imeino.substring(2, imeino.length() - 1),98,list.get(i).getTerminaltypeid());
                                                                logger.info("第-{}-imeiInfo-{}-写入终端车辆表：{}", j,imeiInfoobj.toJSONString(), JSONUtils.toJSONString(map));
                                                                terminalBoss1.setInsertctid((int)map.get("CT_ID"));
                                                                terminalBoss1.setInsertcarid((int)map.get("CAR_ID"));
                                                                terminalBoss1.setInsertinfocarid((int)map.get("INFO_CAR_ID"));
                                                                terminalBoss1.setInsertdate(new Date());
                                                                terminalBoss1.setInsertmsg((String) map.get("MSG"));
                                                                terminalBoss1.setInsertstate(1);
                                                            }
                                                        }catch (Exception e){
                                                            terminalBoss1.setInsertstate(0);
                                                            terminalBoss1.setInsertmsg("终端车辆入库失败");
                                                            logger.error("终端车辆入库失败:{}",e);
                                                        }
                                                        try{
                                                            if(imeiInfoobj.getString("IMEI_NO") !=null){
                                                                ImeiInfo imeiInfo= new ImeiInfo();
                                                                imeiInfo.setModelCode(list.get(i).getModel_code());
                                                                imeiInfo.setImeiNo(imeiInfoobj.getString("IMEI_NO"));
                                                                imeiInfo.setBandName(imeiInfoobj.getString("BAND_NAME"));
                                                                imeiInfo.setTypeCode(imeiInfoobj.getString("TYPE_CODE"));
                                                                imeiInfo.setDateTime(imeiInfoobj.getString("DATE_TIME"));
                                                                imeiInfo.setStatus(imeiInfoobj.getString("STATUS"));
                                                                imeiInfo.setEnable(1);
                                                                imeiInfo.setCreateDate(new Date());
                                                                int imeiid=imeiInfoService.insert(imeiInfo);
                                                                terminalBoss1.setInsertimeiinfoid(imeiid);
                                                            }

                                                        } catch (Exception e){
                                                            logger.error("IMEIINFO表数据写入失败:{}",e);
                                                        }

                                                        terminalBossService.insert(terminalBoss1);
                                                    }catch (Exception e){
                                                        logger.error("日志表terminalBoss记录失败：{}",e);
                                                    }

                                                }
                                            }
                                        }else{
                                            try {
                                                TerminalBoss terminalBoss=new TerminalBoss();
                                                terminalBoss.setSelectBeginDate(terminals.getDate_begin());
                                                terminalBoss.setSelectEndDate(terminals.getDate_end());
                                                terminalBoss.setCreateDate(new Date());
                                                terminalBoss.setTerminalCode(list.get(i).getModel_code());
                                                terminalBoss.setRescode(jsonObject.get("resCode")+"");
                                                terminalBoss.setResmsg(jsonObject.get("resMsg") + "");
                                                terminalBoss.setDetailmsg(jsonObject.get("detailMsg") + "");
                                                terminalBoss.setPagenumber(pagenumber);
                                                terminalBoss.setPagecount(pagecount);
                                                terminalBoss.setRemarks(httpGetStr);
                                                terminalBossService.insert(terminalBoss);
                                            }catch (Exception e){
                                                logger.error("TerminalBoss数据写入失败:{}",e);
                                            }

                                        }
                                    }catch (Exception e){
                                        logger.error("json入库失败:{}",e);
                                        throw new Exception("json入库失败"+e);
                                    }
                                }else{
                                    TerminalBoss terminalBoss=new TerminalBoss();
                                    terminalBoss.setSelectBeginDate(terminals.getDate_begin());
                                    terminalBoss.setSelectEndDate(terminals.getDate_end());
                                    terminalBoss.setCreateDate(new Date());
                                    terminalBoss.setTerminalCode(list.get(i).getModel_code());
                                    terminalBoss.setRescode(jsonObject.get("resCode")+"");
                                    terminalBoss.setResmsg(jsonObject.get("resMsg") + "");
                                    terminalBoss.setDetailmsg(jsonObject.get("detailMsg") + "");
                                    terminalBoss.setRemarks(httpGetStr);
                                    terminalBossService.insert(terminalBoss);
                                }

                            }catch (Exception e){
                                logger.error("json入库失败:{}",e);
                                e.printStackTrace();
                            }
                        }
                    }catch (Exception e){
                        logger.error("json入库失败:{}",e);
                    }

                }
                logger.info("结束执行获取远程终端数据时间为：{}", new Date());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 根据modelCode 查TerminalBoss最后一次去平台取数据的时间
     * 然后封装查询条件
     *
     * 返回查询类Terminal
     * */
    @Override
    public Terminal terminal(String modelCode,boolean ishour) throws ParseException {
        Terminal terminals=new Terminal();
        TerminalBoss terminalBoss=terminalBossService.selectTerminalCode(modelCode);
        if(terminalBoss!=null && terminalBoss.getSelectEndDate()!=null){
            terminals.setDate_begin(terminalBoss.getSelectEndDate());
            if(ishour){
                terminals.setDate_end(DateUtils.getIncreMinuteDate(DateUtils.date2String(
                        DateUtils.stringDate(terminalBoss.getSelectEndDate()+"0000", DateUtils.yyyyMMddHHmmss), DateUtils.ALL), 1,"yyyyMMddHH"));
            }else{
                terminals.setDate_end(DateUtils.date2String(new Date(), "yyyyMMddHH"));
            }
        } else {
            terminals.setDate_begin(DateUtils.getIncreMinuteDate(DateUtils.date2String(new Date(), DateUtils.ALL), -1, "yyyyMMddHH"));
            terminals.setDate_end(DateUtils.date2String(new Date(), "yyyyMMddHH"));
        }
        logger.info("开始时间：{}---------结束时间：{}",terminals.getDate_begin(),terminals.getDate_end());
        terminals.setAppKey(env.getProperty("ras.appKey"));
        terminals.setUserName(env.getProperty("ras.userName"));
        terminals.setContact_iccid(env.getProperty("ras.contact_iccid"));
        terminals.setLogin_no(env.getProperty("ras.login_no"));
        terminals.setPrivatekey(env.getProperty("ras.privatekey"));
        terminals.setRes_code(modelCode);

        return terminals;
    }
}
