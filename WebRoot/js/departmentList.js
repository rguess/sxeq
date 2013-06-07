$(document).ready(function() {
	
});

function userFormSubmit(){
	if(formValidate()){
		document.userForm.submit();
	}
}

function initModal(id){
	
	if(!checkRight1()){
		return;
	}
	$("#myModal").modal();
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

//检查权限
function checkRight1(){
	var flag = true
	$.ajax({
		url : 'async/checkRight?rightStr=/User_updateUser',
		type : 'GET',
		async:false,
		success : function(data) {
			var isR = data.isRight;
			if(!isR){
				alert("您没有权限，请联系管理员！");
				flag = false;
			}
		}
	});
	return flag;
}