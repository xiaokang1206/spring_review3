
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>

<script>
    var userList=new Array();
    userList.push({username:"zhangsan",age:18});
    userList.push({username:"lisi",age:28});
    $.ajax({
        type:"post",
        url:"${pageContext.request.contextPath}/user/quick15",
        data:JSON.stringify(userList),
        contentType:"application/json;charset=utf-8"
    });

</script>
<body>

</body>
</html>
