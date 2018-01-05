// JavaScript Document
$(function(){
	var nav_flag=false; //true为展开  false为关闭
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


    $("#userlog").click(function () {
        window.location.href="/toLogin"
    });

    $("#logout").click(function () {
        window.location.href="/logout"
    });


	$("#search_btn").bind("click",function(){
		$.ajax({
			url:"/souApp",
			type:"post",
			dataType:"text",
			data:"search="+$("#search").val(),
			success:function(data){
					
			}
		})
			
	});


    $(".goods_box").bind("click",function(){
        href.location="/show.do?gId="+$(this).attr("id");
        // $.ajax({
        //     url:"/show.do",
        //     type:"post",
        //     dataType:"text",
        //     data:"gId="+$(this).attr("id")
        // })
    });

    $("#appName").bind("change",function(){
        alert($("#appName").val());
        $.ajax({
            url:"/souApp",
            type:"post",
            dataType:"text",
            data:"search="+$("#appName").val(),
            success:function(data){
                data=jQuery.parseJSON(data);
            	//清空当前页面商品
                $("#goodsinfo").html("");
				//重新加载页面商品
                $(data).each(function(i,o){
                    $("#goodsinfo").append("<div class='goods_box' id='"+o.gId+"'><div class='app_img'><img src='/"+o.gphotourl1+"'></div><div class='app_text'><br/>"+o.remark+"</div></div>");
                });
            }
        })
    });

    $("#quName").bind("change",function(){
        alert($("#quName").val());
        $.ajax({
            url:"/souAppQu",
            type:"post",
            dataType:"text",
            data:"quName="+$("#quName").val(),
            success:function(data){
                data=jQuery.parseJSON(data);
                //清空当前页面商品
                $("#goodsinfo").html("");
                //重新加载页面商品
                $(data).each(function(i,o){
                    $("#goodsinfo").append("<div class='goods_box' id='"+o.gId+"'><div class='app_img'><img src='/"+o.gphotourl1+"'></div><div class='app_text'><br/>"+o.remark+"</div></div>");
                });
            }
        })
    });

})