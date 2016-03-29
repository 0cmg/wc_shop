package com.lichking.itf.dao;

import java.util.List;

import com.lichking.pojo.web.CommodityInfoVO;

public interface ICommodityInfoDAO {
    int deleteByPrimaryKey(Integer commodityid);

    int insert(CommodityInfoVO record);

    int insertSelective(CommodityInfoVO record);

    CommodityInfoVO selectByPrimaryKey(Integer commodityid);

    int updateByPrimaryKeySelective(CommodityInfoVO record);

    int updateByPrimaryKey(CommodityInfoVO record);
    
    List<CommodityInfoVO> selectByWhere(CommodityInfoVO record);
}