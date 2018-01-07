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
</head>
<body>
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



    <input type="submit" value="上传商品">
</form>
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
        <div id="nav_main" class="nav_on_box">主导航</div>
    </div>

<div id="nav_btn"></div>   <!-- 导航按钮.... -->

</div>
<%--<form action="/addGoods.do" enctype="multipart/form-data" method='post'>--%>
    <%--<input name="userId" type="text">--%>
    <%--<input name="userName" type="text">--%>
<%--<<<<<<< HEAD--%>
    <%--<label>头 像1</label><input type="file" name="file"/><br/>--%>
    <%--<label>头 像2</label><input type="file" name="file"/><br/>--%>
<%--=======--%>
    <%--<input type='hidden' id='atLinkId' name='entity.atLinkId' value='1'>--%>
    <%--<input type='hidden' id='atLinkTable' name='entity.atLinkTable' value='AC_PERSON'>--%>
    <%--<label>头 像1</label><input type="file" name="file"/><br/>--%>
    <%--<label>头 像2</label><input type="file" name="file"/><br/>--%>
<%-->>>>>>> origin/master--%>
    <%--<input type="submit" value="测试">--%>
<%--</form>--%>

<%--<form action="/fildUpload.do" enctype="multipart/form-data">--%>
    <%--<label>头 像1</label><input type="file" name="file"/><br/>--%>
    <%--<input type="submit" value="提交">--%>
<%--</form>--%>
</body>
</html>
