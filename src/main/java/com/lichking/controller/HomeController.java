package com.lichking.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lichking.itf.service.ICommodityInfoService;
import com.lichking.itf.service.IOrderInfoService;
import com.lichking.itf.service.IVisitorsService;
import com.lichking.pojo.web.CommodityInfoVO;
import com.lichking.pojo.web.ResultVO;
import com.lichking.pojo.web.VisitorsVO;
import com.lichking.util.session.HomeSessionCheck;
import com.lichking.util.wcapi.Oauth2OptionI;
import com.lichking.pojo.web.OrderInfoVO;
import com.lichking.pojo.web.co.OrderDetailsVO;
import com.lichking.pojo.web.co.go.SimpleCANVO;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Resource
	private IVisitorsService visitorsService;
	
	@Resource 
	private ICommodityInfoService commodityInfoService;
	
	@Resource
	private IOrderInfoService orderInfoService;
	
	
	private Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/main")
	public String vHomePage(HttpServletRequest req){
		if(HomeSessionCheck.openidCheck(req)){
			return "front/home";
		}else{
			String code = req.getParameter("code");
			if(code == null || code == "" || code.equals(""))
				return  "error";
			logger.info("code:"+code);
			String openid = Oauth2OptionI.getOpenid(code);
			if(openid.equals("") || openid == ""){
				return "error";
			}else{
				//openid 用户的唯一标识符
				req.getSession().setAttribute("openid", openid);
				logger.info("获取到openid："+openid);
				TrafficStatistics();
				return "front/home";
			}
		}
		
	}
	
	@RequestMapping("/address")
	public String vAddress(HttpServletRequest req){
		logger.info("请求地址：/home/address");
		if(HomeSessionCheck.openidCheck(req)){
			return "front/customerinfo";
		}else{
			String code = req.getParameter("code");
			logger.info("code:"+code);
			if(code == "" || code.equals("") || code == null)
				return "error";
			String openid = Oauth2OptionI.getOpenid(code);
			if(openid.equals("") || openid == ""){
				return "error";
			}else{
				//openid 用户的唯一标识符
				req.getSession().setAttribute("openid", openid);
				logger.info("获取到openid："+openid);
				TrafficStatistics();
				return "front/customerinfo";
			}
		}
	}
	
	@RequestMapping("/addaddress")
	public String vGetAddress(){
		return "front/addaddress";
	}
	
	@RequestMapping("/shopcart")
	public String vcomDetail(){
		return "front/shopcart";
	}
	
	@RequestMapping(value="/orderconfirm",method=RequestMethod.GET)
	public String vorderConfirm(HttpServletRequest req,Model model){
		model.addAttribute("info", req.getParameter("info"));
		model.addAttribute("cb_index",req.getParameter("cb_index"));
		return "front/orderconfirm";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/submitOrder",method=RequestMethod.POST)
	public @ResponseBody ResultVO vsubmitOrder(@RequestBody OrderInfoVO oivo,Model model,HttpServletRequest req){
		logger.info("提交订单：/home/submitOrder");
		
		ResultVO result = new ResultVO();
		
		Date date = new Date();
		oivo.setDealtime(date);
		UUID uuid = UUID.randomUUID();
		oivo.setOrderno(uuid.toString());
		Short status = 0;
		oivo.setStatus(status);
		if(HomeSessionCheck.openidCheck(req)){
			String openid = HomeSessionCheck.getOpenid(req);
			oivo.setCustomerid(openid);
			String od = oivo.getOrderdetails();
			JSONObject jsonObject = JSONObject.fromObject(od);
			Map<String, Class> classMap = new HashMap<String, Class>();
			classMap.put("scan_list", SimpleCANVO.class);
			OrderDetailsVO odvo = (OrderDetailsVO)JSONObject.toBean(jsonObject, OrderDetailsVO.class,classMap);
			List<SimpleCANVO> scan_list = odvo.getScan_list();
			Double tp = 0.0;
			for(SimpleCANVO scan : scan_list){
				CommodityInfoVO civo = this.commodityInfoService.selectByPK(scan.getCom_id());
				if(civo == null){
					result.setResult(false);
					result.setMsg("参数错误");
					return result;
				}
					
				tp += civo.getPrice()*scan.getCom_num();
			}
			if(!tp.equals(oivo.getValue())){
				result.setResult(false);
				result.setMsg("请检查价格");
				return result;
			}
				
			
			
			int r = this.orderInfoService.insert(oivo);
			if(r != 1){
				result.setResult(false);
				result.setMsg("生成订单时错误");
				return result;
			}
		}else{
			result.setResult(false);
			result.setMsg("非法用户");
			return result;
		}
		result.setResult(true);
		result.setMsg(oivo.getOrderno());
		return result;
	}
	
	@RequestMapping(value="/pay",method=RequestMethod.GET)
	public String vpay(HttpServletRequest req,Model model){
		String uuid = req.getParameter("on");
		OrderInfoVO oivo = this.orderInfoService.selectByPK(uuid);
		if(oivo != null){
			model.addAttribute("on", uuid);
			return "front/pay";
		}
		return "error";
	}
	
	@RequestMapping(value="/myorder")
	public String vMyOrder(){
		return "front/myorder";
	}
	
	//访问量统计
	private void TrafficStatistics(){
		
		VisitorsVO vvo = new VisitorsVO();
		vvo.setDate(new Date());
		
		List<VisitorsVO> vvo_list = this.visitorsService.selectByWhere(vvo);
		if(vvo_list.size() == 0){
			vvo.setNumber(1);
			int r = this.visitorsService.insertSelective(vvo);
			if(r == 1){
				logger.info("本日访问记录已插入");
			}else{
				logger.error("本日访问记录插入错误");
			}
		}else if(vvo_list.size() == 1){
			VisitorsVO vvo_indb = vvo_list.get(0);
			vvo_indb.setNumber(vvo_indb.getNumber()+1);
			int r = this.visitorsService.updateByPKSelective(vvo_indb);
			if(r == 1){
				logger.info("本日访问记录已更新");
			}else{
				logger.error("本日访问记录更新错误");
			}
		}
		
	}
	
}
