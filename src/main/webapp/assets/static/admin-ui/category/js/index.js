$(document).ready(function(){
	init(1);//查询一级类别
});
function init(rank){
	layer.msg('加载中', {
		icon : 16,
		shade : 0.01
	});
	$.ajax({
		type:"get",
		dataType:"json",
		contentType : "application/json;charset=utf-8",
		url:"/eshop/category/queryFirst?rank="+rank,
		success : function(json) {	
			makeHtml($("#page-wrapper #cateFirstSelect"),json.data.categorys,'一级分类');
		}
	});
}
function makeHtml($select,lines,first){
	var content = first != '' ? '<option value="">' + first + '</option>' : '';
	for(var i in lines){
		if(!isNaN(i)){
			var data = lines[i];
			content += '<option value="'+data.id+'">'+data.categoryName+'</option>'
		}
	}
	$($select).html(content);
}
$( "#firCategory" ).on( "click", function( event ) {
	 $("#firModal").modal({});
});
$( "#subCategory" ).on( "click", function( event ) {
	 $("#subModal").modal({});
});
$("#firModal #saveBtn").on("click",function(){
	var firstCate = $("#firModal #firstCate").val();
	var secondCate = $("#firModal #secondCate").val();
	var thirdCate = $("#firModal #thirdCate").val();
	addCategory(firstCate,secondCate,thirdCate);
});
function addCategory(firstCate,secondCate,thirdCate){
	layer.msg('加载中', {
		icon : 16,
		shade : 0.01
	});
	$.ajax({
		type:"post",
		dataType:"json",
		contentType : "application/json;charset=utf-8",
		data:JSON.stringify({firstCate:firstCate,secondCate:secondCate,thirdCate:thirdCate}),
		url:"/eshop/category/add",
		success : function(json) {	
			if(json.data.code == -1){
				layer.msg(json.data.msg);
			}else{
				layer.msg(json.data.msg);
				$("#firModal").modal('hide');
			}	
		}
	});
}
$("#page-wrapper #cateFirstSelect").change(function(){
	var parentId = $("#page-wrapper #cateFirstSelect").val();
	var rank = 2;
	$.ajax({
		type:"get",
		dataType:"json",
		contentType : "application/json;charset=utf-8",
		url:"/eshop/category/query?rank="+rank+"&parentId="+parentId,
		success : function(json) {	
			makeHtml($("#page-wrapper #cateSecondSelect"),json.data.categorys,'二级分类');
		}
	});
});
$("#page-wrapper #cateSecondSelect").change(function(){
	var parentId = $("#page-wrapper #cateSecondSelect").val();
	var rank = 3;
	$.ajax({
		type:"get",
		dataType:"json",
		contentType : "application/json;charset=utf-8",
		url:"/eshop/category/query?rank="+rank+"&parentId="+parentId,
		success : function(json) {	
			makeHtml($("#page-wrapper #cateThirdSelect"),json.data.categorys,'三级级分类');
		}
	});
});