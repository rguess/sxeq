$(document).ready(function() {
	
});

function userFormSubmit(){
	if(formValidate()){
		document.userForm.submit();
	}
}

function initModal(id){
	getDepartment();
	getRole();
	$.ajax({
		url : 'async/getUserById?id='+id,
		type : 'GET',
		success : function(data) {
			var user = data.user;
			$("#MUserId").val(user.id);
			$("#MUserName").val(user.userName);
			$("#MloginId").val(user.loginId);
			$("#Mpassword").val("######");
			$("#Mrepassword").val("######");
			$("#Mphone").val(user.mobile);
			$("#Memail").val(user.email);
		}
	});
}



//获取部门列表
function getDepartment() {
	$("#Mdepartment").empty();
	$.ajax({
		url : 'async/departmentList',
		type : 'GET',
		success : function(data) {
			var departmets = data.departments;
			$.each(departmets,function(i,item){
				$("#Mdepartment").append("<option>"+item.departmentName+"</option>");
			});
		}
	});
}

//获取角色列表
function getRole() {
	$("#Mrole").empty();
	$.ajax({
		url : 'async/roleList',
		type : 'GET',
		success : function(data) {
			var roles = data.roles;
			$.each(roles,function(i,item){
				$("#Mrole").append("<option>"+item.roleName+"</option>");
			});
		}
	});
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
	if($(object).val() != $("#Mpassword").val()){
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

//验证地址
function checkAddress(object) {
	if($(object).val().length<2){
		$(object).parent().parent().addClass("error");
		$(object).next().html("地址长度应该在2为以上");
	}else{
		$(object).parent().parent().removeClass("error");
		$(object).next().html("");
	}
}

//验证工资
function checkSalary(object) {
	var reg = /^\d{3,5}/;
	if(!reg.test($(object).val())){
		$(object).parent().parent().parent().addClass("error");
		$(object).parent().next().html("工资不正确");
	}else{
		$(object).parent().parent().parent().removeClass("error");
		$(object).parent().next().html("");
	}
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

//提交前验证表单
function formValidate() {
	
	var flag = true;
	
	if($("#MUserName").val().length>4 || $("#MUserName").val().length<2){
		$("#MUserName").parent().parent().addClass("error");
		$("#MUserName").next().html("长度在2到4之间");
	}else{
		$("#MUserName").parent().parent().removeClass("error");
		$("#MUserName").next().html("");
	}
	
	var reg2 =/[\x21-\x7E]{6,15}/;
	if(!reg2.test($("#Mpassword").val())){
		$("#Mpassword").parent().parent().addClass("error");
		$("#Mpassword").next().html("密码长度在6-15之间");
		flag = false;
	}else{
		$("#Mpassword").parent().parent().removeClass("error");
		$("#Mpassword").next().html("");
	}
	
	if($("#Mrepassword").val() != $("#Mpassword").val()){
		$("#Mrepassword").parent().parent().addClass("error");
		$("#Mrepassword").next().html("两次密码不一致");
		flag = false;
	}else{
		$("#Mrepassword").parent().parent().removeClass("error");
		$("#Mrepassword").next().html("");
	}
	
	var reg3 = /^1[0-9]{10}$/;
	if(!reg3.test($("#Mphone").val())){
		$("#Mphone").parent().parent().addClass("error");
		$("#Mphone").next().html("请正确输入手机号");
		flag = false;
	}else{
		$("#Mphone").parent().parent().removeClass("error");
		$("#Mphone").next().html("");
	}
	
	var reg4 = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(!reg4.test($("#Memail").val())){
		$("#Memail").parent().parent().addClass("error");
		$("#Memail").next().html("请输入正确的邮箱地址");
	}else{
		$("#Memail").parent().parent().removeClass("error");
		$("#Memail").next().html("");
	}
	
	return flag;
	
}