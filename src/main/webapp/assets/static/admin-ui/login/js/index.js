$(document).ready(function() {
	$("#submit").on("click", function() {
		var username = $(".text").val();
		var password = $("#pwd").val();
		login(username, password);
	});
});
function login(username, password, callback) {
	layer.msg('加载中', {
		icon : 16,
		shade : 0.01
	});
	$.ajax({
		type : "post",
		dataType : "json",
		contentType : "application/json;charset=utf-8",
		url : "/eshop/login",
		data : JSON.stringify({
			username : username,
			password : password
		}),
		success : function(json) {
			layer.msg(json.data.msg);
			
		}
	});
}