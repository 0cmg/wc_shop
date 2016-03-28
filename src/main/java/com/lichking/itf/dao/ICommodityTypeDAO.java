package com.lichking.itf.dao;

import java.util.List;

import com.lichking.pojo.web.CommodityTypePOJO;

public interface ICommodityTypeDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CommodityTypePOJO record);

    int insertSelective(CommodityTypePOJO record);

    CommodityTypePOJO selectByPrimaryKey(Integer id);
    
    List<CommodityTypePOJO> selectAll();

    int updateByPrimaryKeySelective(CommodityTypePOJO record);

    int updateByPrimaryKey(CommodityTypePOJO record);
}