$(document).ready(function() {
	//alert(123);
//	window.location.href = "index.html";
	checkUserIsExit();
});

function checkLoginId(object){
	var reg =/^[a-zA-Z][a-zA-Z0-9_]{4,15}$/;
	if(!reg.test($(object).val())){
		$(object).parent().parent().addClass("error");
		$(object).next().html("请正确输入用户名");
	}else{
		$(object).parent().parent().removeClass("error");
		$(object).next().html("");
	}
}

function checkUserIsExit(){
	
	var error = $.getParam("error");

	if(error == "loginId"){
		$("#NameError").parent().parent().addClass("error");
		$("#NameError").html("用户名不存在！");
	}else{
		
	}
}