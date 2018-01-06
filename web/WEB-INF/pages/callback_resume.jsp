<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Cache-Control", content="no-cache">  
<meta http-equiv="Progma" content="no-cache">
<title>上传附件结果</title>
    <script type="text/javascript">
		var code='${code}';
		console.log(window);
		window.parent.resume_uploadCallback(code,jsonStr);
    </script>
</head>
<body>
</body>
</html>