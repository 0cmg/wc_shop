package com.lichking.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lichking.itf.service.IVisitorsService;
import com.lichking.pojo.web.VisitorsVO;
import com.lichking.util.session.HomeSessionCheck;
import com.lichking.util.wcapi.Oauth2OptionI;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Resource
	private IVisitorsService visitorsService;
	
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
