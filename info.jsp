<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/9 0009
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="col-md-6">
    <table class="table table-bordered ">
        <tr>
            <td>登录名</td>
            <td>${users.loginName}</td>
        </tr>
        <tr>
            <td>昵称</td>
            <td>${users.nickName}</td>
        </tr>
        <tr>
            <td>性别</td>
            <td>${users.sex}</td>
        </tr>
        <tr>
            <td>电话</td>
            <td>${users.phone}</td>
        </tr>
    </table>
</div>

</body>
</html>
