<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
展示接口消息：
${msg}
<br/>
BaseController 说：
${baseInfo}
上传文件:
<form action="${pageContext.request.contextPath}/responseBody/uploadFile" method="post"  enctype="multipart/form-data">
    文件： <input type="file" name="uploadFile"/><br/>
    <input type="submit" value="上传">

</form>
</body>
</html>