<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>微信商城后台管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="http://libs.baidu.com/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript" src="/wc_shop/js/sha1.js"></script>
</head>

<body>
	<div id="login_div">
		<form id="login_form" name="login_form" action="" method="post">
			<table width="300" border="0" >
				<tr class="thickrow">
					<td colspan="2"  >请登录</td>
				</tr>
				<tr class="thickrow">
					<td>用户名</td>
					<td><input id="username" type="text" name="username" size="16"></td>
				</tr>
				<tr class="thickrow">
					<td>密码</td>
					<td><input id="password" type="password" name="password"
						size="16"></td>
				</tr>
				<tr>
					<td colspan="2" ><input id="login_btn" class="btn"
						type="button" value="登录">
				</tr>
			</table>
		</form>
		<div id="msg"></div>
	</div>
	<script type="text/javascript" src="/wc_shop/js/login.jquery.js"></script>
</body>
<script type="text/javascript" src="http://libs.baidu.com/jqueryui/1.8.22/jquery-ui.min.js"></script>
<link href="http://libs.baidu.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="http://libs.baidu.com/bootstrap/2.3.2/js/bootstrap.min.js"></script>
<link href="../css/createnewcom.css" rel="stylesheet" >
<link href="../css/login.css" rel="stylesheet">
</html>
