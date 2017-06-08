$(document).ready(function(){
	init();
});
$("#modifyUser").on("click",function(){
	modifyUserInfo();
});
function modifyUserInfo(){
	var realName = $("#user-name2").val();
	var userTel = $("#user-phone").val();
	var userMail = $("#user-email").val();
	var question =  $("#doc-select-1 option:selected").text();
	var answer = $("#answer").val();
	var gender = $("input[name='doc-radio-1']:checked").val();
	$.ajax({
		type:'post',
		dataType:'json',
		contentType:'application/json;charset=utf-8',
		url:'/eshop/user/modify',
		data:JSON.stringify({realName:realName,userTel:userTel,userMail:userMail,question:question,answer:answer,gender:gender}),
		success : function(json){
			layer.msg(json.data.msg);
		}
	});
}
function init(){
	$.ajax({
		type:'post',
		dataType:'json',
		contentType:'application/json;charset=utf-8',
		url:'/eshop/user/userSession',
		success : function(json){
			if(json.data.user == null){
				$("#username").text("请登录");
				$("#username").attr("href","/eshop/login");
			}else{
				$("#username").text("你好，"+json.data.user.username);
				$("#username").attr("href","/eshop/userInfo");
			}			
			loadUserInfo();
		}
	});
}
function loadUserInfo(){
	$.ajax({
		type:'post',
		dataType:'json',
		contentType:'application/json;charset=utf-8',
		url:'/eshop/user/loadUserInfo',
		success : function(json){
			makeHtml(json.data.user);
		}
	});
}
function makeHtml(data){
	$(".info-m #username").text(data.username);
	$(".u-safety #integral").text((data.integral == null || data.integral ==0)?0:data.integral); 
	$("#user-name2").val(data.realname);
	$("#user-phone").val(data.userTel);
	$("#user-email").val(data.userMail);
	$("#user-email").val(data.userMail);
}