<!-- 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

</head>
<body>
	


	<div class="modal-content">
	 -->
<div class="modal-header">
	<h4 class="modal-title" id="myModalLabel" align="center">编辑商品</h4>
</div>
<div class="modal-body">


	<script type="text/javascript" src="../uploadify/jquery.uploadify.js"></script>
	<script type="text/javascript" src="../js/editcom.jquery.js"></script>
	<div id="hide" style="display:none;">${id}</div>
	<div class="inner_boder">
		<div class="first_line">
			<span>商品名称：</span><input type="text" size="16" id="comname" /> <span>商品单价：</span><input
				type="text" size="16" id="comprice" /> <span>商品类型:</span> <select
				id="types">
			</select>
		</div>
		<br />
		<div class="second_line">
			<span>商品简要描述：</span><input type="text" size="70" id="simpledesc" />
		</div>
		<br />
		<div class="third_line">
			<div id="activate">
				<span>上传商品封面照:</span>
				<button type="button" class="btn btn-default" id="reupload">重新上传</button>
				<hr />
			</div>
			<div id="upload"></div>
			<br />
			<div id="imgshow"></div>
			<hr />
			<div class="richtexteditor">
				<span>商品详细描述：</span>
				<hr />
				<div name="editor1" id="editor2" style="display:none;"></div>
			</div>
		</div>
	</div>
</div>

<div class="modal-footer">
	<button id="com_load" type="button" class="btn btn-primary">加载</button>
	<button id="save" type="button" class="btn btn-primary">提交</button>
</div>
<!--
	</div>
</body>
</html>
-->