<%--
  Created by IntelliJ IDEA.
  User: duzeyu
  Date: 2017/12/19
  Time: 下午7:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>register</title>
    <link rel="stylesheet" type="text/css" href="/common/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/common/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="/common/css/component.css" />
    <link rel="stylesheet" type="text/css" href="/common/css/register.css" />
    <!--[if IE]>
    <script src="${ctx}/js/plugin/html5.js"></script>
    <![endif]-->
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>欢迎您</h3>
                    <div class="input_outer" id="phone_outer">
                        <span class="u_user"></span>
                        <input name="logname" id="username" class="text" max="11" maxlength="11" style="color: #FFFFFF !important" type="text" placeholder="请输入用户名">
                    </div>
                <div class="input_outer" id="code_outer">
                    <span class="us_uer"></span>
                    <input name="logpass" id="code" class="text" max="3" maxlength="3" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="text" placeholder="同意本网站条款后输入我同意">
                </div>
                <div id="terms">阅读《服务条款》</div>

                <div class="mb2" id="register">注册</div>

                <div id="terms_context">
                    <div id="terms_close"></div>
                    <div id="context"></div>
                </div>

            </div>
        </div>
    </div>
</div><!-- /container -->
<%@include file="/common/jsp/taglibs.jsp" %>
<script src="${ctx}/js/register/register.js"></script>

</body>
</html>
