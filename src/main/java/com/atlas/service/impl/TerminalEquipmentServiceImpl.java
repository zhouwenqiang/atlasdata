package com.atlas.service.impl;

import com.atlas.common.DS;
import com.atlas.entity.TerminalEquipment;
import com.atlas.entity.YdCarTerminal;
import com.atlas.mapper.TerminalEquipmentMapper;
import com.atlas.mapper.YdCarTerminalMapper;
import com.atlas.service.TerminalEquipmentService;
import com.atlas.service.YdCarTerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
@Service
public class TerminalEquipmentServiceImpl implements TerminalEquipmentService {
    @Autowired
    private TerminalEquipmentMapper terminalEquipmentMapper;


    @Override
    @DS("mysqlDS1")
    public int insert(TerminalEquipment terminalEquipment) {
        return terminalEquipmentMapper.insert(terminalEquipment);
    }

    @Override
    @DS("mysqlDS1")
    public List<TerminalEquipment> findAllBuleData() {
        return terminalEquipmentMapper.findAllBuleData();
    }
}
