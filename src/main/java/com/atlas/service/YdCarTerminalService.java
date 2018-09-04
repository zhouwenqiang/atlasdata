package com.atlas.service;

import com.atlas.entity.YdCarTerminal;
import com.atlas.mapper.YdCarTerminalMapper;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
public interface YdCarTerminalService {
    int insert(YdCarTerminal ydCarTerminal);
    YdCarTerminal selectCtCode(String CT_CODE);
    List<YdCarTerminal> findAllBuleData();

}
