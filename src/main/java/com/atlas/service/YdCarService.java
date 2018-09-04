package com.atlas.service;

import com.atlas.entity.YdCar;
import com.atlas.entity.YdCarTerminal;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
public interface YdCarService {
    int insert(YdCar ydcar);
    YdCar selectCarCph(String CAR_CPH);
    List<YdCar> findAllBuleData();
}
