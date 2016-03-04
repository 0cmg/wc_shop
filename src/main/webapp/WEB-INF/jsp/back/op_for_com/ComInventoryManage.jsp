<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../css/comonoff.css" rel="stylesheet">
</head>
<body>
	<script type="text/javascript" src="../js/cominventorymanage.jquery.js"></script>
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h4 class="modal-title" id="myModalLabel" align="center">商品库存管理</h4>
		</div>
		<div class="modal-body">
			<div class="inner_border">
				<!-- 搜索框 -->
				<div class="search_area">
					<span>商品名称：</span><input type="text" name="search_name"
						id="search_name" /> <span>商品类型：</span><select style="width:80px;"
						id="com_type"></select> 
					<span>商品状态：</span>
					<select style="width:80px;margin-right:40px;" id="com_status">
						<option value="all">全部</option>
						<option value="on">已上架</option>
						<option value="off">已下架</option>
					</select>
					<button class="btn" id="search">搜索</button>
				</div>
				<hr />
				<div class="com_im_table" align="center">
				</div>
			</div>
 				

				<div class="com_edit_area"></div>
			</div>
			<div class="modal-footer">
			<button type="button" class="btn btn-primary" id="addI">添加库存</button>
			<button type="button" class="btn btn-primary" id="setI">设置库存</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭
			</button>
		</div>
	</div>
		
</body>
</html>