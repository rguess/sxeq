$(document).ready(function() {
	
});

//提交前验证表单
function formValidate() {
	var flag = true;
	if($("#userName").val().length>4 || $("#userName").val().length<2){
		$("#userName").parent().parent().addClass("error");
		$("#userName").next().html("长度在2到4之间");
		flag = false;
	}else{
		$("#userName").parent().parent().removeClass("error");
		$("#userName").next().html("");
	}
	
	var reg1 =/^[a-zA-Z][a-zA-Z0-9_]{4,15}$/;
	if(!reg1.test($("#loginId").val())){
		$("#loginId").parent().parent().addClass("error");
		$("#loginId").next().html("账号必须是以字母开头，长度在5到15之间");
		flag = false;
	}else if(checkLoginIdIsExist($("#loginId").val())){
		$("#loginId").parent().parent().addClass("error");
		$("#loginId").next().html("该登陆名已存在");
		flag = false;
	}else{
		$("#loginId").parent().parent().removeClass("error");
		$("#loginId").next().html("");
	}
	
	var reg2 =/[\x21-\x7E]{6,15}/;
	if(!reg2.test($("#password").val())){
		$("#password").parent().parent().addClass("error");
		$("#password").next().html("密码长度在6-15之间");
		flag = false;
	}else{
		$("#password").parent().parent().removeClass("error");
		$("#password").next().html("");
	}
	
	if($("#repassword").val() != $("#password").val()){
		$("#repassword").parent().parent().addClass("error");
		$("#repassword").next().html("两次密码不一致");
		flag = false;
	}else{
		$("#repassword").parent().parent().removeClass("error");
		$("#repassword").next().html("");
	}
	
	var reg3 = /^1[0-9]{10}$/;
	if(!reg3.test($("#phone").val())){
		$("#phone").parent().parent().addClass("error");
		$("#phone").next().html("请正确输入手机号");
		flag = false;
	}else{
		$("#phone").parent().parent().removeClass("error");
		$("#phone").next().html("");
	}
	
	var reg4 = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(!reg4.test($("#email").val())){
		$("#email").parent().parent().addClass("error");
		$("#email").next().html("请输入正确的邮箱地址");
	}else{
		$("#email").parent().parent().removeClass("error");
		$("#email").next().html("");
	}
	return flag;
	
}


//验证用户名字
function checkUserName(object){
	
	if($(object).val().length>4 || $(object).val().length<2){
		$(object).parent().parent().addClass("error");
		$(object).next().html("长度在2到4之间");
	}else{
		$(object).parent().parent().removeClass("error");
		$(object).next().html("");
	}
}

//验证员工登陆名
function checkLoginId(object){

	var reg =/^[a-zA-Z][a-zA-Z0-9_]{4,15}$/;
	if(!reg.test($(object).val())){
		$(object).parent().parent().addClass("error");
		$(object).next().html("账号必须是以字母开头，长度在5到15之间");
	}else if(checkLoginIdIsExist($(object).val())){
		$(object).parent().parent().addClass("error");
		$(object).next().html("该登陆名已存在");
	}else{
		$(object).parent().parent().removeClass("error");
		$(object).next().html("");
	}
}

//验证员工密码
function checkPassword(object) {
	var reg =/[\x21-\x7E]{6,15}/;
	if(!reg.test($(object).val())){
		$(object).parent().parent().addClass("error");
		$(object).next().html("密码长度在6-15之间");
	}else{
		$(object).parent().parent().removeClass("error");
		$(object).next().html("");
	}
}

//验证员工重复密码
function checkRePassword(object) {
	
	if($(object).val() != $("#password").val()){
		$(object).parent().parent().addClass("error");
		$(object).next().html("两次密码不一致");
	}else{
		$(object).parent().parent().removeClass("error");
		$(object).next().html("");
	}
}

//验证手机号
function checkPhone(object) {
	var reg = /^1[0-9]{10}$/;
	if(!reg.test($(object).val())){
		$(object).parent().parent().addClass("error");
		$(object).next().html("请正确输入手机号");
	}else{
		$(object).parent().parent().removeClass("error");
		$(object).next().html("");
	}
}

//验证用户名是否存在
function checkLoginIdIsExist(loginId) {
	var flag = true;
	$.ajax({
		url : 'async/loginIdIsExit?user.loginId='+loginId,
		type : 'GET',
		async : false,
		success : function(data) {
			var is = data.isExit;
			flag = is;
		}
	});
	return flag;
}

//验证邮箱
function checkEmail(object){
	var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(!reg.test($(object).val())){
		$(object).parent().parent().addClass("error");
		$(object).next().html("请输入正确的邮箱地址");
	}else{
		$(object).parent().parent().removeClass("error");
		$(object).next().html("");
	}
}
