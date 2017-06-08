$(document).ready(function(){
	init();
	loadAddress();
});
$("#saveAddress").on("click",function(){
	addressAdd();
});
function loadAddress(){
	$.ajax({
		type:'post',
		dataType:'json',
		contentType:'application/json;charset=utf-8',	
		url:'/eshop/eshopAddress/all',
		success : function(json){
			makeHtml(json.data);
			bindEvent();
		}
	});
}
function bindEvent(){
	$(".deleteAddress").on("click",function(){
		var id = $(this).attr("addressId");
		$.ajax({
			type:'post',	
			url:'/eshop/eshopAddress/delete',
			data:"id="+id,
			success : function(json){
				layer.msg("删除成功");
				loadAddress();
			}
		});
	});
	$(".defAddress").on("click",function(){
		var id = $(this).attr("addressId");
		$.ajax({
			type:'post',	
			url:'/eshop/eshopAddress/def',
			data:"id="+id,
			success : function(json){
				loadAddress();
			}
		});
	});
	$(".editAddress").on("click",function(){
		var id = $(this).attr("addressId");
		$("#title").html("修改地址");
		$.ajax({
			type:'post',	
			url:'/eshop/eshopAddress/one',
			data:"id="+id,
			success : function(json){
				$("#user-name").val(json.data.address.username);
				$("#user-phone").val(json.data.address.userTel); 
				$("#zipcode").val(json.data.address.zipCode);
				$("#cmbProvince").next().children().eq(0).children().eq(0).text(json.data.address.province);
				$("#cmbCity").next().children().eq(0).children().eq(0).text(json.data.address.city); 
				$("#cmbArea").next().children().eq(0).children().eq(0).text(json.data.address.county);
				$("#user-intro").val(json.data.address.detailAddress);
				$("#saveAddress").css("display","none");
				$("#editAddress").css("display","block");
				$("#editAddress").attr("addressId",id);
			}
		});
	});
}
$("#editAddress").on("click",function(){
	var id = $("#editAddress").attr("addressId");
	var username = $("#user-name").val();
	var userTel =$("#user-phone").val(); 
	var zipcode = $("#zipcode").val();
	var province = $("#cmbProvince").val();
	var city = $("#cmbCity").val();
	var county = $("#cmbArea").val();
	var detailaddress = $("#user-intro").val();
	$.ajax({
		type:'post',
		dataType:'json',
		contentType:'application/json;charset=utf-8',
		data:JSON.stringify({id:id,userTel:userTel,username:username,zipcode:zipcode,province:province,city:city,county:county,detailaddress:detailaddress}),
		url:'/eshop/eshopAddress/modify',
		success : function(json){
			layer.msg(json.data.msg);
			loadAddress();
		}
	});
});
function makeHtml(page){
//	var table = $(".user-address");
//	table.find("#ulAddress").html("");
	var table = $(".user-address #ulAddress");
	table.html("");
	var tableContent = "";
	for(var i in page.address){
		if(!isNaN(i)){
			var data = page.address[i];			
			tableContent += makeAddressHtml(data);
		}
	}
	if(tableContent == ""){
		tableContent += "<span>还没有数据哦</span>"
	}
	table.html(tableContent);
}
function makeAddressHtml(data){
	var content = $("#addressTemp").html();
	content = content.replace(/#username#/g,data.username);
	content = content.replace(/#userTel#/g,data.userTel);
	content = content.replace(/#province#/g,data.province);
	content = content.replace(/#city#/g,data.city);
	content = content.replace(/#county#/g,data.county);
	content = content.replace(/#detailaddress#/g,data.detailAddress);
	content = content.replace(/#id#/g,data.id);
	if(data.defaultAddress == -1){
		content = content.replace(/#type#/g,"none"); 
	}else{
		content = content.replace(/#type#/g,"block");
	}
	return content;
}
function addressAdd(){
	var username = $("#user-name").val();
	var userTel =$("#user-phone").val(); 
	var zipcode = $("#zipcode").val();
	var province = $("#cmbProvince").val();
	var city = $("#cmbCity").val();
	var county = $("#cmbArea").val();
	var detailaddress = $("#user-intro").val();
	$.ajax({
		type:'post',
		dataType:'json',
		contentType:'application/json;charset=utf-8',
		data:JSON.stringify({userTel:userTel,username:username,zipcode:zipcode,province:province,city:city,county:county,detailaddress:detailaddress}),
		url:'/eshop/eshopAddress/add',
		success : function(json){
			layer.msg(json.data.msg);
			loadAddress();
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
		}
	});
}