package com.lichking.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lichking.itf.service.IOrderInfoService;
import com.lichking.itf.service.IVisitorsService;
import com.lichking.pojo.web.OrderInfoVO;
import com.lichking.pojo.web.OverviewDataVO;
import com.lichking.pojo.web.ResultVO;
import com.lichking.pojo.web.VisitorsVO;
import com.lichking.util.DateUtil;


@Controller
@RequestMapping("/back/data")
public class BMOverviewDataController {

	@Resource
	private IVisitorsService visitorsService;
	
	@Resource
	private IOrderInfoService orderInfoService;
	
	Logger logger = Logger.getLogger(BMOverviewDataController.class);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/getOverviewData",method=RequestMethod.GET)
	public @ResponseBody ResultVO vgetOverviewData(){
		
		logger.info("/back/data/getOverviewData");
		ResultVO result = new ResultVO();
		
		OverviewDataVO odvo = new OverviewDataVO();
		
		VisitorsVO query_vvo = new VisitorsVO();
		query_vvo.setDate(new Date());
		List<VisitorsVO> vvo_list = this.visitorsService.selectByWhere(query_vvo);
		Integer vn;
		if(vvo_list.size() == 0){
			vn=0;
		}else{
			vn = vvo_list.get(0).getNumber();
		}
		odvo.setVn(vn);
		
		query_vvo.setDate(DateUtil.getYesterdayZero());
		vvo_list = this.visitorsService.selectByWhere(query_vvo);
		Integer vn_y;
		double vn_c;
		if(vvo_list.size() == 0){
			vn_y = 0;
			if(vn != 0){
				vn_c = 1.0;
			}else{
				vn_c = 0.0;
			}
		}else{
			vn_y = vvo_list.get(0).getNumber();
			vn_c = (double)(vn-vn_y)/vn_y;
		}
		
		odvo.setVn_c(vn_c);
		
		HashMap<String,Date> query_map = new HashMap<String,Date>();
		query_map.put("before", DateUtil.getTodayZero());
		query_map.put("after", DateUtil.getTomorrowZero());
		List<OrderInfoVO> oivo_list = this.orderInfoService.selectByDate(query_map);
		double today_turnover = getListValueSum(oivo_list);
		Integer today_on = oivo_list.size();
		odvo.setToday_turnover(today_turnover);
		odvo.setToday_on(today_on);
		
		query_map.clear();
		query_map.put("before", DateUtil.getYesterdayZero());
		query_map.put("after", DateUtil.getTodayZero());
		oivo_list.clear();
		oivo_list = this.orderInfoService.selectByDate(query_map);
		double yestoday_turnover = getListValueSum(oivo_list);
		double tt_c;
		try{
			tt_c = (double)(today_turnover - yestoday_turnover)/yestoday_turnover;
		} catch(Exception  e){
			tt_c = 1.0;
		}
		Integer yestoday_on = oivo_list.size();
		double to_c;
		try{
			to_c = (double)(today_on - yestoday_on) / yestoday_on;
		} catch(Exception  e){
			to_c = 1.0;
		}
		odvo.setTt_c(tt_c);
		odvo.setTo_c(to_c);
		
		query_map.clear();
		query_map.put("before", DateUtil.getThisWeekZero());
		query_map.put("after", new Date());
		oivo_list.clear();
		oivo_list = this.orderInfoService.selectByDate(query_map);
		double thisweek_turnover = getListValueSum(oivo_list);
		Integer thisweek_on = oivo_list.size();
		odvo.setThisweek_turnover(thisweek_turnover);
		odvo.setThisweek_on(thisweek_on);
		
		query_map.clear();
		query_map.put("before", DateUtil.getLastWeekZero());
		query_map.put("after", DateUtil.getThisWeekZero());
		oivo_list.clear();
		oivo_list = this.orderInfoService.selectByDate(query_map);
		double lastweek_turnover = getListValueSum(oivo_list);
		double twt_c;
		try{
			twt_c = (double)(thisweek_turnover - lastweek_turnover) / lastweek_turnover;
		} catch(Exception  e){
			twt_c = 1.0;
		}
		Integer lastweek_on = oivo_list.size();
		double two_c;
		try{
			two_c = (double)(thisweek_on - lastweek_on) / lastweek_on;
		} catch (Exception e ){
			two_c = 1.0;
		}
		odvo.setTwt_c(twt_c);
		odvo.setTwo_c(two_c);
		
		result.setResult(true);
		result.setT(odvo);
		
		return result;
		
	}
	
	private double getListValueSum(List<OrderInfoVO> oivo_list){
		double sum = 0.0;
		for(OrderInfoVO oivo : oivo_list){
			sum += oivo.getValue();
		}
		return sum;
	}
	
}
