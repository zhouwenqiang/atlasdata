package com.atlas.service;

import com.atlas.entity.ImeiInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
public interface ImeiInfoService {
    int insert(ImeiInfo imeiInfo);
    List<ImeiInfo> findAllBuleData();
    List<ImeiInfo> selectByCodeKey(String modelCode,String imeiNo);
}
