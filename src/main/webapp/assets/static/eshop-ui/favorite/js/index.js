$(document).ready(function(){
	init();
});
function init(){
	$.ajax({
		type:'post',
		dataType:'json',
		contentType:'application/json;charset=utf-8',
		url:'/eshop/collection/all',
		success : function(json){
			makeHtml(json.data)
		}
	});
}
function makeHtml(page){
	var table = $("#test");
	table.html("");
	var tableContent = "";
	for(var i in page.goods){
		if(!isNaN(i)){
			var data = page.goods[i];			
			tableContent += makeAddressHtml(data);
		}
	}
	if(tableContent == ""){
		tableContent += "<span>还没有数据哦</span>"
	}
	table.html(tableContent);
}
function makeAddressHtml(data){
	var content = $("#favorite").html();
	content = content.replace(/#goodsName#/g,data.goodsName);
	content = content.replace(/#picture#/g,data.picture);
	content = content.replace(/#sellPrice#/g,data.sellPrice);
	content = content.replace(/#reserve#/g,data.reserve);
	content = content.replace(/#primePrice#/g,data.primePrice);
	return content;
}