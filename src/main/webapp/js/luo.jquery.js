$(window).load(function(){
	loadUntreatedOrder();
	
	$(".fa-refresh").on("click",function(){
		loadUntreatedOrder();
	});
});


function loadUntreatedOrder(){
	$("#uton").text("--");
	$("#order_content").html("");
	$.ajax({
		url:"/wc_shop/back/data/queryUntreatedOrder",
		contentType : 'application/json;charset=utf-8',
		type:"get",
		success:function(data){
			var oivo_list = data.t;
			if(oivo_list == undefined || oivo_list == "" || oivo_list == null){
				return;
			}
			$("#uton").text(oivo_list.length);
			var content = "";
			for(var i=0;i<oivo_list.length;i++){
				content += "<tr><td style='color:red;'><i class='fa fa-shopping-cart'></i>"+oivo_list[i].value+"￥</td>";
				content += "<td>"+oivo_list[i].customername+"</td>";
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
				content += "<td class='text-r'>"+day+"/"+month+"/"+year+"  "+hour+":"+min+":"+sec+"</td></tr>";
			}
			$("#order_content").html(content);
		}
	});
	
}
