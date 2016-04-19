<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>个人信息管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<link href="../css/footer.css" rel="stylesheet">
<script type="text/javascript"
	src="http://libs.baidu.com/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript"
	src="http://libs.baidu.com/jqueryui/1.8.22/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="http://libs.baidu.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link href="http://libs.baidu.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link href="../css/weui.min.css" rel="stylesheet" media="screen">
<link href="../css/customerinfo.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="../js/customerinfo.jquery.js"></script>

</head>

<body>
	<div class="weui_tab">
		<div class="weui_navbar">
			<div class="weui_navbar_item weui_bar_item_on"><a href="main">商城首页</a></div>
			<div class="weui_navbar_item">快递查询</div>
			<div class="weui_navbar_item">我的订单</div>
		</div>
		<div class="weui_tab_bd">
			<div class="weui_cells_title">联系方式</div>
			<div class="weui_cells weui_cells_radio" id="phone_list">
			   <!--  <label class="weui_cell weui_check_label" for="p0">
			      <div class="weui_cell_bd weui_cell_primary">
			        <p>手机号码1</p>
			      </div>
			      <div class="weui_cell_ft">
			        <input type="radio" value="p0" class="weui_check" name="phone" id="p0"  checked="checked">
			        <span class="weui_icon_checked"></span>
			      </div>
			    </label>
			    <label class="weui_cell weui_check_label" for="p1">
			      <div class="weui_cell_bd weui_cell_primary">
			        <p>手机号码2</p>
			      </div>
			      <div class="weui_cell_ft">
			        <input type="radio" value="p1" name="phone" class="weui_check" id="p1">
			        <span class="weui_icon_checked"></span>
			      </div>
			    </label>-->
			</div>
			
		    <div class="weui_dialog_confirm" style="display:none;" id="phone_dialog">
			    <div class="weui_mask"></div>
			    <div class="weui_dialog">
			        <div class="weui_dialog_hd">
			          <strong class="weui_dialog_title" id="phone_dialog_title">弹窗标题</strong>
			        </div>
			        <div class="weui_dialog_bd">
			        	<div class="weui_cell">
					        <div class="weui_cell_hd">
					            <label class="weui_label">号码</label>
					        </div>
					        <div class="weui_cell_bd weui_cell_primary">
					            <input class="weui_input" id="phonenumber" type="tel" placeholder="请输入你的手机号码">
					        </div>
					    </div>
					    <div id="hiddeninfo" style="display:none;">
					    	<div id="status"></div>
					    	<div id="index"></div>
					    </div>
			        </div>
			        <div class="weui_dialog_ft">
			            <a href="javascript:;" class="weui_btn_dialog default" id="phone_dialog_cancel">取消</a>
			            <a href="javascript:;" class="weui_btn_dialog primary" id="phone_dialog_submit">确定</a>
			        </div>
			    </div>
			</div>
			<div id="option_panel">
				<a href="javascript:;" id="addphone" class="weui_btn weui_btn_primary" style="width:24%;margin-top:5px;margin-bottom:5px;">新增</a>
				<a href="javascript:;" id="editphone" class="weui_btn weui_btn_primary" style="width:24%;margin-top:5px;margin-bottom:5px;">编辑</a>
				<a href="javascript:;" id="delphone" class="weui_btn weui_btn_warn" style="width:24%;margin-top:5px;margin-bottom:5px;">删除</a> 
			</div>
			<div class="weui_cells_title">收货地址</div>
			<div class="weui_cells weui_cells_radio" id="address_list">
			<!--  
			    <label class="weui_cell weui_check_label" for="a0">
			      <div class="weui_cell_bd weui_cell_primary">
			        <p>收货地址1</p>
			      </div>
			      <div class="weui_cell_ft">
			        <input type="radio" value="a0" class="weui_check" name="address" id="a0"  checked="checked">
			        <span class="weui_icon_checked"></span>
			      </div>
			    </label>
			   -->
			</div>
			<div class="weui_dialog_confirm" style="display:none;" id="address_dialog">
			    <div class="weui_mask"></div>
			    <div class="weui_dialog">
			        <div class="weui_dialog_hd">
			          <strong class="weui_dialog_title" id="address_dialog_title">修改收货地址</strong>
			        </div>
			        <div class="weui_dialog_bd">
			        	<div class="weui_cell">
					        <div class="weui_cell_hd">
					            <label class="weui_label">地址</label>
					        </div>
					        <div class="weui_cell_bd weui_cell_primary">
					            <input class="weui_input" id="address_content" type="text" placeholder="请输入你的收货地址">
					        </div>
					    </div>
					    <div id="hiddeninfo" style="display:none;">
					    	<div id="index_address"></div>
					    </div>
			        </div>
			        <div class="weui_dialog_ft">
			            <a href="javascript:;" class="weui_btn_dialog default" id="address_dialog_cancel">取消</a>
			            <a href="javascript:;" class="weui_btn_dialog primary" id="address_dialog_submit">确定</a>
			        </div>
			    </div>
			</div>
			<div id="option_panel">
			<a href="addaddress" id="addaddress" class="weui_btn weui_btn_primary" style="width:24%;margin-top:5px;margin-bottom:5px;">新增</a>
			<a href="javascript:;" id="editaddress" class="weui_btn weui_btn_primary" style="width:24%;margin-top:5px;margin-bottom:5px;">编辑</a>
			<a href="javascript:;" id="deladdress" class="weui_btn weui_btn_warn" style="width:24%;margin-top:5px;margin-bottom:5px;">删除</a>
			</div>
			<!--  
			<%@ include file="../footer.html"%>
			<script type="text/javascript" src="/wc_shop/js/footer.js"></script>-->
		</div>
	</div>
	
	
</body>
</html>
