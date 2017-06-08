$(document).ready(function(){
	init();
	loadCart();
});
function loadCart(){
	$.ajax({
		type:'post',
		dataType:'json',
		contentType:'application/json;charset=utf-8',
		url:'/eshop/shopCart/all',
		success : function(json){
			makeHtml(json.data);
		}
	});
}
function makeHtml(page){
	var table = $("#cart");
	table.html("");
	var tableContent = "";
	for(var i in page.lists){
		if(!isNaN(i)){
			var data = page.lists[i];
			tableContent += makeCartHtml(data);
		}
	}
	if(tableContent == ""){
		tableContent += "<span>还没有数据哦</span>"
	}
	table.html(tableContent);
	bindEvent();
}
function makeCartHtml(data){
	var content = $("#cartTemp").html();
	content = content.replace(/#picture#/g,data.picture);
	content = content.replace(/#goodsName#/g,data.goodsName);
	content = content.replace(/#primePrice#/g,data.primePrice);
	content = content.replace(/#sellPrice#/g,data.sellPrice);
	content = content.replace(/#isNew#/g,data.isNew);
	return content;
}
function bindEvent(){
	var price = $("#price").text();
	var number = $("#num").val();
	var mon = $("#mon").text(price*number);
	$("#J_Total").text(price*number);
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