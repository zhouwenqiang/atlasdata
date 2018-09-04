package com.atlas.mapper;

import com.atlas.entity.YdCarTerminal;

import java.util.List;


/**
 * Created by Administrator on 2018/3/22.
 */
public interface YdCarTerminalMapper {
    int deleteByPrimaryKey(int id);
    YdCarTerminal selectByPrimaryKey(int id);
    YdCarTerminal selectCtCode(String CT_CODE);
    int insert(YdCarTerminal ydCarTerminal);
    List<YdCarTerminal> findAllBuleData();
}
