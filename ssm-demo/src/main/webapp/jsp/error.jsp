<<%@ page language="java" contentType="text/html; charset=utf-8"
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
异常信息如下：
${message}
</body>
</html>
