package com.atlas.mapper;

import com.atlas.entity.YdSystemLog;
import java.util.List;

public interface YdSystemLogMapper {
    int deleteByPrimaryKey(Short slId);

    int insert(YdSystemLog record);

    YdSystemLog selectByPrimaryKey(Short slId);

    List<YdSystemLog> selectAll();

    int updateByPrimaryKey(YdSystemLog record);
}