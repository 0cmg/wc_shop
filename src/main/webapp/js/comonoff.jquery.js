var flag = true;
$("#com_type").click(function(){
	if(flag){
		$.ajax({
			url:"/wc_shop/back/data/getAllTypes",
			contentType : 'application/json;charset=utf-8',
			type:"post",
			success:function(data){
				//console.log(data);
				var types = data.t;
				var content = "<option>全部</option>";
				for(var i=0;i<types.length;i++){
					content += "<option>"+types[i].type+"</option>";
				}
				$("#com_type").html(content);
				flag = false;
					
			}
		});
	}
});

$("#search").on("click",function(){
	queryByWhere();
});

function queryByWhere(){
	$(".com_show_area").html("");
	var selection = $("#com_type option:selected").text();
	//alert(selection);
	if(selection == "全部"){
		selection = null;
	}
	var st;
	var status = $("#com_status option:selected").val();
	if(status == "all")
		st = null;
	else if(status == "on")
		st = 1;
	else if(status == "off")
		st = 0;
	//alert(selection);
	var commodityinfopojo = {
		name : $("#search_name").val(),
		type : selection,
		isonline : st
	};
	$.ajax({
		url:"/wc_shop/back/data/queryComByWhere",
		data: JSON.stringify(commodityinfopojo),
		contentType : 'application/json;charset=utf-8',
		type:"post",
		success:function(data){
			var status = data.result;
			if(status){
				//alert("已进入");
				var com_list = data.t;
				var com_table = "<table border=\"1\">";
				com_table += "<tr><th>商品名称</th><th>商品类型</th>";
				com_table += "<th>商品价格</th><th>已售数量</th>";
				com_table += "<th>商品库存</th><th>商品状态</th>";
				com_table += "<th>操作</th></tr>";
				for(var i=0;i<com_list.length;i++){
					com_table += "<tr><td>"+com_list[i].name+"</td>";
					com_table += "<td>"+com_list[i].type+"</td>";
					com_table += "<td>"+com_list[i].price+"</td>";
					com_table += "<td>"+com_list[i].sellno+"</td>";
					com_table += "<td>"+com_list[i].restno+"</td>";
					if(com_list[i].isonline == 1){
						com_table += "<td style=\"color:green;\">已上架</td>";
						com_table += "<td><a href=\"javascript:option('offline',"+com_list[i].commodityid+");\" id=\""+com_list[i].commodityid+"\">下架</a></td></tr>";
					}else{
						com_table += "<td style=\"color:red;\">已下架</td>";
						com_table += "<td><a href=\"javascript:option('online',"+com_list[i].commodityid+");\" id=\""+com_list[i].commodityid+"\">上架</a></td></tr>";
					}
					//com_table += "<td>"+com_list[i].isonline+"</td>";
					//com_table += "<td><a op=\"online\">上架</a><a op=\"o=ffline\">下架</a></td></tr>";
				}
				com_table += "</table>"
				$(".com_onoff_table").html(com_table);
			}else{
				$(".com_onoff_table").html("");
			}
		}
	});
}

function option(op,comid){
	//alert(op+" "+comid);
	var option = {
		o : op,
		id : comid
	};
	$.ajax({
		url:"/wc_shop/back/data/ComOnOff",
		data: JSON.stringify(option),
		contentType : 'application/json;charset=utf-8',
		type:"post",
		success:function(data){
			if(data.result){
				queryByWhere();
			}else{
				return;
			}
		}
	});
}