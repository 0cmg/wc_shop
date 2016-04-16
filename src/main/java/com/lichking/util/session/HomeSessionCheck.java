package com.lichking.util.session;

import javax.servlet.http.HttpServletRequest;

public class HomeSessionCheck {

	public static boolean openidCheck(HttpServletRequest req){
		String openid = (String)req.getSession().getAttribute("openid");
		if(openid == null || openid == "" || openid.equals(""))
			return false;
		return true;
	}
	
}
