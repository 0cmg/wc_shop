<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>${name}</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="../../css/weui.min.css" rel="stylesheet" media="screen">
<link href="../../css/comdetail.css" rel="stylesheet" media="screen">
<link href="../../css/imgslider/style.css" rel="stylesheet" media="screen">
<link href="http://libs.baidu.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript" src="http://libs.baidu.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/comdetail.jquery.js"></script>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>


</head>

<body>
	<div class="weui_tab">
	<div class="weui_navbar">
		<div class="weui_navbar_item "><a href="/wc_shop/home/main">商城首页</a></div>
		<div class="weui_navbar_item"></div>
		<div class="weui_navbar_item">购物车</div>
	</div>
	<div id="hidden_param" style="display:none;">${comid}</div>
    <div class="weui_tab_bd">
        <div id="wowslider-container1" style="margin:40px auto 12.5px;width:100%;text-align:center;max-height:360px;max-width:360px;">
        <!--  例子
			<div class="ws_images">
				<ul>
					<li><img src="data1/images/1.jpg" alt="1" title="1" id="wows1_0"></li>
					<li><img src="data1/images/2.jpg" alt="2" title="2" id="wows1_1"></li>
					<li><a href="http://wowslider.com/vi"><img src="data1/images/3.jpg" alt="bootstrap carousel" title="3" id="wows1_2"></a></li>
					<li><img src="data1/images/4.jpg" alt="4" title="4" id="wows1_3"></li>
				</ul>
			</div>
			<div class="ws_bullets">
				<div>
					<a href="#" title="1"><span><img src="data1/tooltips/1.jpg" alt="1">1</span></a>
					<a href="#" title="2"><span><img src="data1/tooltips/2.jpg" alt="2">2</span></a>
					<a href="#" title="3"><span><img src="data1/tooltips/3.jpg" alt="3">3</span></a>
					<a href="#" title="4"><span><img src="data1/tooltips/4.jpg" alt="4">4</span></a>
				</div>
			</div>
			<div class="ws_script" style="position:absolute;left:-99%"></div>
		<div class="ws_shadow"></div>
		-->
		</div>
		<hr />
		<div id="dapac">
			<div id="dap">
				<div id="ds"></div>
				<div id="price"></div>
			</div>
			<div id="count">
				<input class="min" name="" type="button" value="-" />
				<input class="com_count" name="comnum" type="text" value="1" style="width:25px;" />
				<input class="add" name="" type="button" value="+" />
			</div>
		</div>
		<hr />
		<div id="sri">
			<div id="ri">
				<span id="rc">剩余：</span>
				<span id="rn"></span>
			</div>
			<div id="si">
				<span id="sr">销量：</span>
				<span id="sn"></span>
			</div>
		</div>
		<hr />
		<div id="detail">
			
		</div>
		
    </div>
    <div class="weui_tabbar">
        <div  class="weui_tabbar_item">
            <p class="weui_tabbar_label shopcart weui_btn weui_btn_primary">加入购物车</p>
        </div>
        <div  class="weui_tabbar_item">
            <p class="weui_tabbar_label buy weui_btn weui_btn_primary">立即购买</p>
        </div>
        
    </div>
</div>
</body>
</html>
