<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>我的购物车</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="../css/weui.min.css" rel="stylesheet" media="screen">
	<link href="http://libs.baidu.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="../css/shopcart.css" rel="stylesheet" media="screen">
	<script type="text/javascript" src="http://libs.baidu.com/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript" src="http://libs.baidu.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
	<script type="text/javascript" src="../js/shopcart.jquery.js"></script>
  </head>
  
  <body>
    <div class="weui_tab">
	<div class="weui_navbar">
		<div class="weui_navbar_item "><a href="/wc_shop/home/main">商城首页</a></div>
		<div class="weui_navbar_item"></div>
		<div class="weui_navbar_item">我的订单</div>
	</div>
	<div class="weui_tab_bd" style="padding-top:30px;">
		<div class="weui_cells_title">我的购物车</div>
		<div class="weui_cells weui_cells_checkbox" id="checkbox">
		<!--  
		    <label class="weui_cell weui_check_label check" for="1" id="0">
		        <div class="weui_cell_hd">
		            <input type="checkbox" class="weui_check" name="checkbox1" id="1">
		            <i class="weui_icon_checked"></i>
		        </div>
		        <div class="weui_cell_bd weui_cell_primary">
		            <div id="cominfo">
		            	<div id="img">
		            		<img id="ip" src="../img/star.jpg"></img>
		            	</div>
		            	<div id="nad">
		            		<div id="name">测试</div>
		            		<div id="desc">测试一号简要描述22</div>
		            	</div>
		            	<div id="pan">
		            		<div id="price">
		            			<span id="pc">价格：</span>
		            			<span id="pn"> 1 ￥</span>
		            		</div>
		            		<div id="number">
		            			<span id="nc">数量：</span>
		            			<span id="nn">1</span>
		            		</div>
		            	</div>
		            </div>
		        </div>
		    </label>
		    <label class="weui_cell weui_check_label" for="s12">
		        <div class="weui_cell_hd">
		            <input type="checkbox" name="checkbox1" class="weui_check" id="s12">
		            <i class="weui_icon_checked"></i>
		        </div>
		        <div class="weui_cell_bd weui_cell_primary">
		            <p>standard is dealicient for u.</p>
		        </div>
		    </label>
		    -->
		</div>
	</div>
	<div class="weui_tabbar">
        <div  class="weui_tabbar_item">
            <p class="weui_tabbar_label weui_btn weui_btn_primary yellow" id="delete">删除</p>
        </div>
        <div  class="weui_tabbar_item">
            <p class="weui_tabbar_label weui_btn weui_btn_primary" id="buy">立即付款</p>
        </div>
    </div>
	</div>
    
  </body>
</html>
