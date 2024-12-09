<%@ page import="com.csi.pojo.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>WEB01</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</head>
	<c:if test="${t1==null||t2==null}">
		<jsp:forward page="index"></jsp:forward>
	</c:if>
	<body>
		<div class="container">

			<!--
            	时间：2015-12-30
            	描述：菜单栏
            -->
			<div class="container">
				<div class="col-md-4">
					<img src="img/logo2.png" />
				</div>
				<div class="col-md-5">
					<img src="img/header.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<c:if test="${users==null}">
							<li><a href="login.jsp">登录</a></li>
							<li><a href="register.jsp">注册</a></li>
						</c:if>
						<c:if test="${users!=null}">
							<li><a href="userinfo.jsp">${users.nickName}</a></li>
							<li><a href="users?mth=exit">注销</a></li>
						</c:if>

						<li><a href="cart?mth=toCart">购物车</a></li>
					</ol>
				</div>
			</div>
			<!--
            	时间：2015-12-30
            	描述：导航条
            -->
			<div class="container">
				<nav class="navbar navbar-inverse">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
									data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li><a href="GoodsServlet?mth=findByTid&tid=1">小米手机</a></li>
								<li><a href="GoodsServlet?mth=findByTid&tid=2">红米手机</a></li>
								<li><a href="GoodsServlet?mth=findByTid&tid=3">MATE</a></li>
								<li><a href="GoodsServlet?mth=findByTid&tid=4">黑鲨</a></li>
								<li><a href="GoodsServlet?mth=findByTid&tid=5">小米MAX</a></li>
							</ul>
							<form action="GoodsServlet" class="navbar-form navbar-right" role="search">
								<div class="form-group">
									<input type="text" name="gname" class="form-control" placeholder="请输入搜索的商品名称">
								</div>
								<input type="hidden" name="mth" value="search">
								<button type="submit" class="btn btn-default">搜索</button>
							</form>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container -->
				</nav>
			</div>

			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：轮播条
            -->
			<div>
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="img/1.jpg">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="img/2.jpg">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="img/3.jpg">
							<div class="carousel-caption">

							</div>
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：商品显示
            -->
			<div>
				<div class="col-md-12">
					<h2>小米系列&nbsp;&nbsp;<img src="img/title2.jpg"/></h2>
				</div>
				<div class="row">
					<c:forEach items="${t1}" var="goods">
						<div class="col-md-3" style="text-align:center;height:345px;padding:10px 0px;">
							<a href="GoodsServlet?mth=findGoods&gid=${goods.gid}">
								<img src="${goods.pic}" width="280px" height="280px" style="display: inline-block;">
							</a>
							<p><a href="GoodsServlet?mth=findGoods&gid=${goods.gid}" style='color:#666'>${goods.gname}</a></p>
							<p><font color="#E4393C" style="font-size:16px">&yen;${goods.price}</font></p>
						</div>
					</c:forEach>

				</div>
			</div>
			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：广告部分
            -->
            <div>
				<img src="products/hao/ad.jpg" width="100%"/>
			</div>
			<div>
				<div class="col-md-12">
					<h2>红米系列&nbsp;&nbsp;<img src="img/title2.jpg"/></h2>
				</div>
				<div class="row">
					<c:forEach items="${t2}" var="goods">
						<div class="col-md-3" style="text-align:center;height:345px;padding:10px 0px;">
							<a href="GoodsServlet?mth=findGoods&gid=${goods.gid}">
								<img src="${goods.pic}" width="280px" height="280px" style="display: inline-block;">
							</a>
							<p><a href="GoodsServlet?mth=findGoods&gid=${goods.gid}" style='color:#666'>${goods.gname}</a></p>
							<p><font color="#E4393C" style="font-size:16px">&yen;${goods.price}</font></p>
						</div>
					</c:forEach>

				</div>
			</div>


			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：商品显示
            -->

			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：页脚部分
            -->
			<div>
				<div style="margin-top:50px;">
					<img src="img/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
				</div>
		
				<div style="text-align: center;margin-top: 5px;">
					<ul class="list-inline">
						<li><a href="userinfo.jsp">关于我们</a></li>
						<li><a>联系我们</a></li>
						<li><a>招贤纳士</a></li>
						<li><a>法律声明</a></li>
						<li><a>友情链接</a></li>
						<li><a>支付方式</a></li>
						<li><a>配送方式</a></li>
						<li><a>服务声明</a></li>
						<li><a>广告声明</a></li>
					</ul>
				</div>
				<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
					Copyright &copy; 2005-2016 中软商城 版权所有
				</div>
			</div>
		</div>
	</body>

</html>