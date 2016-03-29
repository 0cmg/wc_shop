package com.lichking.util.session;

import javax.servlet.http.HttpServletRequest;

/**
 * 判断用户
 * @author LichKing
 *
 */
public class UserJudge {

	/**
	 * 判断session中存放的用户是否为管理员
	 * （仅后台管理系统需要用到此方法）
	 * @param session_name
	 * @param req
	 * @return
	 */
	public static boolean isAdmin(String session_name,HttpServletRequest req){
		String user = (String) req.getSession().getAttribute(session_name);
		if(user == null)
			return false;
		return true;
	}
	
}
