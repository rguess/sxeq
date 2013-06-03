$(document).ready(function() {
	
});

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