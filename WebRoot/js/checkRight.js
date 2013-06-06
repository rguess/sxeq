$(document).ready(function() {
	
	$("a[href=User_UserList]").click({name:"/User_UserList"},checkRight);
	$("a[href=User_addUser]").click({name:"/User_addUser"},checkRight);
	$("a[href^=User_deleteUser]").click({name:"/User_deleteUser"},checkRight);
	
	$("a[href=Role_roleList]").click({name:"/Role_roleList"},checkRight);
	$("a[href=Role_addRole]").click({name:"/Role_addRole"},checkRight);
	$("a[href^=Role_deleteRole]").click({name:"/Role_deleteRole"},checkRight);
	
	$("a[href=Right_rightList]").click({name:"/Right_rightList"},checkRight);
	
	$("a[href=Department_departmentList]").click({name:"/Department_departmentList"},checkRight);
	$("a[href=Department_addDepartment]").click({name:"/Department_addDepartment"},checkRight);
	
	$("a[href=Log_logList]").click({name:"/Log_logList"},checkRight);
	
});


function checkRight(event){
	var rightStr = event.data.name;
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