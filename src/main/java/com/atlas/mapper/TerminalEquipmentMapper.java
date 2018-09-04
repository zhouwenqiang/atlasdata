package com.atlas.mapper;

import com.atlas.entity.TerminalEquipment;
import com.atlas.entity.YdCarTerminal;

import java.util.List;


/**
 * Created by Administrator on 2018/3/22.
 */
public interface TerminalEquipmentMapper {
    int insert(TerminalEquipment terminalEquipment);
    List<TerminalEquipment> findAllBuleData();
}
