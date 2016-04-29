<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../css/modifyorder.css" rel="stylesheet">
</head>
<body>
	<script type="text/javascript" src="../js/finishorder.jquery.js"></script>
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h4 class="modal-title" id="myModalLabel" align="center">完成订单</h4>
		</div>
		<div class="modal-body">
			<div id="info" style="text-align:center;"></div>
			<div id="table_show" style="text-align:center;margin:5px auto;">
				
			</div>
		</div>
		<div class="modal-footer">
			<button id="refresh" type="button" class="btn btn-primary">加载</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

		</div>
	</div>
</body>
</html>