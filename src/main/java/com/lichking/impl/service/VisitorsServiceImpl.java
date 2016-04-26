package com.lichking.impl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lichking.itf.dao.IVisitorsDAO;
import com.lichking.itf.service.IVisitorsService;
import com.lichking.pojo.web.VisitorsVO;

@Service("VisitorsService")
public class VisitorsServiceImpl implements IVisitorsService {

	@Resource
	private IVisitorsDAO visitorsDAO;
	
	@Override
	public List<VisitorsVO> selectByWhere(VisitorsVO vvo) {
		return this.visitorsDAO.selectByWhere(vvo);
	}

	@Override
	public int updateByPKSelective(VisitorsVO vvo) {
		return this.visitorsDAO.updateByPrimaryKeySelective(vvo);
	}

	@Override
	public int insertSelective(VisitorsVO vvo) {
		return this.visitorsDAO.insertSelective(vvo);
	}

}
