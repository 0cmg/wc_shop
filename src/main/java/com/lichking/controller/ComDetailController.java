package com.lichking.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lichking.itf.service.ICommodityInfoService;
import com.lichking.pojo.web.CommodityInfoVO;
import com.lichking.pojo.web.ResultVO;

@Controller
@RequestMapping("/com")
@SuppressWarnings({"rawtypes","unchecked"})
public class ComDetailController {

	Logger logger = Logger.getLogger(ComDetailController.class);
	
	@Resource
	private ICommodityInfoService commodityInfoService;
	
	@RequestMapping(value="/showdetail/{comid}",method=RequestMethod.GET)
	public String vshowDetail(@PathVariable("comid") Integer comid,Model model){
		
		logger.info("请求路径：/com/showdetail/"+comid);
		model.addAttribute("comid", comid);
		return "front/comdetail";
		
	}
	
	
	@RequestMapping(value="/getComAllInfo/{comid}",method=RequestMethod.GET)
	public @ResponseBody ResultVO vgetComAllInfo(@PathVariable("comid") Integer comid){
		
		logger.info("请求数据:/com/getComAllInfo/"+comid);
		ResultVO result = new ResultVO();
		
		CommodityInfoVO civo = this.commodityInfoService.selectByPK(comid);
		result.setResult(true);
		result.setT(civo);
		
		return result;
		
	}
	
}
