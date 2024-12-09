<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<link rel="stylesheet" href="css/cart.css">
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script src="js/cart.js" type="text/javascript"></script>
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
			
			.container .row div {
				/* position:relative;
	 float:left; */
			}
			
			font {
				color: #3164af;
				font-size: 18px;
				font-weight: normal;
				padding: 0 10px;
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

		<div class="container">
		<form action="order" method="post" id="cart">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">订单详情</strong>
					<div class="cart">
						
							<input type="hidden" name="mth" value="createOrder">
							<table  cellspacing="0" cellspacing="0">
								<thead>
								<tr>
									<th width="100px">
										<input type="checkbox" id="checkAll"  />
										全选
									</th>
									<th width="150px">图片</th>
									<th width="200px">名称</th>
									<th width="100px">价格</th>
									<th width="150px">数量</th>
									<th width="100px">小计</th>
									<th width="100px">操作</th>
								</tr>
								</thead>
								<tbody class="tbody">
								<tr class="empty">
									<td colspan="7">
										购物车里空空如也，马上去<a href="index.html">购物</a>吧
									</td>
								</tr>
								<c:forEach items="${cartList}" var="cart">
									<tr>
										<td>
											<input type="checkbox" name="ck" value="${cart.cid}" />
										</td>
										<td>
											<img src="${cart.goods.pic}" />
										</td>
										<td><a href="GoodsServlet?mth=findGoods&gid=${cart.goods.gid}">${cart.goods.gname}</a></td>
										<td>${cart.goods.price}</td>
										<td>
											<button type="button" data-cid="${cart.cid}" class="jian">-</button>
											<input type="text" class="num"  value="${cart.number}" readonly="readonly" />
											<button type="button" data-cid="${cart.cid}" class="jia">+</button>
										</td>
										<td>${cart.subtotal}</td>
										<td><a href="cart?mth=removeCart&cid=${cart.cid}" data-cid="${cart.cid}" class="del">删除</a></td>
									</tr>
								</c:forEach>

								</tbody>
								<tfoot>
								<tr class="footer">
									<td>总金额</td>
									<td>
										<span id="total">0</span>元
										<input class="total" type="hidden" value="0" name="total">
									</td>
								</tr>
								</tfoot>
							</table>
				
					</div>
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					<em style="color:#ff6600;">
			</em> 
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<a href="cart?mth=removeMore" id="clear" class="clear">清空购物车</a>
				
						<input type="submit" width="100" value="提交订单" name="submit" border="0" style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
			
				</div>
			</div>
		</form>
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
			Copyright &copy; 2005-2016 传智商城 版权所有
		</div>

	</body>

</html>