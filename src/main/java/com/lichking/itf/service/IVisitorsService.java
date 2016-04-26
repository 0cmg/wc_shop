package com.lichking.itf.service;

import java.util.List;

import com.lichking.pojo.web.VisitorsVO;

public interface IVisitorsService {

	public List<VisitorsVO> selectByWhere(VisitorsVO vvo);
	
	public int updateByPKSelective(VisitorsVO vvo);
	
	public int insertSelective(VisitorsVO vvo);
	
}
