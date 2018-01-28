<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/10
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>单个商品展示页</title>
    <link rel="stylesheet" type="text/css" href="/common/css/goodsShow.css">
    <script src="/common/js/plugin/jquery/jquery-1.9.0.min.js"></script>
    <script src="/js/goodsShow/goodsShow.js"></script>
    <script type="text/javascript" src="/common/js/plugin/jquery/jquery-clock-timepicker.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('.time').clockTimePicker({});
        });
    </script>
</head>
<body>
<!-- 顶部 -->
<div id="top">
    <div id="logo">LOGO</div>
    <div id="search_border">
        <input type="text" autocomplete="off" name="search" id="search" placeholder="请输入应用名..."/>
        <div id="search_btn"></div>
    </div>
</div>


<div id="content">

    <div id="content_nav">
        ${appName}>>
        ${quName}
    </div>
    <div id="goods_photo">
        <img width="100%" height="100%" id="gphoto" src="${goodsInfo.gphotourl1}">
    </div>
    <div id="goods_right">
        <div id="goods_wz">
            ${goodsInfo.gName}<br><br>
            ￥${goodsInfo.gprice}
        </div>
        <div id="goods_info">
            <div id="goods_info_left">
                <div class="wz">游戏名:</div>
                <div class="wz">大区:</div>
                <div class="wz">介绍:</div>

            </div>

            <div id="goods_info_right">
                <div class="wz">${appName}</div>
               <input type="text" style="display: none" id="gId" name="gId" value="${goodsInfo.gId}" />
                <div class="wz"> ${quName}</div>
                <div class="wz"> ${goodsInfo.remark}</div>
                开始: <input class="time" name="startTime" type="text" value="00:00" onchange="console.log('Time changed')" />
                结束: <input class="time" name="terminalTime" type="text" value="23:59" onchange="console.log('Time changed')" />
            </div>


            <input type="button" id="pay" value="立即下单"/>
        </div>

    </div>
    <div id="photos">
        <c:if test="${goodsInfo.gphotourl1 != null}">
        <div style="width: 50px;height: 50px " class="photo">
            <img width="100%" height="100%" class="img" src="${goodsInfo.gphotourl1}">
        </div>
        </c:if>
        <c:if test="${goodsInfo.gphotourl2 != null}">
            <div style="width: 50px;height: 50px " class="photo">
                <img width="100%" height="100%" class="img" src="${goodsInfo.gphotourl2}">
            </div>
        </c:if>
        <c:if test="${goodsInfo.gphotourl3 != null}">
            <div style="width: 50px;height: 50px " class="photo">
                <img width="100%" height="100%" class="img" src="${goodsInfo.gphotourl3}">
            </div>
        </c:if>
        <c:if test="${goodsInfo.gphotourl4 != null}">
            <div style="width: 50px;height: 50px " class="photo">
                <img width="100%" height="100%" class="img" src="${goodsInfo.gphotourl4}">
            </div>
        </c:if>
        <c:if test="${goodsInfo.gphotourl5 != null}">
            <div style="width: 50px;height: 50px " class="photo">
                <img width="100%" height="100%" class="img" src="${goodsInfo.gphotourl5}">
            </div>
        </c:if>
        <c:if test="${goodsInfo.gphotourl6 != null}">
            <div style="width: 50px;height: 50px " class="photo">
                <img width="100%" height="100%" class="img" src="${goodsInfo.gphotourl6}">
            </div>
        </c:if>
        <c:if test="${goodsInfo.gphotourl7 != null}">
            <div style="width: 50px;height: 50px " class="photo">
                <img width="100%" height="100%" class="img" src="${goodsInfo.gphotourl7}">
            </div>
        </c:if>
        <c:if test="${goodsInfo.gphotourl8 != null}">
            <div style="width: 50px;height: 50px " class="photo">
                <img width="100%" height="100%" class="img" src="${goodsInfo.gphotourl8}">
            </div>
        </c:if>
        <c:if test="${goodsInfo.gphotourl9 != null}">
            <div style="width: 50px;height: 50px " class="photo">
                <img width="100%" height="100%" class="img" src="${goodsInfo.gphotourl9}">
            </div>
        </c:if>
        <c:if test="${goodsInfo.gphotourl10 != null}">
            <div style="width: 50px;height: 50px " class="photo">
                <img width="100%" height="100%" class="img" src="${goodsInfo.gphotourl10}">
            </div>
        </c:if>
    </div>
</div>

<div id="nav_box">


    <!-- 一级导航 -->
    <div id="nav">
        <div id="user_box">
            <c:if test="${user==null?true:false}">
                <span id="userlog">登录</span>
            </c:if>
            <c:if test="${user==null?false:true}">
                <span id="uuser">尊敬的:${user.pFullname}</span>
            </c:if>
        </div>
        <c:if test="${user==null?false:true}">
            <div id="addGoods" class="nav_on_box">添加商品</div>
            <div id="logout" class="nav_on_box">退出登录</div>
        </c:if>
    </div>
    <div id="nav_btn"></div>   <!-- 导航按钮.... -->
</div>
</body>
</html>
