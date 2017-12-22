<%@ page import="com.account.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: duzeyu
  Date: 2017/12/18
  Time: 下午10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
    <link rel="stylesheet" type="text/css" href="common/css/search.css">
    <script src="common/js/plugin/jquery/jquery-1.9.0.min.js"></script>
    <script src="js/index/search.js"></script>
</head>
<body>

<div></div>


<div id="content">
    <div id="logo">LOGO</div>
    <div id="search_box">
        <form action="#" method="post">
            <input type="text" id="search" name="search" placeholder="请输入关键字">
            <input type="submit" id="search_btn" value="GO">
        </form>
    </div>
</div>

<div id="nav_box">
    <div id="nav">
        <div id="user_box">
            <span>登录</span>
        </div>
        <div id="user_box">
            <span>用户名</span>
        </div>
    </div>
    <div id="nav_btn">+</div>
</div>
</body>
</html>

