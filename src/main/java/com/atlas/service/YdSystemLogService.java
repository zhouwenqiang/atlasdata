package com.atlas.service;

import com.atlas.entity.TerminalBoss;
import com.atlas.entity.YdSystemLog;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
public interface YdSystemLogService {
    int insert(YdSystemLog ydSystemLog);
    List<YdSystemLog> findAllBuleData();
}
