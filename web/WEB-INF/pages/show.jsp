<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/1
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>商品展示</title>
    <link rel="stylesheet" type="text/css" href="common/css/show.css">
    <script src="common/js/plugin/jquery/jquery-1.9.0.min.js"></script>
    <script src="js/show/show.js"></script>
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
<!-- 主要内容 -->


<div id="context">
    <div id="nav_app">

    </div>
    <div id="conditions">
        <div id="conditions_title"></div>
        <%-- 应用名 --%>
        <select name="appName" id="appName">
            <c:forEach var="a" items="${appNameList}">
                <option value="${a.appId}">${a.appName}</option>
            </c:forEach>
        </select>

        <%-- 大区 --%>
        <select name="appQu" id="appName">
            <c:forEach var="q" items="${appQuList}">
                <option value="${q.appId}">${q.quName}</option>
            </c:forEach>
        </select>


    </div>
    <div id="goodsinfo">
        <%--<c:forEach var="g" items="${goodsInfoList}">--%>
            <div class="goods_box">
                <div class="app_img">
                    <%-- 这里放一张截图 --%>
                </div>
                <div class="app_text">
                    <%-- 这里放所有商品信息  --%>
                </div>
            </div>
        <%--</c:forEach>--%>
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
                <div id="logout">
                    <span>退出登录</span>
                </div>
            </c:if>
        </div>
        <div id="nav_shoppingcar" class="nav_on_box">购物车</div>
    </div>

    <div id="nav_btn"></div>   <!-- 导航按钮 -->
</div>

</body>
</html>
