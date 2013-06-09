$(document).ready(function() {
	
});

function departmentFormSubmit(){
	if(formValidate()){
		document.departmentForm.submit();
	}
}


//根据角色ID判断该角色是否被用户占用,true:占用，false:未占用
function CheckDepartmentById(id){
	if(!checkRight1("/Department_deleteDepartment")){
		return false;
	}
	var flag = true;
	$.ajax({
		url : 'async/checkDepartment?id='+id,
		type : 'GET',
		async:false,
		success : function(data) {
			var is = data.is;
			if(is){
				alert("该部门有人，不能直接删除！");
				flag = false;
			}else{
				flag = true;
			}
		}
	});
	
	return flag;
}

//提交前验证表单
function formValidate() {
	
	var flag = true;
	
	if("" == $.trim($("#Mdesciption").val())){
		$("#Mdesciption").parent().parent().addClass("error");
		$("#Mdesciption").next().html("描述不能为空");
		flag = false;
	}else{
		$("#Mdesciption").parent().parent().removeClass("error");
		$("#Mdesciption").next().html("");
	}
	
	return flag;
	
}

function initModal(id){
	
	if(!checkRight1("/Department_updateDepartment")){
		return;
	}
	$("#myModal").modal();
	$.ajax({
		url : 'async/getDepartmentById?id='+id,
		type : 'GET',
		success : function(data) {
			var department = data.department;
			$("#MDepartmentId").val(department.id);
			$("#MDepartmentName").val(department.departmentName);
			$("#Mdesciption").val(department.desciption);
		}
	});
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

//检查权限
function checkRight1(rightStr){
	var flag = true
	$.ajax({
		url : 'async/checkRight?rightStr='+rightStr,
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