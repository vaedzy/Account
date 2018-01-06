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
</head>
<body>
<form action="/addGoods.do" enctype="multipart/form-data" method='post'>
    <input name="userId" type="text">
    <input name="userName" type="text">
    <label>头 像1</label><input type="file" name="gphotourl1"/><br/>
    <label>头 像2</label><input type="file" name="gphotourl2"/><br/>
    <input type="submit" value="测试">
</form>
</body>
</html>
