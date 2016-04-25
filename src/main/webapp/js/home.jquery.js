var com_list = [];
$(function(){
	
	loadBaseData();
	addTypeListener();
	bindSearch();
	bindUrl();
	
});


function loadBaseData(){
	
	getAllTypes();
	getAllCommodity();
	
}
function getAllTypes(){
	$.ajax({
		url:"/wc_shop/back/data/getAllTypes",
		contentType : 'application/json;charset=utf-8',
		type:"post",
		success:function(data){
			//console.log(data);
			var types = data.t;
			var content = "<li><a class='type_listener' href='javascript:;'>全部</a></li>";
			for(var i=0;i<types.length;i++){
				content += "<li><a class='type_listener' href='javascript:;'>"+types[i].type+"</a></li>";
			}
			$("#type_list").html(content);
		}
	});
}
function addTypeListener(){
	$(document).on("click",".type_listener",function(){
		var type = $(this).text();
		//alert(id);
		
		var content = "";
		if(type == '全部'){
			for(var i=0;i<com_list.length;i++){
				content += "<div id='"+com_list[i].commodityid+"' class='commodity'>";
				content += "<div id='hidden_data'>"+com_list[i].type+"</div>";
				content += "<div class='commodity_photo'>";
				content += "<img class='com_img' src='"+com_list[i].imageurl+"'>";
				content += "</div>";
				content += "<div class='commodity_desc'>";
				content += "<div class='desc'>";
				content += "<div id='com_name'>"+com_list[i].name+"</div><br id='smallbr'>";
				content += "<div id='com_sdesc'>"+com_list[i].descsimple+"</div>";
				content += "</div></div>";
				content += "<div class='commodity_price'>";
				content += "<div class='price'>"+com_list[i].price+"￥</div></div>";
				content += "<br style='clear:both;'></div>";
			}
			
		}else{
			for(var i=0;i<com_list.length;i++){
				if(com_list[i].type != type){
					continue;
				}
				content += "<div id='"+com_list[i].commodityid+"' class='commodity'>";
				content += "<div id='hidden_data'>"+com_list[i].type+"</div>";
				content += "<div class='commodity_photo'>";
				content += "<img class='com_img' src='"+com_list[i].imageurl+"'>";
				content += "</div>";
				content += "<div class='commodity_desc'>";
				content += "<div class='desc'>";
				content += "<div id='com_name'>"+com_list[i].name+"</div><br id='smallbr'>";
				content += "<div id='com_sdesc'>"+com_list[i].descsimple+"</div>";
				content += "</div></div>";
				content += "<div class='commodity_price'>";
				content += "<div class='price'>"+com_list[i].price+"￥</div></div>";
				content += "<br style='clear:both;'></div>";
			}
		}
		$(".commodity_list").html(content);
		$(".commodity").css("cursor","pointer");
		imgWidthCorrect();
		
		$("#js-bootstrap-offcanvas").removeClass("in");
		$(document.body).removeAttr("style");
		
	});
}
function getAllCommodity(){
	var object = {
		isonline : 1
	};
	$.ajax({
		url:"/wc_shop/back/data/queryComByWhere",
		contentType: 'application/json;charset=utf-8',
		data: JSON.stringify(object),
		type:"post",
		success:function(data){
			if(data.result){
				com_list = data.t;
				
				var content = "";
				for(var i=0;i<com_list.length;i++){
					content += "<div id='"+com_list[i].commodityid+"' class='commodity'>";
					content += "<div id='hidden_data'>"+com_list[i].type+"</div>";
					content += "<div class='commodity_photo'>";
					content += "<img class='com_img' src='"+com_list[i].imageurl+"'>";
					content += "</div>";
					content += "<div class='commodity_desc'>";
					content += "<div class='desc'>";
					content += "<div id='com_name'>"+com_list[i].name+"</div><br id='smallbr'>";
					content += "<div id='com_sdesc'>"+com_list[i].descsimple+"</div>";
					content += "</div></div>";
					content += "<div class='commodity_price'>";
					content += "<div class='price'>"+com_list[i].price+"￥</div></div>";
					content += "<br style='clear:both;'></div>";
				}
				$(".commodity_list").html(content);
				$(".commodity").css("cursor","pointer");
				imgWidthCorrect();
			}else{
				alert("加载商品出错，请刷新页面");
			}
		}
	});
}
function imgWidthCorrect(){
	var wh = $(".com_img").innerHeight();
	$(".com_img").css('width',wh);
}

function bindSearch(){
	$("#search_button").on("click",function(){
		var kw = $("#search_input").val();
		var content = "";
		for(var i=0;i<com_list.length;i++){
			if(com_list[i].name.indexOf(kw) >= 0){
				content += "<div id='"+com_list[i].commodityid+"' class='commodity'>";
				content += "<div id='hidden_data'>"+com_list[i].type+"</div>";
				content += "<div class='commodity_photo'>";
				content += "<img class='com_img' src='"+com_list[i].imageurl+"'>";
				content += "</div>";
				content += "<div class='commodity_desc'>";
				content += "<div class='desc'>";
				content += "<div id='com_name'>"+com_list[i].name+"</div><br id='smallbr'>";
				content += "<div id='com_sdesc'>"+com_list[i].descsimple+"</div>";
				content += "</div></div>";
				content += "<div class='commodity_price'>";
				content += "<div class='price'>"+com_list[i].price+"￥</div></div>";
				content += "<br style='clear:both;'></div>";
			}
		}
		$(".commodity_list").html(content);
		$(".commodity").css("cursor","pointer");
		imgWidthCorrect();
	});
	
}

function bindUrl(){
	$(document).on("click",".commodity",function(){
		var id = $(this).attr("id");
		window.location.href = "/wc_shop/com/showdetail/"+id;
	});
}












