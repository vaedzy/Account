$(function () {
    $("#pay").click(function () {
        $.ajax({
           url:"/Seckill",
           type:"post",
           dataType:"text",
           data:"gId="+$("#gId").val(),
           success:function(data){

           }
        });
    });
})