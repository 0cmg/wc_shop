package com.lichking.pojo.web.co;

import java.util.List;

import com.lichking.pojo.web.co.go.SimpleCANVO;

public class OrderDetailsVO {

	private String address;
	
	private String phone;
	
	private List<SimpleCANVO> scan_list;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<SimpleCANVO> getScan_list() {
		return scan_list;
	}

	public void setScan_list(List<SimpleCANVO> scan_list) {
		this.scan_list = scan_list;
	}
	
	
	
}
