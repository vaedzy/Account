<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duzeyu
  Date: 2018/1/6
  Time: 上午9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/common/css/add.css">
    <script src="/common/js/plugin/jquery/jquery-1.9.0.min.js"></script>
    <script src="/js/add/add.js"></script>
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


<div id="context">
    <form action="/addGoods.do" enctype="multipart/form-data" method='post'>
        <div class="nav_second" id="second_main">
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
            <br>
            <br>
            <div id="fieldApp"></div>
        </div>

        <!--  上传图片显示 -->
    <%--    <input type="file" class="myUpload" />
        <img src="../images/close.jpg" class="close hide"/>
        <img src="../images/add.png" class="add "/>
        <img class="show hide"/>--%>

        <!--价格-->
        <!--账号名字-->
        <input type="text" name="gName" placeholder="请起一个名字">
        <!--用户名-->
        <input type="text" name="userName" placeholder="请输入您要共享的账号"><br/>
        <!--密码-->
        <input type="password" name="passWord" placeholder="请输入您要共享的账号密码"><br/>
        <!--简介-->
        <input type="text" name="remark" placeholder="务必要输入一些关于此账号的信息"><br/>
        <!-- 应用id -->
        <input type="hidden" name="appId" id="addId">
        <!-- 选区 -->
        <div id="aQu"></div>
        <!--上传功能-->
        <input type="file" name="file"/><br/>
        <input type="file" name="file"/><br/>
        <input type="file" name="file"/><br/>
        <input type="file" name="file"/><br/>
        <input type="file" name="file"/><br/>
        <input type="file" name="file"/><br/>
        <input type="file" name="file"/><br/>
        <input type="file" name="file"/><br/>
        <input type="file" name="file"/><br/>
        <input type="file" name="file"/><br/>
        ....................
        <!--用户Id-->
        <input type="hidden" name="userId" id="userId" value="${user.id}">
        <input type="submit" value="上传商品">
    </form>
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
    </div>

<div id="nav_btn"></div>   <!-- 导航按钮.... -->

</div>

</body>
</html>
