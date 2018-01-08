// JavaScript Document
$(function(){
    var nav_flag=false; //true为展开  false为收起
    var second_flag=true;
    $("html").bind("click",function(){
        if(second_flag){
            $(".nav_second").css("display","none");
        }
    });

    $("#nav_btn").bind("click",function(){
        $("#nav").stop(true);
        $(".nav_second").css("display","none");
        if(nav_flag){
            nav_flag=false;
            $("#nav").animate({"opacity":"0","width":"0px","height":"0px","top":"30px","left":"30px"},350,function(){
                $("#nav").css({"opacity":"0","width":"0px","height":"0px","top":"30px","left":"30px","display":"block"});
            });
        }else{
            $("#nav").css("display","block");
            $("#nav").animate({"opacity":"1","width":"200px","height":"250px","top":"-220px","left":"-170px"},350,function(){
                $("#nav").css({"opacity":"1","width":"200px","height":"250px","top":"-220px","left":"-170px"});
                nav_flag=true;
            });
        }
    });
//	$("#nav").bind("mouseout",function(){
//		$("#nav").animate({"opacity":"0","width":"0px","height":"0px","top":"30px","left":"30px"},500,function(){
//				$("#nav").css({"opacity":"0","width":"0px","height":"0px","top":"30px","left":"30px"}); flag=true;
//			});
//	})




    $("#nav_main").bind("mouseover",function(){
        if(nav_flag){
            $(".nav_second").css("display","none");
            $("#second_main").css("display","block");
        }
    });

    $("#nav_shoppingcar").bind("mouseover",function(){
        if(nav_flag){
            $(".nav_second").css("display","none");
            $("#second_shoppingcar").css("display","block");
        }
    });

    $(".nav_second").bind("mouseleave",function(){
        if(nav_flag){
            $(".nav_second").css("display","none");
            second_flag=true;
        }
    });
    $(".nav_second").bind("mouseover",function(){
        if(nav_flag){
            second_flag=false;
        }
    });
    $("#userlog").click(function () {
       window.location.href="/toLogin"
    });

    $("#logout").click(function () {
        window.location.href="/logout"
    });

    $("#addGoods").click(function () {
        window.location.href="/addGoods"
    });

    $(".nav_AppIndex").click(function () {
        $.ajax({
            url:"/mainNav",
            type:"post",
            dataType:"text",
            data:"mainNav="+$(this).html(),
            success:function(data){
                data=jQuery.parseJSON(data);
                $("#fieldApp").html("");
                var html="";
                $(data).each(function(i,o){
                    html=html+"<div class='nr'>"+o.aAppname+"</div>";
                });
                $("#fieldApp").html(html);
                $(".nr").click(function(){
                    location.href="/souApp?search="+$(this).html();
                });
            }
        });
    });




});