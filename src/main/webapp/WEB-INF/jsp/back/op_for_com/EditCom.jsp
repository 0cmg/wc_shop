
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>商品编辑</title>
<script src="http://libs.baidu.com/jquery/1.8.2/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../uploadify/uploadify.css" />
<script type="text/javascript" src="http://libs.baidu.com/jqueryui/1.8.22/jquery-ui.min.js"></script>
<link href="http://libs.baidu.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript"
		src="../uploadify/backup/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="../js/editcom.jquery.js"></script>
</head>
<body>
	


	
	 
<div class="header">
	<h4 class="modal-title" id="myModalLabel" align="center">编辑商品</h4>
</div>
<div class="body">


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
				<textarea name="editor" id="editor" ></textarea>
				<script type="text/javascript">
					CKEDITOR.replace('editor');
				</script>
			</div>
		</div>
	</div>
</div>

<div class="footer">
	<button id="save" type="button" class="btn btn-primary">提交</button>
</div>

	
</body>
</html>
