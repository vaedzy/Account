<%--
  Created by IntelliJ IDEA.
  User: duzeyu
  Date: 2017/12/19
  Time: 下午7:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <!--[if IE]>
    <script src="js/html5.js"></script>
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
                        <input name="logname" id="phone" class="text" max="11" maxlength="11" style="color: #FFFFFF !important" type="text" placeholder="请输入手机号">
                    </div>
                    <div class="input_outer" id="code_outer">
                        <span class="us_uer"></span>
                        <input name="logpass" id="code" class="text" max="4" maxlength="4" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="text" placeholder="请输入验证码">
                    </div>
                    <div class="mb2" id="login">登录</div>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="js/TweenLite.min.js"></script>
<script src="js/EasePack.min.js"></script>
<script src="js/rAF.js"></script>
<script src="js/demo-1.js"></script>
<script src="js/jquery-1.6.4.min.js"></script>
<script src="js/login.js"></script>


</body>
</html>
