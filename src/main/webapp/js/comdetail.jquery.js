$(function(){
    $('.weui_tab').tab();
    getComData();
    
});

function getComData(){
	var id = $("#hidden_param").text();
	$.ajax({
		url:"/wc_shop/com/getComAllInfo/"+id,
		contentType : 'application/json;charset=utf-8',
		type:"get",
		success:function(data){
			if(data.result){
				var com = data.t;
				$("title").text(com.name);
				var urls = com.imageurl;
				var url_list = urls.split(";");
				//test
				/*
				for(var i=0;i<url_list.length;i++){
					alert(url_list[i]);
				}
				*/
				/*
				 * <div class="ws_images">
						<ul>
							<li><img src="data1/images/1.jpg" alt="1" title="1" id="wows1_0"></li>
							<li><img src="data1/images/2.jpg" alt="2" title="2" id="wows1_1"></li>
							<li><a href="http://wowslider.com/vi"><img src="data1/images/3.jpg" alt="bootstrap carousel" title="3" id="wows1_2"></a></li>
							<li><img src="data1/images/4.jpg" alt="4" title="4" id="wows1_3"></li>
						</ul>
					</div>
					<div class="ws_bullets">
						<div>
							<a href="#" title="1"><span><img src="data1/tooltips/1.jpg" alt="1">1</span></a>
							<a href="#" title="2"><span><img src="data1/tooltips/2.jpg" alt="2">2</span></a>
							<a href="#" title="3"><span><img src="data1/tooltips/3.jpg" alt="3">3</span></a>
							<a href="#" title="4"><span><img src="data1/tooltips/4.jpg" alt="4">4</span></a>
						</div>
					</div>
					<div class="ws_script" style="position:absolute;left:-99%"></div>
				<div class="ws_shadow"></div>
				 */
				var wh = $("#wowslider-container1").outerWidth();
				wh += "px";
				$("#wowslider-container1").css("height",wh);
				var content = "";
				content += "<div class='ws_images'><ul>";
				for(var i=0;i<url_list.length-1;i++){
					content += "<li><img src='"+url_list[i]+"' alt='"+i+"' title='"+i+"' id='wows1_"+i+"' style='width:"+wh+";height:"+wh+";'></li>";
				}
				content += "</ul></div><div class='ws_bullets'><div>";
				for(var i=0;i<url_list.length-1;i++){
					content += "<a href='#' title='"+i+"'><span><img src='"+url_list[i]+"' alt='"+i+"' >"+i+"</span></a>";
				}
				content += "</div></div><div class=\"ws_script\" style=\"position:absolute;left:-99%\"></div><div class=\"ws_shadow\"></div>";
				content += "<div style=\"height:1px; margin-top:-1px;clear: both;overflow:hidden;\"></div>";
				$("#wowslider-container1").html(content);
				$(".ws_images").css("height",wh);
				$(".ws_images").css("width",wh);
				$(".ws_images").css("max-height","360px");
				content = "<script type=\"text/javascript\" src=\"../../js/imgslider/wowslider.js\"></script>";
				content += "<script type=\"text/javascript\" src=\"../../js/imgslider/script.js\"></script>";
				$(document.head).append(content);
				
				var name = com.name;
				var descsimple = com.descsimple;
				var price = com.price;
				var sn = com.sellno;
				var rn = com.restno;
				var detail = com.descdetails;
				
				content = "<p>"+name+"</p><p>"+descsimple+"</p>";
				$("#ds").html(content);
				content = "￥ "+price;
				$("#price").html(content);
				$("#rn").html(rn);
				$("#sn").html(sn);
				$("#detail").html(detail);
				
			}else{
				alert("网络出现问题，请重新刷新页面");
			}
		}
	});
}