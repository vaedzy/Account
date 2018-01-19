<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duzeyu
  Date: 2018/1/18
  Time: 下午3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

<!--获取后台返回的内容-->
${currency}

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

    <div id="nav_btn"></div>   <!-- 导航按钮 -->
</div>
</body>
<script src="/js/show/show.js"></script>
</html>
