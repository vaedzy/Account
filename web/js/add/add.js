// JavaScript Document
$(function(){
	var nav_flag=false; //true为展开  false为关闭
	
	$("#nav_btn").bind("click",function(){
		$("#nav").stop(true);
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


    /**
     *  点击字母搜索
     */
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
                    html=html+"<div class='nr' id="+o.aAppId+">"+o.aAppname+"</div>";
                });
                $("#fieldApp").html(html);
                $(".nr").click(function(){
                    $(this).css("color","blue");
                    $("#addId").val($(this).attr("id"));
                    $.ajax({
                        url:"/searchTypeAndAppName",
                        type:"post",
                        dataType:"text",
                        data:"AppId="+$(this).attr("id"),
                        success:function(data){
                            data=jQuery.parseJSON(data);
                            var htm='';
                            $(data).each(function(i,o){
                            htm=htm+" <option value='"+o.quId+"'>"+o.quName+"</option>";
                            });
                            $("#aQu").css("display","block");
                            $("#aQu").append("<div class='text'>大区：</div><div class='input_box'><select class='input' name='quId'>"+htm+"</select></div>");
                        }
                    });
                    //location.href="/souApp?search="+$(this).html();
                });
            }
        });
    });


    $(document).ready(function()
    {
        //点击上传时实时显示图片
        $(".myUpload").change(function()
        {
            var src=getObjectURL(this.files[0]);//获取上传文件的路径
            //$(".close").removeClass('hide');
            //$(".add").addClass('hide');
            $(this).parent().append("<img src='"+src+"' class='show'>");
            // $(".show").removeClass('hide');
            // $(this.id: last-child).attr('src',src);//把路径赋值给img标签
        });

        //点击关闭按钮时恢复初始状态
        $(".close").click(function()
        {
            $(".close").addClass('hide');
            $(".add").removeClass('hide');
            $(".show").addClass('hide');
        });
    });

    //获取上传文件的url
    function getObjectURL(file)
    {
        var url = null;
        if (window.createObjectURL != undefined)
        {
            url = window.createObjectURL(file);
        }
        else if (window.URL != undefined)
        {
            url = window.URL.createObjectURL(file);
        }
        else if (window.webkitURL != undefined)
        {
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    };

    $("#userlog").click(function () {
        window.location.href="/toLogin"
    });

    $("#logout").click(function () {
        window.location.href="/logout"
    });

    $("#addGoods").click(function () {
        window.location.href="/addGoods"
    });
})