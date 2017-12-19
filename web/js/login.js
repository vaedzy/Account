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
                        if(data){
                            $("#phone").val("该手机号不合法");
                        }
                    }
                });
            }else{
                $("#phone").val("你电话输错了");
            }
        }
    });

    $("#login").click(function () {
            if(){

            }else {
                alert("别瞎JB填");
            }
        }
    );

});