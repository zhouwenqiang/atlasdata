package com.atlas.service.impl;

import com.atlas.common.DS;
import com.atlas.entity.YdCar;
import com.atlas.entity.YdCarInfo;
import com.atlas.entity.YdCarTerminal;
import com.atlas.mapper.YdCarInfoMapper;
import com.atlas.service.YdCarInfoService;
import com.atlas.service.YdCarService;
import com.atlas.service.YdCarTerminalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/22.
 */
@Service
public class YdCarInfoServiceImpl implements YdCarInfoService {
    private Logger logger = LoggerFactory.getLogger(YdCarInfoServiceImpl.class);
    @Autowired
    private YdCarInfoMapper ydCarInfoMapper;
    @Autowired
    private YdCarService ydCarService;
    @Autowired
    private YdCarTerminalService ydCarTerminalService;

    @Override
    @DS("oracleDS1")
    public int insert(YdCarInfo ydcarinfo) {
        return ydCarInfoMapper.insert(ydcarinfo);
    }

    @Override
    @DS("oracleDS1")
    @Transactional
    public List<YdCarInfo> findAllBuleData() {
        return ydCarInfoMapper.findAllBuleData();
    }
    @Override
    @DS("oracleDS1")
    @Transactional
    public Map<String ,Object> insert(String imei,int teamId,int typeId){
        Map<String ,Object> insertMap=new HashMap<>();
        insertMap.put("IMEI",imei);
        try {
            YdCarTerminal ydCarTerminal=new YdCarTerminal();
            ydCarTerminal.setCT_CODE(imei);
            //终端类型
            ydCarTerminal.setCT_TYPE(typeId+"");
            ydCarTerminal.setCT_SIM(imei);
            ydCarTerminal.setCT_TXID(imei);
            ydCarTerminal.setTEAM_ID(teamId);
            ydCarTerminal.setCT_STATE("Y");
            ydCarTerminal.setCT_SIM_SIGN("0");
            try {
                if(null != ydCarTerminalService.selectCtCode(imei)){
                    insertMap.put("MSG","终端表已经存在："+imei);
                    throw new Exception("终端编号已经存在："+imei);
                }else{
                    ydCarTerminalService.insert(ydCarTerminal);
                    insertMap.put("CT_ID",ydCarTerminal.getCT_ID());
                }
            }catch (Exception e){
                e.printStackTrace();
                insertMap.put("MSG","终端表新增失败");
                throw new Exception("添加终端失败"+e);
            }
            YdCar ydCar =new YdCar();
            ydCar.setCAR_CPH(imei);
            ydCar.setCAR_COLOR("36");
            ydCar.setCAR_TYPE("45");
            ydCar.setCAR_TRADE("31");
            ydCar.setTERMINAL(ydCarTerminal.getCT_ID());
            ydCar.setTEAM_ID(teamId);
            ydCar.setCAR_ACCOUNT("xiaochengxi");
            ydCar.setCAR_DATE(new Date());
            ydCar.setCAR_STATE("1");
            ydCar.setCAR_PLACE("510100");
            ydCar.setCAR_PW("888888");
            ydCar.setCAR_SERVICE_STOP("0");
            try {
                if(null != ydCarService.selectCarCph(imei)){
                    insertMap.put("MSG","车辆表已经存在："+imei);
                    throw new Exception("车牌号已经存在："+imei);
                }else{
                    ydCarService.insert(ydCar);
                    insertMap.put("CAR_ID",ydCar.getCAR_ID());
                }
            }catch (Exception e){
                insertMap.put("MSG","车辆表新增失败");
                throw new Exception("添加车辆失败，绑定终端失败"+e);
            }
            YdCarInfo ydCarInfo=new YdCarInfo();
            ydCarInfo.setCAR_ID(ydCar.getCAR_ID());
            ydCarInfo.setZCCPXH("123456");
            ydCarInfo.setCZ("张三");
            ydCarInfo.setCLFDJH("123456");
            ydCarInfo.setNJYXQ(new Date());
            ydCarInfo.setQCBYSJ(new Date());
            ydCarInfo.setBXDQSJ(new Date());
            ydCarInfo.setJYQYBM("0");
            ydCarInfo.setBXLX("0");
            ydCarInfo.setFX_BEGIN(new Date());
            ydCarInfo.setFX_END(new Date());
            ydCarInfo.setWXPHWFL(75);
            ydCarInfo.setCZ_MOBILE(imei);

            ydCarInfo.setZZL(0);
            ydCarInfo.setWKCCC(0);
            ydCarInfo.setWKCCK(0);
            ydCarInfo.setWKCCG(0);
            ydCarInfo.setHXNBCCC(0);
            ydCarInfo.setHXNBCCK(0);
            ydCarInfo.setHXNBCCG(0);
            ydCarInfo.setZS(0);
            try {
                insert(ydCarInfo);
                insertMap.put("INFO_CAR_ID",ydCarInfo.getCAR_ID());
            }catch (Exception e){
                insertMap.put("MSG","车辆详情表新增失败");
                throw new Exception("添加车辆详情失败"+e);
            }
            insertMap.put("STATE","success");
        }catch (Exception e){
            insertMap.put("STATE","failure");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("添加设备失败:{}",imei);
            e.printStackTrace();
        }
        return insertMap;
    }

    @Override
    @DS("oracleDS1")
    @Transactional
    public Map<String, Object> insert(String imei, int teamId, int typeId, String cph, String simkh) {
        Map<String ,Object> insertMap=new HashMap<>();
        insertMap.put("IMEI",imei);
        try {
            YdCarTerminal ydCarTerminal=new YdCarTerminal();
            ydCarTerminal.setCT_CODE(imei);
            //终端类型
            ydCarTerminal.setCT_TYPE(typeId+"");
            ydCarTerminal.setCT_SIM(simkh);
            ydCarTerminal.setCT_TXID(simkh);
            ydCarTerminal.setTEAM_ID(teamId);
            ydCarTerminal.setCT_STATE("Y");
            ydCarTerminal.setCT_SIM_SIGN("0");
            try {
                if(null != ydCarTerminalService.selectCtCode(imei)){
                    insertMap.put("MSG","终端表已经存在："+imei);
                    throw new Exception("终端编号已经存在："+imei);
                }else{
                    ydCarTerminalService.insert(ydCarTerminal);
                    insertMap.put("CT_ID",ydCarTerminal.getCT_ID());
                }
            }catch (Exception e){
                e.printStackTrace();
                insertMap.put("MSG","终端表新增失败");
                throw new Exception("添加终端失败"+e);
            }
            YdCar ydCar =new YdCar();
            ydCar.setCAR_CPH(cph);
            ydCar.setCAR_COLOR("36");
            ydCar.setCAR_TYPE("45");
            ydCar.setCAR_TRADE("31");
            ydCar.setTERMINAL(ydCarTerminal.getCT_ID());
            ydCar.setTEAM_ID(teamId);
            ydCar.setCAR_ACCOUNT("xiaochengxi_scydzhb");
            ydCar.setCAR_DATE(new Date());
            ydCar.setCAR_STATE("1");
            ydCar.setCAR_PLACE("510100");
            ydCar.setCAR_PW("888888");
            ydCar.setCAR_SERVICE_STOP("0");
            try {
                if(null != ydCarService.selectCarCph(imei)){
                    insertMap.put("MSG","车辆表已经存在："+imei);
                    throw new Exception("车牌号已经存在："+imei);
                }else{
                    ydCarService.insert(ydCar);
                    insertMap.put("CAR_ID",ydCar.getCAR_ID());
                }
            }catch (Exception e){
                insertMap.put("MSG","车辆表新增失败");
                throw new Exception("添加车辆失败，绑定终端失败"+e);
            }
            YdCarInfo ydCarInfo=new YdCarInfo();
            ydCarInfo.setCAR_ID(ydCar.getCAR_ID());
            ydCarInfo.setZCCPXH("123456");
            ydCarInfo.setCZ("张三");
            ydCarInfo.setCLFDJH("123456");
            ydCarInfo.setNJYXQ(new Date());
            ydCarInfo.setQCBYSJ(new Date());
            ydCarInfo.setBXDQSJ(new Date());
            ydCarInfo.setJYQYBM("0");
            ydCarInfo.setBXLX("0");
            ydCarInfo.setFX_BEGIN(new Date());
            ydCarInfo.setFX_END(new Date());
            ydCarInfo.setWXPHWFL(75);
            ydCarInfo.setCZ_MOBILE(imei);

            ydCarInfo.setZZL(0);
            ydCarInfo.setWKCCC(0);
            ydCarInfo.setWKCCK(0);
            ydCarInfo.setWKCCG(0);
            ydCarInfo.setHXNBCCC(0);
            ydCarInfo.setHXNBCCK(0);
            ydCarInfo.setHXNBCCG(0);
            ydCarInfo.setZS(0);
            try {
                insert(ydCarInfo);
                insertMap.put("INFO_CAR_ID",ydCarInfo.getCAR_ID());
            }catch (Exception e){
                insertMap.put("MSG","车辆详情表新增失败");
                throw new Exception("添加车辆详情失败"+e);
            }
            insertMap.put("STATE","success");
        }catch (Exception e){
            insertMap.put("STATE","failure");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("添加设备失败:{}",imei);
            e.printStackTrace();
        }
        return insertMap;
    }


}
