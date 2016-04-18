$(function(){
	$.ajax({
		url : "/wc_shop/front/data/getCustomerInfo",
		contentType : 'application/json;charset=utf-8',
		type : "get",
		success : function(data){
			var result = data.result;
			if(!result){
				var msg = data.msg;
				if(msg == "0"){
					$("#phone_list").html("<p>暂无数据！</p>");
					$("#address_list").html("<p>暂无数据！</p>");
				}else if(msg == "1"){
					alert("查询出错！");
				}
			}else{
				var object = data.t;
				var phone_list = object.phoneno;
				var address_list = object.address;
				if(phone_list == ""){
					$("#phone_list").html("<p>暂无数据！</p>");
				}else{
					
				}
				if(address_list == ""){
					$("#address_list").html("<p>暂无数据！</p>");
				}else{
					address_list = JSON.parse(address_list);
					var list = address_list.address_list;
					content = "";
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
	
});