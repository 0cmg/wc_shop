var scan_list = [];
var phone_list_p = [];
var address_list_p = [];
var total_price = 0;
$(function(){

	loadComlist();	
	getCustomerinfo();
	bindSubmit();
	
});

function loadComlist(){
	var value = $("#hidden_param").text();
	if(value == "" || value == null || value == undefined){
		var empty = "<p style='padding-left:10%;padding-top:10px;'>订单出错！</p>";
		$("#com_list").html(empty);
		
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
			var com_list = data.t;
			var content = "";
			var com = {
				com_name:"",
				com_id:0,
				com_num:0
			};
			for(var i=0;i<com_list.length;i++){
				content += "<div class='weui_cell'>";
				content += "<div clas='weui_cell_hd'>";
				var imgurls = com_list[i].civo.imageurl;
				var imgurl_list = imgurls.split(";");
				content += "<img src='"+imgurl_list[0]+"' alt='' class='cover'>";
				content += "</div>";
				content += "<div class='weui_cell_bd weui_cell_primary'>";
				content += "<h3 class='title'>"+com_list[i].civo.name+"</h3>";
				com.com_name = com_list[i].civo.name;
				com.com_id = com_list[i].civo.commodityid;
				content += "<p class='summary'>"+com_list[i].civo.descsimple+"</p>";
				content += "</div>";
				content += "<div class='pan'>";
				content += "<div id='price'>价格：<span class='red'>"+com_list[i].civo.price+"￥</span></div>";
				content += "<div id='number'>数量："+com_list[i].number+"</div>";
				com.com_num = com_list[i].number;
				scan_list[i] = com;
				content += "</div>";
				content += "<div class='weui_cell_ft'>";
				content += "</div></div>";
				total_price += com_list[i].civo.price*com_list[i].number;
			}
			$("#com_list").html(content);
			$("#total_price").text(total_price+"￥");
		}
	});
}


function getCustomerinfo(){
	$.ajax({
		url : "/wc_shop/front/data/getCustomerInfo",
		contentType : 'application/json;charset=utf-8',
		type : "get",
		success : function(data){
			var result = data.result;
			if(!result){
				var msg = data.msg;
				if(msg == "0"){
					$("#phone_list").html("<p id='nodata'>暂无数据！</p>");
					$("#address_list").html("<p id='nodata'>暂无数据！</p>");
				}else if(msg == "1"){
					alert("查询出错！");
				}else{
					$("#phone_list").html("<p id='nodata'>"+msg+"</p>");
					$("#address_list").html("<p id='nodata'>"+msg+"</p>");
				}
			}else{
				var object = data.t;
				var phone_list = object.phoneno;
				var address_list = object.address;
				if(phone_list == ""){
					$("#phone_list").html("<p id='nodata'>暂无数据！</p>");
				}else{
					phone_list = JSON.parse(phone_list);
					var list = phone_list.phone_list;
					phone_list_p = list;
					var content = "";
					for(var i = 0;i<list.length;i++){
						/*
						 * <label class="weui_cell weui_check_label" for="p0">
			      			<div class="weui_cell_bd weui_cell_primary">
			        			<p>手机号码1</p>
			      			</div>
			      			<div class="weui_cell_ft">
			        			<input type="radio" value="p0" class="weui_check" name="phone" id="p0"  checked="checked">
			       			 	<span class="weui_icon_checked"></span>
			      			</div>
			   		 	   </label>
						 */	
						var div = "<label class=\"weui_cell weui_check_labe\" for=\"p"+i+"\">";
						div += "<div class=\"weui_cell_bd weui_cell_primary\">";
						div += "<p>"+list[i].substring(1,list[i].length-1)+"</p>";
						div += "</div>";
						div += "<div class=\"weui_cell_ft\">";
						div += "<input type=\"radio\" value=\"p"+i+"\" class=\"weui_check\" name=\"phone\" id=\"p"+i+"\" >";
						div += "<span class=\"weui_icon_checked\"></span>";
						div += "</div>";
						div += "</label>";
						content += div;
					}
					$("#phone_list").html(content);
				}
				if(address_list == ""){
					$("#address_list").html("<p id='nodata'>暂无数据！</p>");
				}else{
					address_list = JSON.parse(address_list);
					var list = address_list.address_list;
					address_list_p = list;
					var content = "";
					for(var i = 0;i<list.length;i++){
						/*<label class="weui_cell weui_check_label" for="a0">
			      			<div class="weui_cell_bd weui_cell_primary">
			        			<p>收货地址1</p>
			      			</div>
			      			<div class="weui_cell_ft">
			       				<input type="radio" value="a0" class="weui_check" name="address" id="a0"  checked="checked">
			        			<span class="weui_icon_checked"></span>
			      			</div>
			    		</label>
			   			*/
						var div = "<label class=\"weui_cell weui_check_labe\" for=\"a"+i+"\">";
						div += "<div class=\"weui_cell_bd weui_cell_primary\">";
						div += "<p>"+list[i].substring(1,list[i].length-1)+"</p>";
						div += "</div>";
						div += "<div class=\"weui_cell_ft\">";
						div += "<input type=\"radio\" value=\"a"+i+"\" class=\"weui_check\" name=\"address\" id=\"a"+i+"\" >";
						div += "<span class=\"weui_icon_checked\"></span>";
						div += "</div>";
						div += "</label>";
						content += div;
					}
					$("#address_list").html(content);
				}
			}
		}
	});
}

function bindSubmit(){
	$("#buy").on("click",function(){
		
		var phone_index = $("input:radio[name=phone]:checked").val();
		var address_index = $("input:radio[name=address]:checked").val();
		
		if(isnull(phone_index)){
			alert("请选择联系方式");
			return;
		}
		if(isnull(address_index)){
			alert("请选择收货地址");
			return;
		}
		phone_index = phone_index.substring(1,phone_index.length);
		address_index = address_index.substring(1,address_index.length);
		var od = {
			address:address_list_p[address_index],
			phone:phone_list_p[phone_index],
			scan_list:scan_list
		};
		var oi = {
			orderdetails:JSON.stringify(od),
			value:total_price
		};
		$.ajax({
			url : "/wc_shop/home/submitOrder",
			contentType : 'application/json;charset=utf-8',
			data : JSON.stringify(oi),
			type : "post",
			success : function(data){
				if(data.result){
					
					var cookie = $.cookie("shopcart")
					var sc_list = cookie.split(";");
					var cb_index = $("#hidden_param2").text();
					var cb_value = cb_index.split(";");
					for(var i=0;i<cb_value.length-1;i++){
						sc_list.splice(cb_value[i]-i,1);
					}
					var newcookie = "";
					for(var i=0;i<sc_list.length-1;i++){
						newcookie += sc_list[i] + ";";
					}
					$.cookie("shopcart",newcookie,{expires : 30,path : '/'});
					
					window.location.href = "pay?on=" + data.msg;
				}else{
					alert(data.msg);
				}
			}
		});
		
	});
}

function isnull(o){
	if(o == "" || o == null || o == undefined)
		return true;
	return false;
}
