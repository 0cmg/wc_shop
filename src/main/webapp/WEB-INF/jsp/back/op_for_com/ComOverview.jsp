<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../css/comoverview.css" rel="stylesheet">
<link href="../css/createnewcom.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../uploadify/uploadify.css" />
</head>
<body>
	<script type="text/javascript" src="../js/comoverview.jquery.js"></script>
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h4 class="modal-title" id="myModalLabel" align="center">商品总览</h4>
		</div>
		<div class="modal-body">
			<div class="inner_border">
				<!-- 搜索框 -->
				<div class="search_area">
					<span>商品名称：</span><input type="text" name="search_name"
						id="search_name" /> <span>商品类型：</span><select style="width:80px;"
						id="com_type"></select> <span>商品描述：</span><input type="text"
						name="search_desc" id="search_desc" />
					<button class="btn" id="search">搜索</button>
				</div>
				<hr />
				<!-- 单个商品框架 -->

				<div class="com_show_area">
					<!-- 
					<div class="com_border">
						<div class="image_border">照片</div>
						<div class="msg_ps_border">
							<div class="msg_border">
								<div class="desc_border">desc</div>
								<div class="op_border">op</div>
							</div>
							<div class="ps_border">
								<div class="price_border">price</div>
								<div class="sell_border">sell</div>
							</div>
						</div>
					</div>
					-->
				</div>


				<div class="com_edit_area"></div>
			</div>
		</div>
		<div class="modal-footer">
			<!--  
			<button type="button" class="btn btn-primary" id="load">加载</button>
		-->
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭
			</button>
		</div>
	</div>
</body>
</html>