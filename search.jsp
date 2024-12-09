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
				width: 100%;
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

		<div class="row" style="width:1210px;margin:0 auto;">
			<div class="col-md-12">
				<ol class="breadcrumb">
					<li><a href="index.jsp">首页</a></li>
				</ol>
			</div>

			<c:forEach items="${page.list}" var="goods">
				<div class="col-md-3" style="text-align:center;height:345px;padding:10px 0px;">
					<a href="product_info.jsp">
						<img src="${goods.pic}" width="280px" height="280px" style="display: inline-block;">
					</a>
					<p><a href="product_info.html" style='color:#666'>${goods.gname}</a></p>
					<p><font color="#E4393C" style="font-size:16px">&yen;${goods.price}</font></p>
				</div>
			</c:forEach>

		</div>

		<!--分页 -->
		<div style="width:380px;margin:0 auto;margin-top:50px;">
			<ul class="pagination" style="text-align:center; margin-top:10px;">
				<c:if test="${page.currentPage>1}">
					<li class="disabled">
						<a href="GoodsServlet?mth=search&gname=${gname}&curr=${page.currentPage-1}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>

				<c:forEach begin="1" end="${page.totalPage}" var="num">
					<li <c:if test="${num==page.currentPage}"> class="active" </c:if> >
						<a href="GoodsServlet?mth=search&gname=${gname}&curr=${num}">${num}</a>
					</li>
				</c:forEach>
				<c:if test="${page.currentPage< page.totalPage}">
					<li>
						<a href="GoodsServlet?mth=search&gname=${gname}&curr=${page.currentPage+1}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>

			</ul>
		</div>
		<!-- 分页结束=======================        -->

		<!--
       		商品浏览记录:
        -->
		<div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

			<h4 style="width: 50%;float: left;font: 14px/30px " 微软雅黑 ";">浏览记录</h4>
			<div style="width: 50%;float: right;text-align: right;"><a href="">more</a></div>
			<div style="clear: both;"></div>

			<div style="overflow: hidden;">

				<ul style="list-style: none;">
					<li style="width: 150px;height: 216;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;"><img src="products/1/cs10001.jpg" width="130px" height="130px" /></li>
				</ul>

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