// JavaScript Document
$(function(){
	var flag=true; //true为展开  false为关闭
	$("#nav_btn").click(function(){
		if(flag){
			$("#nav").animate({"opacity":"1","width":"200px","height":"250px","top":"-220px","left":"-170px"},500,function(){
				$("#nav").css({"opacity":"1","width":"200px","height":"250px","top":"-220px","left":"-170px"});flag=false;
			});
		}else{
			$("#nav").animate({"opacity":"0","width":"0px","height":"0px","top":"30px","left":"30px"},500,function(){
				$("#nav").css({"opacity":"0","width":"0px","height":"0px","top":"30px","left":"30px"}); flag=true;
			});
		}
	});	
//	$("#nav").bind("mouseout",function(){
//		$("#nav").animate({"opacity":"0","width":"0px","height":"0px","top":"30px","left":"30px"},500,function(){
//				$("#nav").css({"opacity":"0","width":"0px","height":"0px","top":"30px","left":"30px"}); flag=true;
//			});
//	})
    $("#userlog").click(function () {
       	 window.location.href = "/toLogin";
        }
    );
})