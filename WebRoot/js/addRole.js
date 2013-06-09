$(document).ready(function() {
	
});

//提交前验证表单
function formValidate() {
	
	var flag = true;
	
	if("" == $.trim($("#roleName").val())){
		$("#roleName").parent().parent().addClass("error");
		$("#roleName").next().html("角色名不能为空");
		flag = false;
	}else if(checkRoleIsExist($("#roleName").val().trim())){
		$("#roleName").parent().parent().addClass("error");
		$("#roleName").next().html("该角色名称已存在已存在");
		flag = false;
	}else{
		$("#roleName").parent().parent().removeClass("error");
		$("#roleName").next().html("");
	}
	
	if("" == $.trim($("#desciption").val())){
		$("#desciption").parent().parent().addClass("error");
		$("#desciption").next().html("描述不能为空");
		flag = false;
	}else{
		$("#desciption").parent().parent().removeClass("error");
		$("#desciption").next().html("");
	}
	
	if($("input[name=rightId][id=rightId]:checked").length == 0){
		alert("请选择权限");
		flag = false;
	}
	return flag;
	
}

//验证角色名
function checkRoleName(object){
	if("" == $.trim($(object).val())){
		$(object).parent().parent().addClass("error");
		$(object).next().html("角色名不能为空");
	}else if(checkRoleIsExist($(object).val())){
		$(object).parent().parent().addClass("error");
		$(object).next().html("该角色名称已存在已存在");
	}else{
		$(object).parent().parent().removeClass("error");
		$(object).next().html("");
	}
}

//验证描述
function checkDesciption(object) {
	
	if("" == $.trim($(object).val())){
		$(object).parent().parent().addClass("error");
		$(object).next().html("描述不能为空");
	}else{
		$(object).parent().parent().removeClass("error");
		$(object).next().html("");
	}
}


function checkRoleIsExist(roleName){
	var flag = true;
	$.ajax({
		url : 'async/roleNameIsExit?roleName='+roleName,
		type : 'GET',
		async : false,
		success : function(data) {
			var is = data.isExit;
			flag = is;
		}
	});
	return flag;
}
