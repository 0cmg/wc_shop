<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<!--   加载太慢，已放弃
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
-->

<link href="../css/footer.css" rel="stylesheet">
<link href="../css/home.css" rel="stylesheet">
<link href="../css/default.css" rel="stylesheet">
<link href="http://libs.baidu.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/bootstrap.offcanvas.min.css" rel="stylesheet">
<link href="../css/default.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>首页</title>
</head>
<body class="body-offcanvas">
<header class="clearfix">
	<button type="button" class="navbar-toggle offcanvas-toggle" style="float:left;"><a href="main">首页</a></button>
    <button type="button" class="navbar-toggle offcanvas-toggle" data-toggle="offcanvas" data-target="#js-bootstrap-offcanvas" style="float:left;">筛选</button>
    <button type="button" class="navbar-toggle offcanvas-toggle" data-toggle="offcanvas" data-target="#js-bootstrap-offcanvas-2">更多</button>
	<!-- 点击筛选  弹出的窗口 -->
    <nav class="navbar navbar-default navbar-offcanvas navbar-offcanvas-touch navbar-offcanvas-fade" role="navigation" id="js-bootstrap-offcanvas">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">请选择商品类型</a>
                <button type="button" class="navbar-toggle offcanvas-toggle pull-right" data-toggle="offcanvas" data-target="#js-bootstrap-offcanvas" style="float:left;">
                    <span class="sr-only">Toggle navigation</span>
                    <i class="glyphicon glyphicon-remove"></i>
                </button>
            </div>
            <div>
                <ul class="nav navbar-nav" id="type_list">
                    <li class="active"><a href="#">全部</a></li>
                    <li><a href="#">测试</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- 点击更多 弹出的窗口 -->
    <nav class="navbar navbar-default navbar-offcanvas navbar-offcanvas-touch navbar-offcanvas-fade" role="navigation" id="js-bootstrap-offcanvas-2">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">更多选项</a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="myorder">我的订单</a></li>
                        <li><a href="address">个人信息</a></li>
                        <li><a href="shopcart">购物车</a></li>
                    </ul>
                </div>
            </div>
        </nav>
</header>
<div id="search_area">
		<input id="search_input" class="input-medium search-query" type="text" />
		<button id="search_button" class="btn btn-primary" type="submit" >查找</button>
	</div>
	
	<hr />
	<div class="row-fluid" id="content">
		<div class="shop_photos"></div>
		<div class="shop_info"></div>
		<div class="commodity_list">
		
			<!-- 一个商品的div模版 -->
			<!--  
			<div id="1" class="commodity">
				<div class="commodity_photo">
					<img id="11" class="com_img" src="../img/star.jpg"></img>
				</div>
				<div class="commodity_desc">
					<div class="desc">
						<div id="com_name">测试商品</div><br id="smallbr" />
						<div id="com_sdesc">测试商品简要描述</div>
					</div>
				</div>
				<div class="commodity_price">
					<div class="price">
						20 ￥
					</div>
				</div>
				<br style="clear:both;" />
			</div>
			-->
		</div>
	</div>
<%@ include file="../footer.html" %>
<script type="text/javascript" src="/wc_shop/js/footer.js"></script>
</body>
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript" src="http://libs.baidu.com/jqueryui/1.8.22/jquery-ui.min.js"></script>
<script type="text/javascript" src="http://libs.baidu.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.offcanvas.js"></script>
<script type="text/javascript" src="../js/home.jquery.js"></script>
</html>
