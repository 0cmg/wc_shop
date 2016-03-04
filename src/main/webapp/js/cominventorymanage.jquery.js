var idarr = [];
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
	idarr = [];
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
				com_table += "<th>商品库存</th><th>输入库存</th></tr>";
				for(var i=0;i<com_list.length;i++){
					com_table += "<tr><td>"+com_list[i].name+"</td>";
					com_table += "<td>"+com_list[i].type+"</td>";
					com_table += "<td>"+com_list[i].price+"</td>";
					com_table += "<td>"+com_list[i].sellno+"</td>";
					com_table += "<td>"+com_list[i].restno+"</td>";
					com_table += "<td><input style=\"width:80px;\" maxlength=\"16\" type=\"number\" id=\""+ com_list[i].commodityid +"\" /></td>";
					idarr.push(com_list[i].commodityid);
				}
				com_table += "</table>"
				$(".com_im_table").html(com_table);
			}else{
				$(".com_im_table").html("");
			}
		}
	});
}

$("#addI").on("click",function(){
	var o = initObj("addI");
	comIM_Ajax(o);
});

$("#setI").on("click",function(){
	var o = initObj("setI");
	comIM_Ajax(o);
});

function initObj(option){
	var arr = [];
	for(var i=0;i<idarr.length;i++){
		var num = $("#"+idarr[i]).val();
		if(num.length>0){
			var ob = {
				commodityid : idarr[i],
				number : num
			};
			arr.push(ob);
		}
		
	}
	var o = {
		op : option,
		list : arr
	};
	return o;
}

function comIM_Ajax(o){
	$.ajax({
		url:"/wc_shop/back/data/ComIM",
		data: JSON.stringify(o),
		contentType : 'application/json;charset=utf-8',
		type:"post",
		success:function(data){
			result = data.result;
			if(result){
				queryByWhere();
			}
		}
	});
}
