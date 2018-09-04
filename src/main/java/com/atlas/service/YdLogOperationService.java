package com.atlas.service;

import com.atlas.entity.YdLogOperation;
import com.atlas.entity.YdSystemLog;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
public interface YdLogOperationService {
    int insert(YdLogOperation ydLogOperation);
    List<YdLogOperation> findAllBuleData();
}
