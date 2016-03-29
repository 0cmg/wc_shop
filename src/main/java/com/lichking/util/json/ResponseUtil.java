package com.lichking.util.json;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {

	/**
	 * 在response中输出对象  前端获得的是json数据类型
	 * @param response
	 * @param object
	 * @throws Exception
	 */
	public static void write(HttpServletResponse response, Object object)
			throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(object);
		out.flush();
		out.close();
	}
}
