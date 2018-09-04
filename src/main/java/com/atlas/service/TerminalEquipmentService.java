package com.atlas.service;

import com.atlas.entity.TerminalEquipment;
import com.atlas.entity.YdCarTerminal;
import com.atlas.mapper.YdCarTerminalMapper;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
public interface TerminalEquipmentService {
    int insert(TerminalEquipment terminalEquipment);
    List<TerminalEquipment> findAllBuleData();
}
