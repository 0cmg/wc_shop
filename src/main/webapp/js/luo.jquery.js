$(window).load(function(){
	loadUntreatedOrder();
	loadOverviewData();
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

function loadOverviewData(){
	$.ajax({
		url:"/wc_shop/back/data/getOverviewData",
		contentType : 'application/json;charset=utf-8',
		type:"get",
		success:function(data){
			if(data.result){
				var od = data.t;
				var today_turnover = od.today_turnover;
				$("#today_turnover").text(today_turnover);
				var tt_c = od.tt_c;
				if(tt_c != "Infinity"){
					tt_c = Math.round(tt_c * 10000) / 100;
				}
				if(tt_c > 0 || tt_c == "Infinity"){
					$("#b_tt_c").removeClass().addClass("color-up");
					$("#i_tt_c").removeClass().addClass("fa fa-caret-up");
				}else{
					$("#b_tt_c").removeClass().addClass("color-down");
					$("#i_tt_c").removeClass().addClass("fa fa-caret-down");
				}
				if(tt_c == "Infinity"){
					$("#tt_c").text("∞");
				}else{
					$("#tt_c").text(tt_c);
				}
				
				var thisweek_turnover = od.thisweek_turnover;
				$("#thisweek_turnover").text(thisweek_turnover);
				var twt_c = od.twt_c;
				if(twt_c != "Infinity"){
					twt_c = Math.round(twt_c * 10000) / 100;
				}
				if(twt_c > 0 || twt_c == "Infinity"){
					$("#b_twt_c").removeClass().addClass("color-up");
					$("#i_twt_c").removeClass().addClass("fa fa-caret-up");
				}else{
					$("#b_twt_c").removeClass().addClass("color-down");
					$("#i_twt_c").removeClass().addClass("fa fa-caret-down");
				}
				if(twt_c == "Infinity"){
					$("#twt_c").text("∞");
				}else{
					$("#twt_c").text(twt_c);
				}
				
				var today_on = od.today_on;
				$("#today_on").text(today_on);
				var to_c = od.to_c;
				if(to_c != "Infinity"){
					to_c = Math.round(to_c * 10000) / 100;
				}
				if(to_c > 0 || to_c == "Infinity"){
					$("#b_to_c").removeClass().addClass("color-up");
					$("#i_to_c").removeClass().addClass("fa fa-caret-up");
				}else{
					$("#b_to_c").removeClass().addClass("color-down");
					$("#i_to_c").removeClass().addClass("fa fa-caret-down");
				}
				if(to_c == "Infinity"){
					$("#to_c").text("∞");
				}else{
					$("#to_c").text(to_c);
				}
				
				var thisweek_on = od.thisweek_on;
				$("#thisweek_on").text(thisweek_on);
				var two_c = od.two_c;
				if(two_c != "Infinity"){
					two_c = Math.round(two_c * 10000) / 100;
				}
				if(two_c > 0 || two_c == "Infinity"){
					$("#b_two_c").removeClass().addClass("color-up");
					$("#i_two_c").removeClass().addClass("fa fa-caret-up");
				}else{
					$("#b_two_c").removeClass().addClass("color-down");
					$("#i_two_c").removeClass().addClass("fa fa-caret-down");
				}
				if(two_c == "Infinity"){
					$("#two_c").text("∞");
				}else{
					$("#two_c").text(two_c);
				}
				
				var vn = od.vn;
				$("#vn").text(vn);
				var vn_c = od.vn_c;
				if(vn_c != "Infinity"){
					vn_c = Math.round(vn_c * 10000) / 100;
				}
				if(vn_c > 0 || vn_c == "Infinity"){
					$("#b_vn_c").removeClass().addClass("color-up");
					$("#i_vn_c").removeClass().addClass("fa fa-caret-up");
				}else{
					$("#b_vn_c").removeClass().addClass("color-down");
					$("#i_vn_c").removeClass().addClass("fa fa-caret-down");
				}
				if(vn_c == "Infinity"){
					$("#vn_c").text("∞");
				}else{
					$("#vn_c").text(vn_c);
				}
			}
		}
	});
}
