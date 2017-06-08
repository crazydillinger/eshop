$(document).ready(function(){
	init();
	loadGoods();
});
function loadGoods(){
	$.ajax({
		type:'post',
		dataType:'json',
		contentType:'application/json;charset=utf-8',
		url:'/eshop/goods/all',
		success : function(json){
			makeHtml(json.data);
		}
	});
}
function makeHtml(page){
	var table = $("#first");
	table.html("");
	var tableContent = "";
	for(var i in page.lists){
		if(!isNaN(i)){
			var data = page.lists[i];
			for(var t in data){
				if(!isNaN(t)){
					var d = data[t];
					tableContent += makeAddressHtml(d);
				}
			}	
		}
	}
	if(tableContent == ""){
		tableContent += "<span>还没有数据哦</span>"
	}
	table.html(tableContent);
	bindEvent();
}
function bindEvent(){
	$(".outer-con").on("click",function(){
		var id = $(this).attr("id");
		window.location.href = "http://localhost:8080/eshop/goods?id="+id;
	});
}
function makeAddressHtml(data){
	var content = $("#goodsTmp").html();
	content = content.replace(/#goodsName#/g,data.goodsName);
	content = content.replace(/#sellPrice#/g,data.sellPrice);
	content = content.replace(/#picture#/g,data.picture);
	content = content.replace(/#id#/g,data.id);
	return content;
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
		}
	});
}
$("#ai-topsearch").on("click",function(){
	var goodsName = $("#searchInput").val();
	$.ajax({
		type:'post',	
		url:'/eshop/goods/like',
		data:"goodsName="+goodsName,
		success : function(json){
			if(json.data.code == -1){
				layer.msg("没有查询到结果");
			}else{
				window.location.href = "http://localhost:8080/eshop/goods?id="+json.data.id;
			}	
		}
	});
});