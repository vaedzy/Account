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
        ${appName}
        ${appQu}
    </div>
    <div id="goods_photo">
        <img src="${goodsInfo.gphotourl1}">
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
               <input type="text" style="display: none" id="gId" name="gId" value="${goodsInfo.gId}" >
                <div class="wz"> ${appQu}</div>
                <div class="wz"> ${goodsInfo.remark}</div>
            </div>
            <input type="button" id="pay" value="立即购买">
        </input>
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
        <div id="nav_main" class="nav_on_box">主导航</div>
        <div id="addGoods" class="nav_on_box">添加商品</div>
        <c:if test="${user==null?false:true}">
            <div id="logout" class="nav_on_box">退出登录</div>
        </c:if>
    </div>
    <div id="nav_btn"></div>   <!-- 导航按钮.... -->
</div>
</div>
</body>
</html>
