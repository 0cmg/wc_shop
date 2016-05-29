package com.lichking.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lichking.itf.service.ICommodityInfoService;
import com.lichking.itf.service.IExpressInfoService;
import com.lichking.itf.service.IOrderInfoService;
import com.lichking.pojo.web.CommodityInfoVO;
import com.lichking.pojo.web.ExpressInfoVO;
import com.lichking.pojo.web.OrderInfoVO;
import com.lichking.pojo.web.ResultVO;
import com.lichking.pojo.web.co.OrderDetailsVO;
import com.lichking.pojo.web.co.go.SimpleCANVO;
import com.lichking.util.StringUtil;


@Controller
@RequestMapping("/back/data")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BMOrderDataController {

	Logger logger = Logger.getLogger(BMOrderDataController.class);
	
	@Resource
	private IOrderInfoService orderInfoService;
	
	@Resource
	private IExpressInfoService expressInfoService;
	
	@Resource
	private ICommodityInfoService commodityInfoService;
	
	@RequestMapping(value="/queryUntreatedOrder",method=RequestMethod.GET)
	public @ResponseBody ResultVO queryUntreatedOrder(){
		logger.info("/back/data/queryUntreatedOrder");
		ResultVO result = new ResultVO();
		
		OrderInfoVO queryvo = new OrderInfoVO();
		Short status = 1;
		queryvo.setStatus(status);
		
		List<OrderInfoVO> oivo_list = this.orderInfoService.selectByWhere(queryvo);
		
		result.setResult(true);
		result.setT(oivo_list);
		
		return result;
	}
	
	@RequestMapping(value="/paid",method=RequestMethod.POST)
	public @ResponseBody ResultVO paid(@RequestBody String orderno){
		logger.info("/back/data/paid");
		ResultVO result = new ResultVO();
		
		OrderInfoVO queryvo = new OrderInfoVO();
		orderno = orderno.substring(1, orderno.length()-1);
		queryvo.setOrderno(orderno);
		queryvo.setDealtime(new Date());
		Short status = 1;
		queryvo.setStatus(status);
		
		int r = this.orderInfoService.updateByPKSelective(queryvo);
		if(r == 1){
			result.setResult(true);
		}else{
			result.setResult(false);
		}
		return result;
	}
	
	
	@RequestMapping(value="/queryUnpaidOrder",method=RequestMethod.GET)
	public @ResponseBody ResultVO queryUnpaidOrder(){
		logger.info("/back/data/queryUnpaidOrder");
		ResultVO result = new ResultVO();
		
		OrderInfoVO queryvo = new OrderInfoVO();
		Short status = 0;
		queryvo.setStatus(status);
		
		List<OrderInfoVO> oivo_list = this.orderInfoService.selectByWhere(queryvo);
		
		result.setResult(true);
		result.setT(oivo_list);
		
		return result;
	}
	
	@RequestMapping(value="/deleteOrder",method=RequestMethod.GET)
	public @ResponseBody ResultVO deleteOrder(HttpServletRequest req){
		logger.info("/back/data/deleteOrder");
		ResultVO result = new ResultVO();
		
		String on = req.getParameter("on");
		
		OrderInfoVO oivo = this.orderInfoService.selectByPK(on);
		Short s0 = 0;
		Short s1 = 1;
		Short s2 = 2;
		if(oivo.getStatus().equals(s1) || oivo.getStatus().equals(s2)){
			result.setResult(false);
		}else if(oivo.getStatus().equals(s0)){
			int r = this.orderInfoService.deleteByPK(on);
			if(r == 1){
				result.setResult(true);
			}else{
				result.setResult(false);
			}
		}
		
		return result;
	}
	
	@RequestMapping(value="/finishOrder",method=RequestMethod.POST)
	public @ResponseBody ResultVO finishOrder(@RequestBody ExpressInfoVO eivo){
		logger.info("/back/data/finishOrder");
		ResultVO result = new ResultVO();
		
		if(!StringUtil.isnull(eivo.getOrderno()) && !StringUtil.isnull(eivo.getExpresstype()) && !StringUtil.isnull(eivo.getExpressno())){
			int r = this.expressInfoService.insertSelective(eivo);
			if(r == 1){
				OrderInfoVO uvo = new OrderInfoVO();
				uvo.setOrderno(eivo.getOrderno());
				Short status = 2;
				uvo.setStatus(status);
				int r2 = this.orderInfoService.updateByPKSelective(uvo);
				uvo = this.orderInfoService.selectByPK(eivo.getOrderno());
				boolean s = updateComSell(uvo);
				if(r2 == 1 && s){
					result.setResult(true);
				}else{
					result.setResult(false);
				}
				
			}else{
				result.setResult(false);
			}
		}else{
			result.setResult(false);
		}
		
		
		return result;
	}
	
	//更新商品的库存和已售数量
	private boolean updateComSell(OrderInfoVO uvo){
		boolean status = true;
		String detail = uvo.getOrderdetails();
		JSONObject jsonDetail = JSONObject.fromObject(detail);
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("scan_list", SimpleCANVO.class);
		OrderDetailsVO odvo = (OrderDetailsVO)JSONObject.toBean(jsonDetail, OrderDetailsVO.class,classMap);
		if(odvo == null)
			return false;
		List<SimpleCANVO> scanvo_list = odvo.getScan_list();
		for(SimpleCANVO scanvo : scanvo_list){
			Integer id = scanvo.getCom_id();
			Integer num = scanvo.getCom_num();
			CommodityInfoVO cvo = this.commodityInfoService.selectByPK(id);
			cvo.setSellno(cvo.getSellno()+num);
			cvo.setRestno(cvo.getRestno()-num);
			int r = this.commodityInfoService.updateComByPKSelective(cvo);
			if(r != 1){
				status = false;
			}
		}
		return status;
 	}
	
}
