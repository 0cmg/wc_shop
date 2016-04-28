package com.lichking.pojo.dic;

public class UrlDic {

	
	//获取access_token的请求地址
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	//商城首页地址
	public static final String SHOP_INDEX_URL = "http://lichking.top/wc_shop/home/main";
	
	public static final String ADDRESS_MANAGE_URL = "http://lichking.top/wc_shop/home/address";
	
	//oauth2 认证获取openid的入口地址 参阅 http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html
	public static final String OAUTH2_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	
	//使用code获取用户信息openid
	public static final String OAUTH2_GETINFO_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	
	
}
