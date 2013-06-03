$(document).ready(function() {
	
});

function initModal(id){
	getRight();
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

//获取权限列表
function getRight() {
	$("#Mrights").empty();
	$.ajax({
		url : 'async/rightList',
		type : 'GET',
		success : function(data) {
			var rights = data.rights;
			$.each(rights,function(i,item){
				$("#Mrights").append('<input type="checkbox" value="'+item.id+'" name="rightId">');
				$("#Mrights").append(item.rightName);
				$("#Mrights").append("<br/>");
			});
		}
	});
}