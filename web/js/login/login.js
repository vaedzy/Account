$(function(){
    var phonezz=/^1[345789]\d{9}$/;
    $("#phone").bind("input propertychange",function(){
        if($("#phone").val().length==11){
            if(phonezz.test($("#phone").val())){
                $.ajax({
                    url:"/getCode",
                    type:"post",
                    dataType:"text",
                    data:"phone="+$("#phone").val(),
                    success:function(data){
                        if(data){
                            $("#phone_outer").css("border","rgba(0,255,0,0.2) 2px solid");
                        }else{
                            $("#phone_outer").css("border","rgba(255,0,0,0.2) 2px solid");
                        }
                    }
                });
            }else{
                $("#phone_outer").css("border","rgba(255,0,0,0.2) 2px solid");
            }
        }
    });

    $("#login").click(function () {
            if(phonezz.test($("#phone").val())){
                $.ajax({
                    url:"/login",
                    type:"post",
                    dataType:"text",
                    data:"phone="+$("#phone").val()+"&code="+$("#code").val(),
                    success:function(data){
                        if(data=='errorCode'){
                            $("#code_outer").css("border","rgba(255,0,0,0.2) 2px solid");
                            $("#code").val("");
                        }else if(data=='errorPhone'){
                            $("#phone_outer").css("border","rgba(255,0,0,0.2) 2px solid");
                        }else if(data=='login'){
                            location.href='/index.jsp';
                        }else if(data=='register'){
                            location.href='/register.jsp';
                        }

                    }
                });
            }else {
                $("#phone_outer").css("border","rgba(255,0,0,0.2) 2px solid");
            }
        }
    );

});