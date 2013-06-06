$(document).ready(function() {
	
});

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
