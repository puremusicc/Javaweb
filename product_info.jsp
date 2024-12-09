<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="css/style.css" type="text/css" />

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>

		
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

						<li><a href="cart">购物车</a></li>
					</ol>
				</div>
			</div>
			<!--
            	时间：2015-12-30
            	描述：导航条
            -->
			<div class="container">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
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
								<li><a href="GoodsServlet?mth=findByTid&tid=3">小米MAX</a></li>
								<li><a href="GoodsServlet?mth=findByTid&tid=4">MATE</a></li>
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
					<!-- /.container-fluid -->
				</nav>
			</div>


		<div class="container">
			<div class="row">

				<div style="margin:0 auto;width:950px;">
					<div class="col-md-6">
						<img style="opacity: 1;width:400px;height:350px;" title="" class="medium" src="${goods.pic}">
					</div>

					<div class="col-md-6">
						<div><strong>${goods.gname}</strong></div>
						<div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
							&nbsp;
						</div>

						<div style="margin:10px 0 10px 0;">亿家价: <strong style="color:#ef0101;">￥：${goods.price}</strong>
						</div>

						<div style="margin:10px 0 10px 0;">&nbsp;</div>

						<div style="padding:10px;border:1px solid #e7dbb1;width:330px;margin:15px 0 10px 0;;background-color: #fffee6;">
							<div style="margin:5px 0 10px 0;">&nbsp;</div>

							<div style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px;">
								&nbsp;
							</div>

							<div style="margin:20px 0 10px 0;;text-align: center;">
								<a href="cart?mth=addCart&gid=${goods.gid}">
									<input style="background: url('./images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0);height:36px;width:127px;" value="加入购物车" type="button">
								</a> </div>
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<div style="width:950px;margin:0 auto;">
					<div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
						<strong>商品介绍</strong>
					</div>
					<div>
						${goods.details}
					</div>





				</div>

			</div>
		</div>

		<div style="margin-top:50px;">
			<img src="./image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2005-2016 中软商城 版权所有
		</div>

	</body>

</html>