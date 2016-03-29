package com.lichking.itf.dao;

import com.lichking.pojo.web.VisitorsVO;

public interface IVisitorsDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(VisitorsVO record);

    int insertSelective(VisitorsVO record);

    VisitorsVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VisitorsVO record);

    int updateByPrimaryKey(VisitorsVO record);
}