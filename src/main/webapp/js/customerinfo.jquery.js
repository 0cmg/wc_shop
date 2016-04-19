$(function(){
	
	getCustomerinfo();
	
	
	$("#addphone").on("click",function(){
		$("#phone_dialog_title").text("新增手机号码");
		$("#status").text("add");
		$("#phone_dialog").show();
	});
	
	$("#editphone").on("click",function(){
		var index = $("input:radio[name=phone]:checked").val();
		if(index == null || index == undefined){
			alert("请选择后再编辑！");
			return;
		}
		index = index.substring(1,index.length);
		$("#status").text("edit");
		$("#index").text(index);
		$("#phone_dialog").show();
	});

	$("#delphone").on("click",function(){
		var index = $("input:radio[name=phone]:checked").val();
		if(index == null || index == undefined){
			alert("请选择后再删除！");
			return;
		}
		index = index.substring(1,index.length);
		$.ajax({
			url : "/wc_shop/front/data/delPhone",
			contentType : 'application/json;charset=utf-8',
			data : JSON.stringify(index),
			type : "post",
			success : function(data){
				if(data.result){
					getCustomerinfo();
				}else{
					alert("操作失败");
				}
			}
		});
	});
	
	$("#phone_dialog_cancel").on("click",function(){
		$("#phone_dialog").hide();
	});
	
	$("#phone_dialog_submit").on("click",function(){
		var number = $("#phonenumber").val();
		if(number.length != 11){
			alert("请输入正确的手机号码！");
			return;
		}
		if($("#status").text() == "add"){
			$.ajax({
				url : "/wc_shop/front/data/addPhone",
				contentType : 'application/json;charset=utf-8',
				data : JSON.stringify(number),
				type : "post",
				success : function(data){
					if(data.result){
						$("#phone_dialog").hide();
						getCustomerinfo();
					}else{
						alert("操作失败！");
					}
					
				}
			});
		}else if($("#status").text() == "edit"){
			var index = $("#index").text();
			var object = {
				index:index,
				number:number
			};
			$.ajax({
				url : "/wc_shop/front/data/editPhone",
				contentType : 'application/json;charset=utf-8',
				data : JSON.stringify(object),
				type : "post",
				success : function(data){
					if(data.result){
						$("#phone_dialog").hide();
						getCustomerinfo();
					}else{
						alert("操作失败！");
					}
					
				}
			});
		}
	});
	
	$("#editaddress").on("click",function(){
		var index = $("input:radio[name=address]:checked").val();
		if(index == null || index == undefined){
			alert("请选择后再编辑！");
			return;
		}
		index = index.substring(1,index.length);
		$("#index_address").text(index);
		$("#address_dialog").show();
	});
	
	$("#deladdress").on("click",function(){
		var index = $("input:radio[name=address]:checked").val();
		if(index == null || index == undefined){
			alert("请选择后再删除！");
			return;
		}
		index = index.substring(1,index.length);
		$.ajax({
			url : "/wc_shop/front/data/delAddress",
			contentType : 'application/json;charset=utf-8',
			data : JSON.stringify(index),
			type : "post",
			success : function(data){
				if(data.result){
					getCustomerinfo();
				}else{
					alert("操作失败！");
				}
			}
		});
	});
	
	$("#address_dialog_cancel").on("click",function(){
		$("#address_dialog").hide();
	});
	
	$("#address_dialog_submit").on("click",function(){
		var address = $("#address_content").val();
		var index = $("#index_address").text();
		var object = {
			index:index,
			address:address
		};
		$.ajax({
			url : "/wc_shop/front/data/editAddress",
				contentType : 'application/json;charset=utf-8',
				data : JSON.stringify(object),
				type : "post",
				success : function(data){
					if(data.result){
						$("#address_dialog").hide();
						getCustomerinfo();
					}else{
						alert("操作失败！");
					}
				}
		});
	});
	
});

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