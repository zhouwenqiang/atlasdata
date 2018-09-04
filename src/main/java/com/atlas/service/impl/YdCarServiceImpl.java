package com.atlas.service.impl;

import com.atlas.common.DS;
import com.atlas.entity.YdCar;
import com.atlas.mapper.YdCarMapper;
import com.atlas.service.YdCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
@Service
public class YdCarServiceImpl implements YdCarService {
    @Autowired
    private YdCarMapper ydCarMapper;

    @Override
    @DS("oracleDS1")
    public int insert(YdCar ydcar) {
        return ydCarMapper.insert(ydcar);
    }

    @Override
    @DS("oracleDS1")
    public YdCar selectCarCph(String CAR_CPH) {
        return ydCarMapper.selectCarCph(CAR_CPH);
    }
    @Override
    @DS("oracleDS1")
    public List<YdCar> findAllBuleData() {
        return ydCarMapper.findAllBuleData();
    }
}
