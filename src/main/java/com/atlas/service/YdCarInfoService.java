package com.atlas.service;

import com.atlas.entity.YdCarInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/22.
 */
public interface YdCarInfoService {
    int insert(YdCarInfo ydcarinfo);
    List<YdCarInfo> findAllBuleData();
    Map<String ,Object> insert(String imei,int teamId,int typeId);

    Map<String ,Object> insert(String imei,int teamId,int typeId,String cph,String simkh);
}
