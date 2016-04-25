package com.lichking.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lichking.util.session.HomeSessionCheck;
import com.lichking.util.wcapi.Oauth2OptionI;

@Controller
@RequestMapping("/home")
public class HomeController {
	
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
				return "front/customerinfo";
			}
		}
	}
	
	@RequestMapping("/addaddress")
	public String vGetAddress(){
		return "front/addaddress";
	}
	
	@RequestMapping("/comdetail")
	public String vcomDetail(){
		return "front/comdetail";
	}
	
}
