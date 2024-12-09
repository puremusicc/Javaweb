<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员${admin.aname}您好，今天是<span id="date"></span>，欢迎回到管理后台。<a href="admin.do?mth=exit">退出</a>
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">小米商城</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em></em><a href="user.jsp">用户管理</a></dd>
				<c:if test="${admin.level==0}">
					<dd><em><a href="admin-add.jsp">新增</a></em><a href="admin.jsp">管理员管理</a></dd>
				</c:if>
				<c:if test="${admin.level==1}">
					<dd><a href="admin.do?mth=toModify&aid=${admin.aid}">修改密码</a></dd>
				</c:if>
				<dt>商品信息</dt>
				<dd><em><a href="productClass-add.jsp">新增</a></em><a href="productClass.jsp">分类管理</a></dd>
				<dd><em><a href="product-add.jsp">新增</a></em><a href="product.jsp">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.jsp">订单管理</a></dd>

			</dl>
		</div>
	</div>
	<div class="main">
		<h2>修改订单</h2>
		<div class="manage">
			<form action="order.do" method="post">
				<input type="hidden" name="mth" value="modifyState">
				<input type="hidden" name="oid" value="${order.oid}">
				<table class="form">
					<tr>
						<td class="field">订单ID：</td>
						<td>${order.oid}</td>
					</tr>
					<tr>
						<td class="field">创建时间：</td>
						<td>${order.createTime}</td>
					</tr>
					<tr>
						<td class="field">订购人账号：</td>
						<td>${order.users.loginName}</td>
					</tr>
					<tr>
						<td class="field">商品编号：</td>
						<td>${order.goods.gid}</td>
					</tr>
					<tr>
						<td class="field">商品价格：</td>
						<td>${order.price}</td>
					</tr>
					<tr>
						<td class="field">商品数量：</td>
						<td>${order.number}</td>
					</tr>
					<tr>
						<td class="field">收货人姓名：</td>
						<td>${order.consigneeName}</td>
					</tr>
					<tr>
						<td class="field">收货人地址：</td>
						<td>${order.consigneeAddress}</td>
					</tr>
					<tr>
						<td class="field">收货人电话：</td>
						<td>${order.consigneePhone}</td>
					</tr>
					<tr>
						<td class="field">订单总价：</td>
						<td>${order.total}</td>
					</tr>
					<tr>
						<td class="field">状态：</td>
						<td>
							<select name="state">
								<option value="1" <c:if test="${order.state==1}">selected</c:if> >未付款</option>
								<option value="2" <c:if test="${order.state==2}">selected</c:if> >已付款</option>
								<option value="3" <c:if test="${order.state==3}">selected</c:if> >已发货</option>
								<option value="4" <c:if test="${order.state==4||order.state==0}">selected</c:if> >已完成</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 中软国际 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>