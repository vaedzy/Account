$(function () {
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