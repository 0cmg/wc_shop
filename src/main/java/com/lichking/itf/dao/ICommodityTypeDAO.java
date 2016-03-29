package com.lichking.itf.dao;

import java.util.List;

import com.lichking.pojo.web.CommodityTypeVO;

public interface ICommodityTypeDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CommodityTypeVO record);

    int insertSelective(CommodityTypeVO record);

    CommodityTypeVO selectByPrimaryKey(Integer id);
    
    List<CommodityTypeVO> selectAll();

    int updateByPrimaryKeySelective(CommodityTypeVO record);

    int updateByPrimaryKey(CommodityTypeVO record);
}