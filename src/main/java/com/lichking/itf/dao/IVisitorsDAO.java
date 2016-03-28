package com.lichking.itf.dao;

import com.lichking.pojo.web.VisitorsPOJO;

public interface IVisitorsDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(VisitorsPOJO record);

    int insertSelective(VisitorsPOJO record);

    VisitorsPOJO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VisitorsPOJO record);

    int updateByPrimaryKey(VisitorsPOJO record);
}