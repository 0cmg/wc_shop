<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="微信商城后台管理">
<meta name="keywords" content="bootstrap, admin, wc_shop" />
<title>微信商城后台管理系统</title>
<link href="../css/root.css" rel="stylesheet">
<script src="http://libs.baidu.com/jquery/1.8.2/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>


</head>

<body>

	<!-- Start Page Loading -->
	<div class="loading">
		<img src="../img/loading.gif" alt="loading-img">
	</div>
	<!-- End Page Loading -->
	<!-- START TOP -->
	<div id="top" class="clearfix">

		<!-- Start App Logo -->
		<div class="applogo">
			<a href="back/manage" class="logo">微信商城管理</a>
		</div>
		<!-- End App Logo -->

		<!-- Start Sidebar Show Hide Button -->
		<a href="#" class="sidebar-open-button"><i class="fa fa-bars"></i></a>
		<a href="#" class="sidebar-open-button-mobile"><i
			class="fa fa-bars"></i></a>
		<!-- End Sidebar Show Hide Button -->

		<!-- Start Searchbox -->
		<form class="searchform">
			<input type="text" class="searchbox" id="searchbox"
				placeholder="Search"> <span class="searchbutton"><i
				class="fa fa-search"></i></span>
		</form>
		<!-- End Searchbox -->

		<!-- Start Top Menu -->
		<ul class="topmenu">
			<li><a href="..//">&nbsp;&nbsp;商城主页&nbsp;&nbsp;</a></li>
		</ul>
		<!-- End Top Menu -->



		<!-- Start Top Right -->
		<ul class="top-right">

			<li class="dropdown link"><a href="#" data-toggle="dropdown"
				class="dropdown-toggle hdbutton">操作 <span class="caret"></span></a>
				<ul class="dropdown-menu dropdown-menu-list">
					<li><a data="createcom" href="CreateNewCom"
						data-toggle="modal" data-target="#modal"><i class="fa falist fa-paper-plane-o"></i>新增商品</a></li>
					<li><a id="createtype" data="createtype" href="CreateNewType"
						data-toggle="modal" data-target="#modal"><i class="fa falist fa-font"></i>新增类型</a></li>
					<li><a data="finishorder" href="finishorder"
						data-toggle="modal" data-target="#modal"><i class="fa falist fa-file-image-o"></i>完成订单</a></li>
				</ul></li>


			<li class="dropdown link"><a href="#" data-toggle="dropdown"
				class="dropdown-toggle profilebox"><img src="../img/star.jpg"
					alt="img"><b>Administrator</b><span class="caret"></span></a>
				<ul class="dropdown-menu dropdown-menu-list dropdown-menu-right">
					<li><a href="#"><i class="fa falist fa-power-off"></i>
							Logout</a></li>
				</ul></li>

		</ul>
		<!-- End Top Right -->

	</div>
	<!-- END TOP -->


	<!-- START SIDEBAR -->
	<div class="sidebar clearfix">

		<ul class="sidebar-panel nav">
			<li><a><span class="icon color5"><i
						class="fa fa-home"></i></span>总览</a></li>
			<li><a><span class="icon color7"><i
						class="fa fa-flask"></i></span>商品操作<span class="caret"></span></a>
				<ul>
					<li><a data="comoverview" href="ComOverview"
						data-toggle="modal" data-target="#modal">商品总览</a></li>
					<li><a id="createtype" data="createtype" href="CreateNewType"
						data-toggle="modal" data-target="#modal">新增类型</a></li>
					<li><a data="createcom" href="CreateNewCom"
						data-toggle="modal" data-target="#modal">新增商品</a></li>
					<li><a data="comonoff" href="ComOnAndOff" data-toggle="modal"
						data-target="#modal">上下架商品</a></li>
					<li><a data="comim" href="ComInventoryManage"
						data-toggle="modal" data-target="#modal">货源管理</a></li>
				</ul></li>
			<li><a><span class="icon color9"><i class="fa fa-th"></i></span>订单操作<span
					class="caret"></span></a>
				<ul>
					<li><a data="finishorder" href="finishorder"
						data-toggle="modal" data-target="#modal">完成订单</a></li>
					<li><a data="modifyorder" href="modifyorder"
						data-toggle="modal" data-target="#modal">修改订单</a></li>
					<li><a data="deleteorder" href="deleteorder"
						data-toggle="modal" data-target="#modal">取消订单</a></li>
				</ul></li>


		</ul>




	</div>

	<!-- END SIDEBAR -->



	<!-- START CONTENT -->
	<div class="content">

		<!-- Start Page Header -->
		<div class="page-header">
			<h1 class="title">后台信息总览</h1>
			<ol class="breadcrumb">
				<li class="active">在这里您可以看到后台信息的总体情况</li>
			</ol>
			<!-- Start Page Header Right Div -->
			<!--  
    <div class="right">
      <div class="btn-group" role="group" aria-label="...">
        <a href="index.html" class="btn btn-light">Dashboard</a>
        <a href="#" class="btn btn-light"><i class="fa fa-refresh"></i></a>
        <a href="#" class="btn btn-light"><i class="fa fa-search"></i></a>
        <a href="#" class="btn btn-light" id="topstats"><i class="fa fa-line-chart"></i></a>
      </div>
    </div>-->
			<!-- End Page Header Right Div -->

		</div>
		<!-- End Page Header -->


		<!-- START CONTAINER -->
		<div class="container-widget">

			<!-- Start Top Stats -->
			<div class="col-md-12">
				<ul class="topstats clearfix">
					<li class="arrow"></li>
					<li class="col-xs-6 col-lg-2"><span class="title"><i
							class="fa fa-dot-circle-o"></i> 今日营业额</span>
						<h3>---</h3> <span class="diff"><b class="color-down"><i
								class="fa fa-caret-down"></i> --%</b> 相比昨天</span></li>
					<li class="col-xs-6 col-lg-2"><span class="title"><i
							class="fa fa-dot-circle-o"></i> 本周营业额</span>
						<h3>---</h3> <span class="diff"><b class="color-up"><i
								class="fa fa-caret-up"></i> --%</b> 相比上周</span></li>
					<li class="col-xs-6 col-lg-2"><span class="title"><i
							class="fa fa-shopping-cart"></i> 今日订单数</span>
						<h3 class="color-up">---</h3> <span class="diff"><b
							class="color-up"><i class="fa fa-caret-up"></i> --%</b> 相比昨天</span></li>
					<li class="col-xs-6 col-lg-2"><span class="title"><i
							class="fa fa-shopping-cart"></i> 本周订单数</span>
						<h3>---</h3> <span class="diff"><b class="color-down"><i
								class="fa fa-caret-down"></i> --%</b> 相比上周</span></li>
					<li class="col-xs-6 col-lg-2"><span class="title"><i
							class="fa fa-eye"></i> 今日访问量</span>
						<h3 class="color-up">---</h3> <span class="diff"><b
							class="color-down"><i class="fa fa-caret-down"></i> --%</b> 相比昨天</span>
					</li>
					<li class="col-xs-6 col-lg-2"><br /> <a href="#"
						class="btn btn-light"><i class="fa fa-refresh"></i></a></li>
				</ul>

			</div>
			<!-- End Top Stats -->


			<!-- Start First Row -->
			<div class="row">

				<!-- Start Chart Daily -->
				<div class="col-md-12 col-lg-7">
					<div class=" panel-widget widget chart-with-stats clearfix"
						style="height:450px;">

						<div class="col-sm-12" style="height:450px;">
							<h4 class="title">历史记录</h4>
							<!--   <div class="top-label"><h2></h2><h4></h4></div>-->
							<div class="bigchart" id="history" style="width:460px;"></div>
						</div>
						<div class="right" style="height:450px;">
							<h4 class="title">标注</h4>
							<!-- start stats -->
							<ul class="widget-inline-list clearfix">
								<li class="col-12"><span>---</span>访问量<i
									class="chart sparkline-green"></i></li>
								<li class="col-12"><span>---</span>订单数<i
									class="chart sparkline-blue"></i></li>
								<li class="col-12"><span>---</span>销售额<i
									class="chart sparkline-red"></i></li>
							</ul>
							<!-- end stats -->
						</div>


					</div>
				</div>
				<!-- End Chart Daily -->


				<!-- Start Files -->
				<div class="col-md-12 col-lg-5">
					<div class="panel panel-widget" style="height:450px;">
						<div class="panel-title">
							未处理订单 <span class="label label-danger">--</span>
							<ul class="panel-tools">
								<li><a class="icon"><i class="fa fa-refresh"></i></a></li>
								<li><a class="icon closed-tool"><i class="fa fa-times"></i></a></li>
							</ul>
						</div>
						<div class="panel-body table-responsive">

							<table class="table table-dic table-hover ">
								<tbody>
									<tr>
										<td><i class="fa fa-shopping-cart"></i>---</td>
										<td>---</td>
										<td class="text-r">--/--/---- --:--</td>
									</tr>
									<!--  
              <tr>
                <td><i class="fa fa-file-archive-o"></i>Backup</td>
                <td>Zip</td>
                <td class="text-r">27/2/2015 12:34 AM</td>
              </tr>
              <tr>
                <td><i class="fa fa-file-code-o"></i>Kode Theme</td>
                <td>Html</td>
                <td class="text-r">27/2/2015 12:34 AM</td>
              </tr>
              <tr>
                <td><i class="fa fa-file-pdf-o"></i>Documents</td>
                <td>Pdf</td>
                <td class="text-r">27/2/2015 12:34 AM</td>
              </tr>
              <tr>
                <td><i class="fa fa-folder-o"></i>Themes</td>
                <td>Folder</td>
                <td class="text-r">27/2/2015 12:34 AM</td>
              </tr>
              <tr>
                <td><i class="fa fa-folder-o"></i>Uploaded Files</td>
                <td>Folder</td>
                <td class="text-r">27/2/2015 12:34 AM</td>
              </tr>
              <tr>
                <td><i class="fa fa-folder-o"></i>Personal Files</td>
                <td>Folder</td>
                <td class="text-r">27/2/2015 12:34 AM</td>
              </tr>
              -->
								</tbody>
							</table>

						</div>
					</div>
				</div>
				<!-- End Files -->

			</div>
			<!-- End First Row -->


		</div>
		<!-- END CONTAINER -->

		<!-- Start Footer -->
		<div class="row footer">
			<div class="col-md-6 text-left">Copyright &copy; 2015 LichKing
				All rights reserved.Page refered to 17素材网</div>
			<div class="col-md-6 text-right">Design and Developed by
				landry001@vip.qq.com</div>
		</div>
		<!-- End Footer -->


	</div>
	<!-- End Content -->

	<div class="modal fade" id="modal" tabindex="-1" role="dialog"
		aria-labelledby="modal" aria-hidden="true"
		style="width:70%;margin:auto auto auto auto;padding-top:10px;">
		<div class="modal-content"></div>
	</div>


	<script type="text/javascript" src="../js/plugins.js"></script>



	<script type="text/javascript"
		src="../js/bootstrap-select/bootstrap-select.js"></script>
	<script type="text/javascript"
		src="../js/bootstrap-toggle/bootstrap-toggle.min.js"></script>
	<!-- 画图所需JS -->
	<script type="text/javascript" src="../js/flot-chart/flot-chart.js"></script>
	<script type="text/javascript"
		src="../js/flot-chart/flot-chart-time.js"></script>
	<script type="text/javascript"
		src="../js/flot-chart/flot-chart-stack.js"></script>
	<script type="text/javascript" src="../js/flot-chart/flot-chart-pie.js"></script>
	<script type="text/javascript"
		src="../js/flot-chart/flot-chart-plugin.js"></script>
	<script type="text/javascript" src="../js/easypiechart/easypiechart.js"></script>
	<script type="text/javascript"
		src="../js/easypiechart/easypiechart-plugin.js"></script>
	<script type="text/javascript" src="../js/sparkline/sparkline.js"></script>
	<script type="text/javascript"
		src="../js/sparkline/sparkline-plugin.js"></script>
	<script src="../js/rickshaw/d3.v3.js"></script>
	<script src="../js/rickshaw/rickshaw.js"></script>
	<script src="../js/rickshaw/rickshaw-plugin.js"></script>
	<script type="text/javascript" src="../js/moment/moment.min.js"></script>

	<script type="text/javascript" src="../js/chart_generate.js"></script>

	<script type="text/javascript" src="../js/manage.jquery.js"></script>
	<script src="../ckeditor/ckeditor.js"></script>
	<script src="../js/luo.jquery.js"></script>

</body>
</html>