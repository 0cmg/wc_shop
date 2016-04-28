$(function(){
	
	loadShopcart();
	bindDel();
	bindBuy();
	
});

function loadShopcart(){
	var value = $.cookie("shopcart");
	if(value == "" || value == null || value == undefined){
		var empty = "<p style='padding-left:10%;padding-top:10px;'>您的购物车暂时没有商品！</p>";
		$("#checkbox").html(empty);
		
		return;
	}
	var com_no_list = value.split(";");
	var com_list = [];
	for(var i=0;i<com_no_list.length-1;i++){
		var ian = com_no_list[i].split(":");
		var o = {
			comid : ian[0],
			number : ian[1]
		};
		com_list[i] = o;
	}
	$.ajax({
		url:"/wc_shop/front/data/getShopcart",
		contentType : 'application/json;charset=utf-8',
		type:"post",
		data : JSON.stringify(com_list),
		success:function(data){
			if(data.result){
				var com_list = data.t;
				var content = "";
				for(var i=0;i<com_list.length;i++){
					content += "<label class='weui_cell weui_checkbox_label check' id='"+i+"' for='"+(i+1)+"'>";
					content += "<div class='weui_cell_hd'>";
					content += "<input type='checkbox' class='weui_check' name='checkbox' id='"+(i+1)+"'>";
					content += "<i class='weui_icon_checked'></i>";
					content += "</div>";
					content += "<div class='weui_cell_bd weui_cell_primary'>";
					content += "<div id='cominfo'>";
					content += "<div id='img'>";
					
					var imgurls = com_list[i].civo.imageurl;
					var imgurl_list = imgurls.split(";");
					
					content += "<img id='ip' src='"+imgurl_list[0]+"'></img>";
					content += "</div>";
					content += "<div id='nad'>";
					content += "<div id='name'>"+com_list[i].civo.name+"</div>";
					content += "<div id='desc'>"+com_list[i].civo.descsimple+"</div>";
					content += "</div>";
					content += "<div id='pan'>";
					content += "<div id='price'>";
					content += "<span id='pc'>价格：<span>";
					content += "<span id='pn'>"+com_list[i].civo.price+"</span>";
					content += "</div>";
					content += "<div id='number'>";
					content += "<span id='nc'>数量：</span>";
					content += "<span id='nn'>"+com_list[i].number+"</span>";
					content += "</div>";
					content += "</div>";
					content += "</div>";
					content += "</div>";
					content += "</label>";
				}
				$("#checkbox").html(content);
			}
		}
	});
}

function bindDel(){
	$("#delete").on("click",function(){
		var cb_value = [];
		$("input[name='checkbox']:checked").each(function(){
			cb_value.push($(this).attr("id")-1)
		});
		if(cb_value.length == 0){
			alert("请选择商品");
			return;
		}
		//alert(cb_value);
		var cookie = $.cookie("shopcart")
		var sc_list = cookie.split(";");
		for(var i=0;i<cb_value.length;i++){
			sc_list.splice(cb_value[i]-i,1);
		}
		var newcookie = "";
		for(var i=0;i<sc_list.length-1;i++){
			newcookie += sc_list[i] + ";";
		}
		$.cookie("shopcart",newcookie,{expires : 30,path : '/'});
		loadShopcart();
	})
}

function bindBuy(){
	$("#buy").on("click",function(){
		var cb_value = [];
		var cb_index = "";
		$("input[name='checkbox']:checked").each(function(){
			cb_value.push($(this).attr("id")-1)
			cb_index += $(this).attr("id")-1;
			cb_index += ";";
		});
		if(cb_value.length == 0){
			alert("请选择商品");
			return;
		}
		var cookie = $.cookie("shopcart")
		var sc_list = cookie.split(";");
		var info = "";
		for(var i=0;i<cb_value.length;i++){
			info += sc_list[i] + ";";
		}
		/*
		for(var i=0;i<cb_value.length;i++){
			sc_list.splice(cb_value[i]-i,1);
		}
		var newcookie = "";
		for(var i=0;i<sc_list.length-1;i++){
			newcookie += sc_list[i] + ";";
		}
		$.cookie("shopcart",newcookie,{expires : 30,path : '/'});
		*/
		window.location.href = "orderconfirm?info=" + info + "&cb_index=" + cb_index;
	});
}


