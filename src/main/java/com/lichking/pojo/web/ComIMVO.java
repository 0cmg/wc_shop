package com.lichking.pojo.web;

import java.util.List;

import com.lichking.pojo.web.co.SimpleComVO;

/**
 * 用于前后台 商品库存操作的对象
 * @author LichKing
 *
 */
public class ComIMVO {

	public String getOp() {
		return op;
	}



	public void setOp(String op) {
		this.op = op;
	}



	public List<SimpleComVO> getList() {
		return list;
	}



	public void setList(List<SimpleComVO> list) {
		this.list = list;
	}



	private String op;
	
	private List<SimpleComVO> list;
	
	
	
	
	
}
