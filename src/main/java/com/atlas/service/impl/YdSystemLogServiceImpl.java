package com.atlas.service.impl;

import com.atlas.common.DS;
import com.atlas.entity.TerminalBoss;
import com.atlas.entity.YdSystemLog;
import com.atlas.mapper.TerminalBossMapper;
import com.atlas.mapper.YdSystemLogMapper;
import com.atlas.service.TerminalBossService;
import com.atlas.service.YdSystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
@Service
public class YdSystemLogServiceImpl implements YdSystemLogService {
    @Autowired
    private YdSystemLogMapper ydSystemLogMapper;


    @Override
    @DS("oracleDS1")
    public int insert(YdSystemLog ydSystemLog) {
        return ydSystemLogMapper.insert(ydSystemLog);
    }

    @Override
    @DS("oracleDS1")
    public List<YdSystemLog> findAllBuleData() {
        return ydSystemLogMapper.selectAll();
    }
}
