package com.lichking.pojo.web;

import java.util.List;

import com.lichking.pojo.web.co.SimpleComPOJO;

/**
 * 用于前后台 商品库存操作的对象
 * @author LichKing
 *
 */
public class ComIMPOJO {

	public String getOp() {
		return op;
	}



	public void setOp(String op) {
		this.op = op;
	}



	public List<SimpleComPOJO> getList() {
		return list;
	}



	public void setList(List<SimpleComPOJO> list) {
		this.list = list;
	}



	private String op;
	
	private List<SimpleComPOJO> list;
	
	
	
	
	
}
