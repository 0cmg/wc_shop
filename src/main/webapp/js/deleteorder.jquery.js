var oivo_list = [] ;

$("#refresh").on("click",function(){
	refresh();	
})

function refresh(){
	$("#table_show").html("");
	$("#info").html("");
	$.ajax({
		url:"/wc_shop/back/data/queryUnpaidOrder",
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
			content += "<tr style='text-align:center'><th style='width:260px;'>订单号</th><th style='width:120px;'>成交时间</th><th>收货人</th>";
			content += "<th>交易额</th><th>状态</th><th>操作</th></tr>";
			for(var i=0;i<oivo_list.length;i++){
				content += "<tr><td>"+oivo_list[i].orderno+"</td>";
				var dealtime = oivo_list[i].dealtime;
				var date = new Date(dealtime);
				var day = date.getDate();
				var month = date.getMonth()+1;
				var year = date.getFullYear();
				var hour = date.getHours();
				if(hour < 10)
					hour = "0"+hour;
				var min = date.getMinutes();
				if(min < 10)
					min = "0"+min;
				var sec = date.getSeconds();
				if(sec < 10)
					sec = "0"+sec;
				var time = year + "-" + month + "-" + day + "  " + hour + ":" + min + ":" + sec;
				content += "<td>"+time+"</td>";
				content += "<td>"+oivo_list[i].customername+"</td>";
				content += "<td>"+oivo_list[i].value+"</td>";
				content += "<td>未付款</td>";
				content += "<td><a href='javascript:op_pay("+i+");'>取消订单</a></td>";
			}
			content += "</table>";
			$("#table_show").html(content);
		}
	});
}

function op_pay(i){

	var orderno = oivo_list[i].orderno;
	
	$.ajax({
		url:"/wc_shop/back/data/deleteOrder?on="+orderno,
		contentType : 'application/json;charset=utf-8',
		type:"get",
		success:function(data){
			if(date.result)
				refresh();
			else{
				alert("操作失败！");
			}
		}
	});
	
}
