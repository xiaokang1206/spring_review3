
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--单文件上传--%>
<%--<form action="${pageContext.request.contextPath}/user/quick21" method="post"  enctype="multipart/form-data">
    名称<input type="text" name="username"><br>
    文件<input type="file" name="uploadFile"><br>
    文件2<input type="file" name="uploadFile2"><br>
    <input type="submit" name="提交"><br>
</form>--%>

<%--多文件上传--%>
<form action="${pageContext.request.contextPath}/user/quick22" method="post"  enctype="multipart/form-data">
    名称<input type="text" name="username"><br>
    文件<input type="file" name="uploadFile"><br>
    文件2<input type="file" name="uploadFile"><br>
    <input type="submit" name="提交"><br>
</form>
</body>
</html>
