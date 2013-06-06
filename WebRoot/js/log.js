var pageSize = 5;
$(document).ready(function() {
	inintPage();
});

function deleteLog(id){
	if(!window.confirm("您确认要删除此日志吗？")){
		return false;
	}else{
		$.ajax({
			url : 'async/deleteLogById?id='+id,
			type : 'GET',
			success : function(data) {
				inintPage();
			}
		});
	}
	return false;
}

function inintPage(){
	$.ajax({
		url : 'async/getLogCount',
		type : 'GET',
		success : function(meta) {
			var count = meta.count;
			$("#Pagination").pagination(count, {
				num_edge_entries : 1, // 边缘页数
				num_display_entries : 4, // 主体页数
				callback : listLog,
				items_per_page : pageSize, // 每页显示1项
				prev_text : "前一页",
				next_text : "后一页"
			});
		}
	});
}

function listLog(page_index, jq){
	$.ajax({
		url : 'async/getLogs?offset='+page_index * pageSize+'&length='+pageSize,
		type : 'GET',
		success : function(data) {
			$("#logContent").empty();
			var logs = data.logs;
			$.each(logs,function(i,item){
				var row = "<tr><td>"
					+item.user.userName+"</td><td>"
					+item.content+"</td><td>"
					+item.date+"</td><td>"
					+item.remark+"</td><td>&nbsp<a href='javascript:void(0);' onclick='javascript:deleteLog("
					+item.id+");'>删除</a></td></tr>";
				$("#logContent").append(row);
			});
		}
	});
}
















