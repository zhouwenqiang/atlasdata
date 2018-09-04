package com.atlas.service.impl;

import com.atlas.common.DS;
import com.atlas.entity.TerminalBoss;
import com.atlas.entity.YdLogOperation;
import com.atlas.mapper.TerminalBossMapper;
import com.atlas.mapper.YdLogOperationMapper;
import com.atlas.service.TerminalBossService;
import com.atlas.service.YdLogOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
@Service
public class YdLogOperationServiceImpl implements YdLogOperationService {
    @Autowired
    private YdLogOperationMapper ydLogOperationMapper;


    @Override
    @DS("oracleDS1")
    public int insert(YdLogOperation ydLogOperation) {
        return ydLogOperationMapper.insert(ydLogOperation);
    }

    @Override
    @DS("oracleDS1")
    public List<YdLogOperation> findAllBuleData() {
        return ydLogOperationMapper.selectAll();
    }
}
