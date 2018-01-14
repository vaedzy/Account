<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/12
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/common/css/mycenter.css">
    <script src="/common/js/plugin/jquery/jquery-1.9.0.min.js"></script>
    <script src="/js/mycenter/mycenter.js"></script>
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
    <form action="">
        <div id="certification">
            <div class="input_box">
                
                <input type="text" maxlength="18" class="input" name="idcard" id="idcard" placeholder="请输入你的身份证号码">
            </div>
            <div id="up_img_box">
                <div class="up_img">
                    <input type="file" name="file" class="myUpload" />
                    <img src="common/img/upload.jpg" class="add "/>
                    <img class="show hide"/>
                </div>
                <div class="up_img">
                    <input type="file" name="file" class="myUpload" />
                    <img src="common/img/upload.jpg" class="add "/>
                    <img class="show hide"/>
                    <input type="hidden" name="PersonId" id="userId" value="${user.id}">
                </div>
            </div>
            <div class="input_box" style="border: none; padding: 0px">
            <input type="submit" id="upload" value="上传个人信息">
            </div>
        </div>
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
        <div id="nav_main" class="nav_on_box">主导航</div>
        <div id="addGoods" class="nav_on_box">添加商品</div>
    </div>
    <div id="nav_btn"></div>   <!-- 导航按钮.... -->
</div>
</body>
</html>
