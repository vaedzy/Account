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



    $("#pay").click(function () {
        $.ajax({
           url:"/Seckill",
           type:"post",
           dataType:"text",
           data:"gId="+$("#gId").val(),
           success:function(data){
               if (data=='noLogin'){
                   location.href='/toLogin';
               }else if (data=='true'){
                   location.href='';
               }else if (data=='false'){
                   location.href='';
               }
           }
        });
    });
})