<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!--这里一定要这样声明，然后使用c:url 标签才能生效-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script type="application/javascript" src="<c:url value='/js/readme.js'/>"></script>
</head>
<body>
展示接口消息：
${msg}
<br/>
BaseController 说：
${baseInfo}
上传文件:
<form action="${pageContext.request.contextPath}/responseBody/uploadFile" method="post" enctype="multipart/form-data">
    文件： <input type="file" name="uploadFile"/><br/>
    <input type="submit" value="上传">

</form>
展示跨域请求ajax:
<br/>
请输入网址：<input type="text" style="width: 100%;" id="myUrl">
<input type="button" id="myButton" value="点击我发送AJAX请求"/>
<div id="result"></div>
</body>
</html>