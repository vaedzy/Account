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
    <link rel="stylesheet" type="text/css" href="/common/css/show/show.css">
    <link href="/common/css/show/reset.css" rel="stylesheet" type="text/css" />
    <link href="/common/css/show/font-awesome.css" rel="stylesheet" type="text/css" />
    <link href="/common/css/show/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/show/modernizr.custom.js"></script>
    <script src="/common/js/plugin/jquery/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="/common/js/plugin/jquery/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="/common/js/plugin/jquery/jquery.contentcarousel.js"></script>
    <script type="text/javascript">
        $('#latest-news-container').contentcarousel();;
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
<!-- 主要内容 -->


<div id="context">
    <div id="conditions">
        <div id="conditions_title">条件查找</div>
        <%-- 应用名 --%>
        ${appName.appName}
        <%-- 大区 --%>
        <select name="appQu" id="quName">
            <c:forEach var="q" items="${appQuList}">
                <%--<option value="${q.appId}">${q.quName}</option>--%>
                <option>${q.quName}</option>
            </c:forEach>
        </select>


    </div>
    <%--<div id="goodsinfo">--%>
        <%--<c:forEach var="g" items="${goodsInfoList}">--%>
            <%--<div class="goods_box" id="${g.gId}">--%>
                <%--<div class="app_img">--%>
                    <%--&lt;%&ndash; 这里放一张截图 &ndash;%&gt;--%>
                    <%--<img width="100%" height="100%" src="${g.gphotourl1}">--%>
                <%--</div>--%>
                <%--<div class="app_text">--%>
                   <%--账号介绍：--%>
                    <%--<br/>--%>
                        <%--${g.remark}--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</c:forEach>--%>
    <%--</div>--%>

    <div id="goodsinfo">
        <div id="latest-news-container" class="latest-news-container">
        <c:forEach var="g" items="${goodsInfoList}">
                    <div class="single-item single-item-1">
                        <div class="single-item-main">
                            <div class="single-icon">
                                <ul class="grid cs-style-5">
                                    <li>
                                        <figure>
                                                <%-- 这里放一张截图 --%>
                                                <img width="100%" height="100%" src="${g.gphotourl1}">
                                            <figcaption>
                                                <div class="goods_box" id="${g.gId}">
                                                    <div class="app_text">
                                                        账号介绍：
                                                        <br/>
                                                            ${g.remark}
                                                    </div>
                                                        <div class="app_text">
                                                            价格：
                                                            <br/>
                                                            ${g.gprice}/小时
                                                    </div>
                                                </div>
                                            </figcaption>
                                        </figure>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
        </c:forEach>
        <div id="clear"></div>
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

    <div id="nav_btn"></div>   <!-- 导航按钮 -->
</div>

</body>
<script src="/js/show/show.js"></script>
</html>
