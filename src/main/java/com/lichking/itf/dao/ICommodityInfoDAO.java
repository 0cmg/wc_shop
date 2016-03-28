package com.lichking.itf.dao;

import java.util.List;

import com.lichking.pojo.web.CommodityInfoPOJO;

public interface ICommodityInfoDAO {
    int deleteByPrimaryKey(Integer commodityid);

    int insert(CommodityInfoPOJO record);

    int insertSelective(CommodityInfoPOJO record);

    CommodityInfoPOJO selectByPrimaryKey(Integer commodityid);

    int updateByPrimaryKeySelective(CommodityInfoPOJO record);

    int updateByPrimaryKey(CommodityInfoPOJO record);
    
    List<CommodityInfoPOJO> selectByWhere(CommodityInfoPOJO record);
}