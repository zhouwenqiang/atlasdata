package com.atlas.mapper;

import com.atlas.common.DS;
import com.atlas.entity.YdCarInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
public interface YdCarInfoMapper {
    int deleteByPrimaryKey(int id);
    YdCarInfo selectByPrimaryKey(int id);
    int insert(YdCarInfo ydcarinfo);

    List<YdCarInfo> findAllBuleData();

    List<YdCarInfo> oraclefindAllBuleData();
}
