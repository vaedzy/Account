$(function(){
    $("#terms_context").css("display","none");
    $("#terms").click(function () {
        $("#terms_context").fadeIn();
    })
    $("#terms_close").click(function () {
        $("#terms_context").fadeOut();
    })
    $("#register").click(function () {
                $.ajax({
                    url:"/register.do",
                    type:"post",
                    dataType:"text",
                    data:"username="+$("#username").val()+"&code="+$("#code").val(),
                    success:function(data){
                        if(data=='errorCode'){
                            $("#code_outer").css("border","rgba(255,0,0,0.2) 2px solid");
                            $("#code").val("");
                        }else if(data=='errorUser'){
                            $("#phone_outer").css("border","rgba(255,0,0,0.2) 2px solid");
                        }else if(data=='login'){
                            location.href='/index.jsp';
                        }else if (data=='getDetails'){
                            location.href='/getDetails';
                        }
                    }
                });
        }
    );
});