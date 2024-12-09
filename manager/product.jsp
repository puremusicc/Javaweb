<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:if test="${goodsList==null}">
	<%--	<jsp:forward page="users.do?mth=findAll"></jsp:forward>--%>
	<script type="text/javascript">
		window.location.href="goods.do?mth=findAll";
	</script>
</c:if>
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
		<h2>商品管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>图片</th>
					<th>商品名称</th>
					<th>价格</th>
					<th>类型</th>
					<th>上架</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${goodsList}" var="goods">
					<tr>
						<td class="first w4 c">${goods.gid}</td>
						<td class="first w4 c">
							<img src="${pageContext.request.contextPath}/${goods.pic}" width="80px" height="80px"/>
						</td>
						<td class="first w4 c">${goods.gname}</td>
						<td class="first w4 c">${goods.price}</td>
						<td class="first w4 c">${goods.tid.tname}</td>
						<td class="w1 c">
							<c:choose>
								<c:when test="${goods.state==0}">已下架</c:when>
								<c:when test="${goods.state==1}">已上架</c:when>
							</c:choose>
						</td>
						<td class="w1 c">
							<a href="goods.do?mth=toModify&gid=${goods.gid}">修改</a>
						</td>
					</tr>
				</c:forEach>


			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 中软国际 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>