package com.atlas.mapper;

import com.atlas.entity.YdCar;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
public interface YdCarMapper {
    int deleteByPrimaryKey(int id);
    YdCar selectByPrimaryKey(int id);
    int insert(YdCar ydcar);
    List<YdCar> findAllBuleData();
    YdCar selectCarCph(String CAR_CPH);
}
