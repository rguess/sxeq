$(document).ready(function() {
	
});

//提交前验证表单
function formValidate() {
	
	var flag = true;
	
	if("" == $.trim($("#departmentName").val())){
		$("#departmentName").parent().parent().addClass("error");
		$("#departmentName").next().html("部门名称不能为空");
		flag = false;
	}else if(checkDepartmentIsExist($("#departmentName").val())){
		$("#departmentName").parent().parent().addClass("error");
		$("#departmentName").next().html("该部门名称已存在");
		flag = false;
	}else{
		$("#departmentName").parent().parent().removeClass("error");
		$("#departmentName").next().html("");
	}
	
	if("" == $.trim($("#desciption").val())){
		$("#desciption").parent().parent().addClass("error");
		$("#desciption").next().html("描述不能为空");
		flag = false;
	}else{
		$("#desciption").parent().parent().removeClass("error");
		$("#desciption").next().html("");
	}
	
	return flag;
	
}

//验证部门名称
function checkDepartmentName(object){

	if("" == $.trim($(object).val())){
		$(object).parent().parent().addClass("error");
		$(object).next().html("部门名称不能为空");
	}else if(checkDepartmentIsExist($(object).val())){
		$(object).parent().parent().addClass("error");
		$(object).next().html("该部门名称已存在");
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

function checkDepartmentIsExist(departmentName){
	var flag = true;
	$.ajax({
		url : 'async/departmentNameIsExit?departmentName='+departmentName,
		type : 'GET',
		async : false,
		success : function(data) {
			var is = data.isExit;
			flag = is;
		}
	});
	return flag;
}
