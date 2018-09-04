package com.atlas.mapper;

import com.atlas.entity.TerminalBoss;
import java.util.List;

public interface TerminalBossMapper {
    int deleteByPrimaryKey(Short tbId);

    int insert(TerminalBoss record);

    TerminalBoss selectByPrimaryKey(Short tbId);
    TerminalBoss selectTerminalCode(String TERMINAL_CODE);
    List<TerminalBoss> selectAll();

    int updateByPrimaryKey(TerminalBoss record);
}