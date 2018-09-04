package com.atlas.service.impl;

import com.atlas.common.DS;
import com.atlas.entity.YdCarTerminal;
import com.atlas.mapper.YdCarTerminalMapper;
import com.atlas.service.YdCarTerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
@Service
public class YdCarTerminalServiceImpl implements YdCarTerminalService {
    @Autowired
    private YdCarTerminalMapper ydCarTerminalMapper;


    @Override
    @DS("oracleDS1")
    public int insert(YdCarTerminal ydCarTerminal) {
        return ydCarTerminalMapper.insert(ydCarTerminal);
    }

    @Override
    @DS("oracleDS1")
    public YdCarTerminal selectCtCode(String CT_CODE) {
        return ydCarTerminalMapper.selectCtCode(CT_CODE);
    }

    @Override
    @DS("oracleDS1")
    public List<YdCarTerminal> findAllBuleData() {
        return ydCarTerminalMapper.findAllBuleData();
    }

}
