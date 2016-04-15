package com.lichking.util.wcapi;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.lichking.pojo.dic.AppDic;
import com.lichking.pojo.dic.UrlDic;

public class Oauth2OptionI {

	private static Logger logger = Logger.getLogger(Oauth2OptionI.class);
	
	/**
	 * 通过code调用微信api获取用户的openid 唯一标识符  获得后请检测是否为 空
	 * @param code
	 * @return
	 */
	public static String getOpenid(String code){
		String url = UrlDic.OAUTH2_GETINFO_URL.replace("APPID", AppDic.APPID).replace("SECRET", AppDic.APPSECRET).replace("CODE", code);
		JSONObject jsonObject = HttpRequestI.doGetStr(url);
		String openid = "";
		try{
			openid = jsonObject.getString("openid");
		}catch(Exception e){
			String errorCode = jsonObject.getString("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			logger.error("获取网页授权失败 errcode{"+errorCode+"},errMsg:"+ errorMsg);
		}
		return openid;
	}
	
}
