$(function(){
	$("#finish").on("click",function(){
		var address = $("#address").val();
		if(address.length == 0){
			alert("请输入地址！");
		}else{
			$.ajax({
				url:"/wc_shop/front/data/addAddress",
				contentType : 'application/json;charset=utf-8',
				data : JSON.stringify(address),
				type:"post",
				success:function(data){
					if(data.result){
						window.location.href = "address";
					}else{
						alert("出现异常错误！");
					}
				}
			});
		}
	});
});