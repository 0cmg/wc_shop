<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
    <title>收货地址管理</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<link href="../css/footer.css" rel="stylesheet">
	<script type="text/javascript" src="http://libs.baidu.com/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript" src="http://libs.baidu.com/jqueryui/1.8.22/jquery-ui.min.js"></script>
	<script type="text/javascript" src="http://libs.baidu.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<link href="http://libs.baidu.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="../css/weui.min.css" rel="stylesheet" media="screen">
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=FVSykwVIFk6ykQB8V4D0RLGX"></script>
	<script type="text/javascript" src="/wc_shop/js/footer.js"></script>
	<script type="text/javascript" src="../js/addaddress.jquery.js"></script>
	<style type="text/css">
	#allmap {width: 100%;height: 400px;overflow: hidden;margin:0;font-family:"微软雅黑";}
	#addresslabel{width:70px;}
	#next{width:70%;margin-top:10px;margin-bottom:10px;}
	</style>
  </head>
  
  <body>
  	<div class="weui_cells weui_cells_form">
	    <div class="weui_cell">
	        <div class="weui_cell_hd">
	            <label class="weui_label" id="addresslabel">收货地址</label>
	        </div>
	        <div class="weui_cell_bd weui_cell_primary">
	            <input class="weui_input" type="text" placeholder="请输入地址" id="address">
	        </div>
	    </div>
	</div>
	<div class="button_sp_area">
	<a href="javascript:;" class="weui_btn weui_btn_plain_primary" id="finish">完成</a>
	</div>
    <div id="allmap"></div>
	<%@ include file="../footer.html" %>
  </body>
</html>
<script type="text/javascript">
	//百度地图API功能
	var map = new BMap.Map("allmap");
	map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);
	// 添加带有定位的导航控件
	var navigationControl = new BMap.NavigationControl({
	  // 靠左上角位置
	  anchor: BMAP_ANCHOR_TOP_LEFT,
	  // LARGE类型
	  type: BMAP_NAVIGATION_CONTROL_LARGE,
	  // 启用显示定位
	  enableGeolocation: true
	});
	map.addControl(navigationControl);
	// 添加定位控件
	var geolocationControl = new BMap.GeolocationControl();
	geolocationControl.addEventListener("locationSuccess", function(e){
	  // 定位成功事件
	  var address = '';
	  address += e.addressComponent.province;
	  address += e.addressComponent.city;
	  address += e.addressComponent.district;
	  address += e.addressComponent.street;
	  address += e.addressComponent.streetNumber;
	  //alert("当前定位地址为：" + address);
	  $("#address").val(address);
	});
	geolocationControl.addEventListener("locationError",function(e){
	  // 定位失败事件
	  alert(e.message);
	});
	map.addControl(geolocationControl);
</script>