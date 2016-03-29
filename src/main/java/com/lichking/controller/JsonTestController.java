package com.lichking.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.lichking.itf.service.ICommodityTypeService;
import com.lichking.pojo.web.CommodityTypeVO;
import com.lichking.util.json.ResponseUtil;


@Controller
@RequestMapping("/test")
public class JsonTestController {

	@Resource
	private ICommodityTypeService commodityTypeService;
	
	@RequestMapping("/getallctypes")
	public String getAllCommodityTypes(HttpServletResponse res) throws Exception{
		JSONObject jsonObject = new JSONObject();
		List<CommodityTypeVO> c_list = this.commodityTypeService.getAllTypes();
		int count = 0;
		for(CommodityTypeVO c_type : c_list){
			String type = c_type.getType();
			jsonObject.put("type"+String.valueOf(count), type);
			count++;
		}
		ResponseUtil.write(res, jsonObject);
		return null;
	}
	
}
