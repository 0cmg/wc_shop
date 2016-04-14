package com.lichking.logicalprocessor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lichking.util.wechat.MessageUtil;

public class MainProcessor {

	private static Logger logger = Logger.getLogger(MainProcessor.class);
	
	public static void doMainProcess(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		MenuProcessor.doMenuProcess();
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		try{
			Map<String,String> map = MessageUtil.XmlToMap(req);
			
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
		
			logger.info("from:"+fromUserName);
			logger.info("MsgType:"+msgType);
			logger.info("Content:"+content);
			
			String message = null;
			if(MessageUtil.MESSAGE_TEXT.equals(msgType)){
				String response_content = content;
				message = MessageUtil.initText(toUserName, fromUserName, response_content);
			}
			pw.print(message);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
		
	}
	
}
