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
    <title>个人中心</title>
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



<div id="left">
    <div class="option" id="center_btn">
        个人中心
    </div>
    <div class="option" id="autonym_btn">
        实名认证
    </div>
    <div class="option" id="pledge_btn">
        押金管理
    </div>
</div>
<div class="content" id="center">
    <form>
        <div class="info">
            <div class="text">昵称：</div>
            <div class="input_box">
               <input id="pNickname" class="input" type="text" name="pNickname" placeholder="请输入你的昵称">
            </div>
        </div>

        <div class="info">
            <div class="text">性别：</div>
            <div class="input_box">
                <select id="pSex" class="input" type="text" name="pSex">
                    <option value="1">男</option>
                    <option value="0">女</option>
                </select>
            </div>
        </div>

        <div class="info">
            <div class="text">电话号码：</div>
            <div class="input_box">
                <input id="pPhone" class="input" type="text" name="pPhone" value="12312312312" disabled="disabled">
            </div>
        </div>

        <div class="info">
            <div class="text">电子邮箱：</div>
            <div class="input_box">
                <input id="pEmail" class="input" type="text" name="pEmail" placeholder="请输入你的电子邮箱">
            </div>
        </div>


        <div style="width: 330px;height: 40px;margin: 20px auto;">
            <input type="submit" class="upload" value="保存">
        </div>
    </form>
</div>
<div class="content" id="pledge">
    asdssss
</div>

<div class="content" id="autonym">
    <form action="">
        <div id="certification">
            <div class="info">
                <div class="text">真实姓名：</div>
                <div class="input_box">
                    <input type="text" maxlength="18" class="input" name="pFullname" id="pFullname" placeholder="请输入你的真实姓名">
                </div>
            </div>
            <div class="info">
                <div class="text">身份证号：</div>
                <div class="input_box">
                    <input type="text" maxlength="18" class="input" name="idcard" id="idcard" placeholder="请输入你的身份证号码">
                </div>
            </div>
            <div id="up_img_box">
                <div class="up_img">
                    <input type="file" name="file" class="myUpload" />
                    <img src="../../common/img/upload.jpg" class="add "/>
                    <img class="show hide"/>
                </div>
                <div class="up_img">
                    <input type="file" name="file" class="myUpload" />
                    <img src="../../common/img/upload.jpg" class="add "/>
                    <img class="show hide"/>
                </div>
            </div>
            <div style="width: 330px;height: 40px;margin: 20px auto;">
                <input type="submit" class="upload" value="保存">
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
</body>
</html>
