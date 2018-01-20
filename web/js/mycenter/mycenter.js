$(function() {
    var nav_flag = false; //true为展开  false为关闭

    $("#nav_btn").bind("click", function () {
        $("#nav").stop(true);
        if (nav_flag) {
            nav_flag = false;
            $("#nav").animate({
                "opacity": "0",
                "width": "0px",
                "height": "0px",
                "top": "30px",
                "left": "30px"
            }, 350, function () {
                $("#nav").css({
                    "opacity": "0",
                    "width": "0px",
                    "height": "0px",
                    "top": "30px",
                    "left": "30px",
                    "display": "block"
                });
            });
        } else {
            $("#nav").css("display", "block");
            $("#nav").animate({
                "opacity": "1",
                "width": "200px",
                "height": "250px",
                "top": "-220px",
                "left": "-170px"
            }, 350, function () {
                $("#nav").css({"opacity": "1", "width": "200px", "height": "250px", "top": "-220px", "left": "-170px"});
                nav_flag = true;
            });
        }
    });


    $("#userlog").click(function () {
        window.location.href = "/toLogin"
    });

    $("#logout").click(function () {
        window.location.href = "/logout"
    });

    $("#addGoods").click(function () {
        window.location.href="/addGoods"
    });


    $("#search_btn").bind("click", function () {
        $.ajax({
            url: "/souApp",
            type: "post",
            dataType: "text",
            data: "search=" + $("#search").val(),
            success: function (data) {

            }
        })

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

    $("#left").css("height",window.screen.availHeight-187);

    $("#center_btn").css({"margin-left":"10px"});
    $("#center_btn").click(function(){
        $(".content").css("display","none");
        $(".option").css({"margin-left":"0px"});
        $("#center").css("display","block");
        $("#center_btn").css({"margin-left":"10px"});
    });
    $("#autonym_btn").click(function(){
        $(".content").css("display","none");
        $(".option").css({"margin-left":"0px"});
        $("#autonym").css("display","block");
        $("#autonym_btn").css({"margin-left":"10px"});
    });
    $("#pledge_btn").click(function(){
        $(".content").css("display","none");
        $(".option").css({"margin-left":"0px"});
        $("#pledge").css("display","block");
        $("#pledge_btn").css({"margin-left":"10px"});
    });
    $("#order_btn").click(function(){
        $(".content").css("display","none");
        $(".option").css({"margin-left":"0px"});
        $("#order").css("display","block");
        $("#order_btn").css({"margin-left":"10px"});
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

})