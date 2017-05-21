$(document).ready(function(){
	$('#regBtn').bind('click',function(){
		var username = $('.am-tabs-bd #username').val();
		var password = $('.am-tabs-bd #password').val();
		var pwdRepeat = $('.am-tabs-bd #passwordRepeat').val();
		if (!$('#reader-me').is(':checked')) {
			layer.msg("请先同意相关协议");
			return;
		}
		register(username,password,pwdRepeat);
	});
});	

function register(username,password,pwdRepeat){
	layer.msg('加载中', {
		  icon: 16
		  ,shade: 0.01
		});
	var data = "username="+username+"&password="+password+"&pwdRepeat="+pwdRepeat;
	$.ajax({
		type:'post',
		dataType:'json',
		contentType:'application/json;charset=utf-8',
		data:JSON.stringify({username:username,password:password,pwdRepeat:pwdRepeat}),
		url:'/eshop/user/register',
		success : function(json){
			if(json.data.code == -1){
				layer.msg(json.data.msg);
			}else{
				layer.msg('注册成功');
				window.location.href = 'http://localhost:8080/eshop/login'
			}
		}
	});
}