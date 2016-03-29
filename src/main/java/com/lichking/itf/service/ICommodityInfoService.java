package com.lichking.itf.service;

import java.util.List;

import com.lichking.pojo.web.CommodityInfoVO;

public interface ICommodityInfoService {

	public int insertComWithNull(CommodityInfoVO com);
	
	public List<CommodityInfoVO> selectByWhere(CommodityInfoVO com);
	
	public CommodityInfoVO selectByPK(Integer comid);
	
	public int updateComByPKSelective(CommodityInfoVO com);
	
	public int deleteComByPK(Integer comid);
	
}
