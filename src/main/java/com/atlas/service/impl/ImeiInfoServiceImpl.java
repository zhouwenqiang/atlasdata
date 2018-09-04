package com.atlas.service.impl;

import com.atlas.common.DS;
import com.atlas.entity.ImeiInfo;
import com.atlas.entity.TerminalBoss;
import com.atlas.mapper.ImeiInfoMapper;
import com.atlas.mapper.TerminalBossMapper;
import com.atlas.service.ImeiInfoService;
import com.atlas.service.TerminalBossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
@Service
public class ImeiInfoServiceImpl implements ImeiInfoService {
    @Autowired
    private ImeiInfoMapper tmeiInfoMapper;

    @Override
    @DS("mysqlDS1")
    public int insert(ImeiInfo tmeiInfo) {
        int id=0;
        List<ImeiInfo> list =tmeiInfoMapper.selectByCodeKey(tmeiInfo.getModelCode(),tmeiInfo.getImeiNo());
        if (list !=null && list.size()>0){
            id=list.get(0).getImeiId();
        }
        else{
            tmeiInfoMapper.insert(tmeiInfo);
            id=tmeiInfo.getImeiId();
        }
        return id;
    }

    @Override
    @DS("mysqlDS1")
    @Transactional
    public List<ImeiInfo> findAllBuleData() {
        return tmeiInfoMapper.selectAll();
    }

    @Override
    @DS("mysqlDS1")
    public List<ImeiInfo> selectByCodeKey(String modelCode, String imeiNo) {
        return tmeiInfoMapper.selectByCodeKey(modelCode,imeiNo);
    }


}
