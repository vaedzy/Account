$(function(){
    var phonezz=/^1[345789]\d{9}$/;
    $("#phone").bind("input propertychange",function(){
        if($("#phone").val().length==11){
            if(phonezz.test($("#code").val())){
                $.ajax({
                    url:"/getCode",
                    type:"post",
                    dataType:"text",
                    data:"phone="+$("#phone").val(),
                    success:function(data){
                        if(!data){
                            $("#phone_outer").css("border","rgba(0,255,0,0.2)");
                        }else{
                            $("#phone_outer").css("border","rgba(255,0,0,0.2)");
                        }
                    }
                });
            }else{
                $("#phone_outer").css("border","rgba(255,0,0,0.7)");
            }
        }
    });

    $("#login").click(function () {
            if(phonezz.test($("#code").val())){
                $.ajax({
                    url:"/getCode",
                    type:"post",
                    dataType:"text",
                    data:"phone="+$("#phone").val()+"&code="+$("#code").val(),
                    success:function(data){
                        if(data=='false'){
                            $("#code_outer").css("border","rgba(255,0,0,0.2)");
                            $("#code").val("");
                        }
                    }
                });
            }else {
                $("#phone_outer").css("border","rgba(255,0,0,0.7)");
            }
        }
    );

});