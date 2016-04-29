var oivo_list = [] ;

$("#refresh").on("click",function(){
	refresh();	
})

function refresh(){
	$("#table_show").html("");
	$("#info").html("");
	$.ajax({
		url:"/wc_shop/back/data/queryUntreatedOrder",
		contentType : 'application/json;charset=utf-8',
		type:"get",
		success:function(data){
			oivo_list = data.t;
			if(oivo_list == undefined || oivo_list == "" || oivo_list == null){
				$("#info").html("<p>暂无数据！</p>");
				return;
			}
			var content = "";
			content += "<table border='1' align='center'>";
			content += "<tr style='text-align:center'><th style='width:260px;'>订单号</th><th>收货人</th>";
			content += "<th>交易额</th><th>快递类型</th><th>快递单号</th><th>操作</th></tr>";
			for(var i=0;i<oivo_list.length;i++){
				content += "<tr><td>"+oivo_list[i].orderno+"</td>";
				content += "<td>"+oivo_list[i].customername+"</td>";
				content += "<td>"+oivo_list[i].value+"</td>";
				content += "<td><input type='text' id='t"+i+"'></td>";
				content += "<td><input type='text' id='n"+i+"'></td>";
				content += "<td><a href='javascript:op_finish("+i+");'>完成订单</a></td>";
			}
			content += "</table>";
			$("#table_show").html(content);
		}
	});
}

function op_finish(i){

	var orderno = oivo_list[i].orderno;
	var ex_type = $("#t"+i).val();
	var ex_no = $("#n"+i).val();
	
	if(isnull(ex_type)){
		alert("请输入快递类型");
		return;
	}
	if(isnull(ex_no)){
		alert("请输入快递单号");
		return;
	}
	
	var o = {
		orderno:orderno,
		expresstype:ex_type,
		expressno:ex_no
	};
	
	$.ajax({
		url:"/wc_shop/back/data/finishOrder",
		data: JSON.stringify(o),
		contentType : 'application/json;charset=utf-8',
		type:"post",
		success:function(data){
			if(date.result)
				refresh();
			else{
				alert("操作失败！");
			}
		}
	});
	
}

function isnull(o){
	if(o == "" || o == null || o == undefined)
		return true;
	return false;
}
