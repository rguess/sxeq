$(document).ready(function() {
	
});


function roleFormSubmit(){
	if(formValidate()){
		document.roleForm.submit();
	}
}

//提交前验证表单
function formValidate() {
	
	var flag = true;
	
	if(null == $("#Mdesciption").val() || "" == $("#Mdesciption").val().trim()){
		$("#Mdesciption").parent().parent().addClass("error");
		$("#Mdesciption").next().html("描述不能为空");
		flag = false;
	}else{
		$("#Mdesciption").parent().parent().removeClass("error");
		$("#Mdesciption").next().html("");
	}
	
	return flag;
	
}

//验证描述
function checkDesciption(object) {
	
	if(null == $(object).val() || "" == $(object).val().trim()){
		$(object).parent().parent().addClass("error");
		$(object).next().html("描述不能为空");
	}else{
		$(object).parent().parent().removeClass("error");
		$(object).next().html("");
	}
}

//根据角色ID判断该角色是否被用户占用,true:占用，false:未占用
function CheckRoleById(id){
	var flag = true;
	if(!checkRight1("/Role_deleteRole")){
		return false;
	}
	$.ajax({
		url : 'async/checkRole?id='+id,
		type : 'GET',
		async:false,
		success : function(data) {
			var is = data.is;
			if(is){
				alert("该角色有用户使用，不能直接删除！");
				flag = false;
			}else{
				flag = true;
			}
		}
	});
	return flag;
}

function initModal(id){
	
	if(!checkRight1("/Role_updateRole")){
		return;
	}
	$("#myModal").modal();
	setRights(id);
	$.ajax({
		url : 'async/getRoleById?id='+id,
		type : 'GET',
		success : function(data) {
			var role = data.role;
			
			$("#MroleId").val(role.id);
			$("#MRoleName").val(role.roleName);
			$("#Mdesciption").val(role.description);
		}
	});
}

function setRights(roleId){
	$.ajax({
		url : 'async/userRightList?id='+roleId,
		type : 'GET',
		success : function(meta) {
			var userRights = meta.rights;
			$("#rights input[value][id=rightId]").removeAttr("checked");
			$.each(userRights,function(i,it){
				$("#rights input[value="+it.id+"][id=rightId]").attr("checked","checked");
			});
	}
	});
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
