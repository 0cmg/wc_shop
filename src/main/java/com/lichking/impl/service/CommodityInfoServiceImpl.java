package com.lichking.impl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lichking.itf.dao.ICommodityInfoDAO;
import com.lichking.itf.service.ICommodityInfoService;
import com.lichking.pojo.web.CommodityInfoVO;

@Service("CommodityInfoService")
public class CommodityInfoServiceImpl implements ICommodityInfoService {

	@Resource
	private ICommodityInfoDAO iCommodityInfoDAO;
	
	@Override
	public int insertComWithNull(CommodityInfoVO com) {
		return this.iCommodityInfoDAO.insertSelective(com);
	}

	@Override
	public List<CommodityInfoVO> selectByWhere(CommodityInfoVO com) {
		return this.iCommodityInfoDAO.selectByWhere(com);
	}

	@Override
	public CommodityInfoVO selectByPK(Integer comid) {
		return this.iCommodityInfoDAO.selectByPrimaryKey(comid);
	}

	@Override
	public int updateComByPKSelective(CommodityInfoVO com) {
		return this.iCommodityInfoDAO.updateByPrimaryKeySelective(com);
	}

	@Override
	public int deleteComByPK(Integer comid) {
		return this.iCommodityInfoDAO.deleteByPrimaryKey(comid);
	}

	
}
