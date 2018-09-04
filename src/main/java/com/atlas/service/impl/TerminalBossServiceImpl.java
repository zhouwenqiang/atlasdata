package com.atlas.service.impl;

import com.atlas.common.DS;
import com.atlas.entity.TerminalBoss;
import com.atlas.entity.TerminalEquipment;
import com.atlas.mapper.TerminalBossMapper;
import com.atlas.mapper.TerminalEquipmentMapper;
import com.atlas.service.TerminalBossService;
import com.atlas.service.TerminalEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
@Service
public class TerminalBossServiceImpl implements TerminalBossService {
    @Autowired
    private TerminalBossMapper terminalBossMapper;

    @Override
    @DS("mysqlDS1")
    public int insert(TerminalBoss terminalBoss) {
        return terminalBossMapper.insert(terminalBoss);
    }

    @Override
    @DS("mysqlDS1")
    public List<TerminalBoss> findAllBuleData() {
        return terminalBossMapper.selectAll();
    }

    @Override
    @DS("mysqlDS1")
    public TerminalBoss selectTerminalCode(String TERMINAL_CODE) {
        return terminalBossMapper.selectTerminalCode(TERMINAL_CODE);
    }
}
