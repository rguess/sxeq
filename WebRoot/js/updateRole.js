$(document).ready(function() {
	
});

//根据角色ID判断该角色是否被用户占用,true:占用，false:未占用
function CheckRoleById(id){
	var flag = true;
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
