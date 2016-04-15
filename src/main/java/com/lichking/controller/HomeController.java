package com.lichking.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lichking.util.wcapi.Oauth2OptionI;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/main")
	public String getHomePage(HttpServletRequest req){
		String code = req.getParameter("code");
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
	
	@RequestMapping("/address")
	public String getAddress(){
		return "front/address";
	}
	
}
