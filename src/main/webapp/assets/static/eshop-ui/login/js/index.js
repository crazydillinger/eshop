$(document).ready(function() {
	$("#loginBtn").on("click", function() {
		var username = $("#username").val();
		var password = $("#password").val();
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
		url : "/eshop/user/login",
		data : JSON.stringify({
			username : username,
			password : password
		}),
		success : function(json) {
			if(json.data.code == -1){
				layer.msg(json.data.msg);
			}else{
				window.location.href = "http://localhost:8080/eshop/index";
			}
		}
	});
}