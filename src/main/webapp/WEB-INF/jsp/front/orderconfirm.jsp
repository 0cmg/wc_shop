<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单确认</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="../css/weui.min.css" rel="stylesheet" media="screen">
	<link href="http://libs.baidu.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="../css/frame.css" rel="stylesheet" media="screen">
	<link href="../css/orderconfirm.css" rel="stylesheet" media="screen">
	<script type="text/javascript" src="http://libs.baidu.com/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript" src="http://libs.baidu.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
	<script type="text/javascript" src="../js/orderconfirm.jquery.js"></script>
	
  </head>
  
  <body>
    <div class="weui_tab">
	<div class="weui_navbar">
		<div class="weui_navbar_item "><a href="/wc_shop/home/main">商城首页</a></div>
		<div class="weui_navbar_item"></div>
		<div class="weui_navbar_item"><a href="address">个人信息</a></div>
	</div>
	<div id="hidden_param" style="display:none;">${info}</div>
	<div id="hidden_param2" style="display:none;">${cb_index}</div>
	<div class="weui_tab_bd" style="padding-top:30px;">
		<div class="weui_cells_title">商品信息</div>
	    <div class="weui_cells weui_cells_access" id="com_list">
	    <!-- 
	      <div class="weui_cell">
	        <div class="weui_cell_hd">
	          <img src="http://mmrb.github.io/avatar/jf.jpg" alt="" class="cover">
	        </div>
	        <div class="weui_cell_bd weui_cell_primary">
	          <h3 class="title">WeUI 发布——微信官方UI库</h3>
	          <p class="summary">团队里的几个小伙子把微信里面web app的UI，按照设计规范给梳理了一遍，并将之开源了出来。</p>
	        </div>
	        <div class="pan">
	        	<div id="price">
		        	价格：<span class="red">699 ￥</span>
		        </div>
		        <div id="number">数量：2</div>
	        </div>
	        <div class="weui_cell_ft">
	        </div>
	      </div>
	       -->
	    </div>
	    
	    <div id="tp">
	    	<div id="tpc">总计：</div>
	    	<div id="total_price" class="red"></div>
	    </div>
	    
	    <div class="weui_cells_title">请选择联系方式</div>
		<div class="weui_cells weui_cells_radio" id="phone_list">
		</div>
		<div class="weui_cells_title">请选择收货地址</div>
		<div class="weui_cells weui_cells_radio" id="address_list">
		</div>
	    
	</div>
	<div class="weui_tabbar">
        <div  class="weui_tabbar_item">
            <p class="weui_tabbar_label weui_btn weui_btn_warn" id="buy">立即付款</p>
        </div>
    </div>
	</div>
    
  </body>
</html>
