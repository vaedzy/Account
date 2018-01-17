<%@ page import="com.account.bean.Person" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duzeyu
  Date: 2017/12/18
  Time: 下午10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account-信用无价</title>
    <link rel="stylesheet" type="text/css" href="common/css/index.css">
    <script src="common/js/plugin/jquery/jquery-1.9.0.min.js"></script>
    <script src="js/index/index.js"></script>
    <!--[if IE]>
    <script src="${ctx}/js/plugin/html5.js"></script>
    <![endif]-->
</head>
<body>

<div></div>


<div id="content">
    <div id="logo">LOGO</div>
    <div id="search_box">
        <form action="/souApp" method="get">
            <input type="text" autocomplete="off" id="search" name="search" placeholder="请输入关键字">
            <input type="submit" id="search_btn" value="GO">
        </form>
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

        <c:if test="${user==null?false:true}">
            <div id="addGoods" class="nav_on_box">添加商品</div>
            <div id="logout" class="nav_on_box">退出登录</div>
        </c:if>
    </div>

    <!-- 二级导航 -->
    <div class="nav_second" id="second_shoppingcar">
    </div>
    <div class="nav_second" id="second_main">
        <div style="float: left; background: #3399CC; width: 785px;padding-left:5px; height: 30px;border-bottom: 2px solid #6666CC; border-radius:8px 8px 0 0;">
            <div class="nav_AppIndex">a</div>
            <div class="nav_AppIndex">b</div>
            <div class="nav_AppIndex">c</div>
            <div class="nav_AppIndex">d</div>
            <div class="nav_AppIndex">e</div>
            <div class="nav_AppIndex">f</div>
            <div class="nav_AppIndex">g</div>
            <div class="nav_AppIndex">h</div>
            <div class="nav_AppIndex">i</div>
            <div class="nav_AppIndex">j</div>
            <div class="nav_AppIndex">k</div>
            <div class="nav_AppIndex">l</div>
            <div class="nav_AppIndex">m</div>
            <div class="nav_AppIndex">n</div>
            <div class="nav_AppIndex">o</div>
            <div class="nav_AppIndex">p</div>
            <div class="nav_AppIndex">q</div>
            <div class="nav_AppIndex">r</div>
            <div class="nav_AppIndex">s</div>
            <div class="nav_AppIndex">t</div>
            <div class="nav_AppIndex">u</div>
            <div class="nav_AppIndex">v</div>
            <div class="nav_AppIndex">w</div>
            <div class="nav_AppIndex">x</div>
            <div class="nav_AppIndex">y</div>
            <div class="nav_AppIndex">z</div>
        </div>
        <div id="fieldApp"></div>
    </div>

    <div id="nav_btn"></div>   <!-- 导航按钮.... -->

</div>
</body>
</html>

