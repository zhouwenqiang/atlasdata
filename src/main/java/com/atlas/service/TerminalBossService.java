package com.atlas.service;

import com.atlas.entity.TerminalBoss;
import com.atlas.entity.TerminalEquipment;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
public interface TerminalBossService {
    int insert(TerminalBoss terminalEquipment);
    List<TerminalBoss> findAllBuleData();
    TerminalBoss selectTerminalCode(String TERMINAL_CODE);
}
