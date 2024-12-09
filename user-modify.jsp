<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/9 0009
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <style type="text/css">
        .form-group{
            margin: 2px;
        }
    </style>
</head>
<body>
<div class="col-md-6">
    <form action="users" method="post" class="form-horizontal" style="margin-top:5px;">
        <input type="hidden" name="mth" value="userModify">
        <input type="hidden" name="userId" value="${users.userId}">
        <input type="hidden" name="state" value="${users.state}">


            <div class="form-group">
                <label for="username" class="col-sm-3 control-label">用户名</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" value="${users.loginName}"
                           name="loginName" id="username" placeholder="请输入用户名" readonly>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-3 control-label">密码</label>
                <div class="col-sm-7">
                    <input type="password" class="form-control" value="${users.password}"
                           name="pwd" id="inputPassword3" placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-3 control-label">电话</label>
                <div class="col-sm-7">
                    <input type="text" name="phone" value="${users.phone}" class="form-control"
                           id="inputEmail3" placeholder="手机号">
                </div>
            </div>
            <div class="form-group">
                <label for="usercaption" class="col-sm-3 control-label">昵称</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" value="${users.nickName}"
                           id="usercaption" name="nick" placeholder="昵称">
                </div>
            </div>
            <div class="form-group opt">
                <label for="inlineRadio1" class="col-sm-3 control-label">性别</label>
                <div class="col-sm-7">
                    <label class="radio-inline">
                        <input type="radio" name="sex" id="inlineRadio1"
                               value="男" <c:if test="${users.sex eq \"男\"}"> checked</c:if> > 男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="sex" id="inlineRadio2"
                               value="女"  <c:if test="${users.sex eq \"女\"}"> checked</c:if>> 女
                    </label>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit"  width="100" value="保存" name="submit" border="0"
                           style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
                </div>
            </div>
    </form>
</div>
</body>
</html>
