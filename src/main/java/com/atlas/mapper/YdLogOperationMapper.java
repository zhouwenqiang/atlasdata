package com.atlas.mapper;

import com.atlas.entity.YdLogOperation;
import java.util.List;

public interface YdLogOperationMapper {
    int deleteByPrimaryKey(Short logId);

    int insert(YdLogOperation record);

    YdLogOperation selectByPrimaryKey(Short logId);

    List<YdLogOperation> selectAll();

    int updateByPrimaryKey(YdLogOperation record);
}