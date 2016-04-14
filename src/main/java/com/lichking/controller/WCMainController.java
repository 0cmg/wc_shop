package com.lichking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lichking.logicalprocessor.MainProcessor;
import com.lichking.util.wechat.Check_token;



@Controller
public class WCMainController {
	
	Logger logger = Logger.getLogger(WCMainController.class);
	
	//微信服务器配置验证token入口
	@RequestMapping(value="/WeChatPortal",method=RequestMethod.GET)
	public void vWeChatPortal_g(HttpServletRequest req, HttpServletResponse res){
		
		
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		PrintWriter pw = null;
		try {
			pw = res.getWriter();
			if("".equals(signature) || "".equals(timestamp) || "".equals(nonce)
					|| signature==null || timestamp==null  || nonce==null){
				return;
			}
			if(Check_token.checkSignature(signature, timestamp, nonce)){
				pw.print(echostr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			pw.close();
		}
		
	}
	
	//与微信服务器交互的入口
	@RequestMapping(value="/WeChatPortal",method=RequestMethod.POST)
	public void vWeChatPortal_p(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		logger.info(new Date());
		
		MainProcessor.doMainProcess(req, resp);
		
	}
}
