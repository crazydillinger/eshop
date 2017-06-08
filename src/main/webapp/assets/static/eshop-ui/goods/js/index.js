(function($) {
	$.getUrlParam = function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}
})(jQuery);
$(function() {
	init();
	var id = $.getUrlParam('id');
	$.ajax({
		type:'post',	
		url:'/eshop/goods/one',
		data:"id="+id,
		success : function(json){
			makeHtml(json.data.goods);
		}
	});
});
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
		}
	});
}
function makeHtml(data){
	var div = $(".item-inform");
	div.html("");
	var content = $("#goodsTmp").html();
	content = content.replace(/#picture#/g,data.picture);
	content = content.replace(/#goodsId#/g,data.id);
	content = content.replace(/#describe#/g,data.describe);
	content = content.replace(/#sellPrice#/g,data.sellPrice);
	content = content.replace(/#primePrice#/g,data.primePrice);
	content = content.replace(/#reserve#/g,data.reserve);
	div.html(content);
}
function add1(){
	var number = $("#text_box").val();
	$("#text_box").val(parseInt(number)+1);
	$("#min").removeAttr("disabled");
}
function sub(){
	var number = $("#text_box").val();
	$("#text_box").val(parseInt(number)-1);
	if(number == 1){
		$("#min").attr("disabled","disabled");	
	}
}
function collect(){
	var id = $.getUrlParam('id');
	$.ajax({
		type:'post',	
		url:'/eshop/collection/one',
		data:"id="+id,
		success : function(json){
			layer.msg("收藏成功");
		}
	});
}
function addCart(){
	var id = $.getUrlParam('id');
	var number = $("#text_box").val();
	$.ajax({
		type:'post',
		dataType:'json',
		contentType:'application/json;charset=utf-8',
		url:'/eshop/shopCart/add',
		data:JSON.stringify({id:id,number:number}),
		success : function(json){
			
		}
	});
}