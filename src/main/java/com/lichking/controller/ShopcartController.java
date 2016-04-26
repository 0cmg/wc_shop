package com.lichking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lichking.itf.service.ICommodityInfoService;
import com.lichking.pojo.web.ComAndNoVO;
import com.lichking.pojo.web.ComidAndNoVO;
import com.lichking.pojo.web.CommodityInfoVO;
import com.lichking.pojo.web.ResultVO;


@Controller
@RequestMapping("/front/data")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ShopcartController {

	private Logger logger = Logger.getLogger(ShopcartController.class);
	
	@Resource
	private ICommodityInfoService commodityInfoService;
	
	
	@RequestMapping(value="/getShopcart",method=RequestMethod.POST)
	public @ResponseBody ResultVO vgetShopcart(@RequestBody List<ComidAndNoVO> canvo_list){
		logger.info("请求数据：/front/data/getShopcart");
		ResultVO result = new ResultVO();
		
		List<ComAndNoVO> comanvo_list = new ArrayList<ComAndNoVO>();
		for(ComidAndNoVO canvo : canvo_list){
			Integer comid = canvo.getComid();
			CommodityInfoVO civo = this.commodityInfoService.selectByPK(comid);
			
			civo.setDescdetails("");
			
			ComAndNoVO comanvo = new ComAndNoVO();
			comanvo.setCivo(civo);
			comanvo.setNumber(canvo.getNumber());
			comanvo_list.add(comanvo);
		}
		result.setT(comanvo_list);
		result.setResult(true);
		
		return result;
	}
	
}
