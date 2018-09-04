package com.atlas.mapper;

import com.atlas.entity.ImeiInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImeiInfoMapper {
    int deleteByPrimaryKey(Integer imeiId);

    int insert(ImeiInfo record);

    ImeiInfo selectByPrimaryKey(Integer imeiId);

    List<ImeiInfo> selectAll();
    List<ImeiInfo> selectByCodeKey(@Param(value ="modelCode")String modelCode,@Param(value = "imeiNo")String imeiNo);

    int updateByPrimaryKey(ImeiInfo record);
}