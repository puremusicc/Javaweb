<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css"/>

<style>
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
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
				<li><a href="">${users.nickName}</a></li>
				<li><a href="">注销</a></li>
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




<div class="container" style="width:100%;background:url('image/regist_bg.jpg');">
<div class="row"> 

	<div class="col-md-2"></div>
	
	


	<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<font>会员注册</font>USER REGISTER
		<form action="users" method="post" class="form-horizontal" style="margin-top:5px;">
			<%--	使用隐藏域来设置请求的功能		--%>
			<input type="hidden" name="mth" value="register">
			 <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">用户名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" name="loginName" id="username" placeholder="请输入用户名">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" name="pwd" id="inputPassword3" placeholder="请输入密码">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" name="confirmpwd" id="confirmpwd" placeholder="请输入确认密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">电话</label>
			    <div class="col-sm-6">
			      <input type="text" name="phone" class="form-control" id="inputEmail3" placeholder="手机号">
			    </div>
			  </div>
			 <div class="form-group">
			    <label for="usercaption" class="col-sm-2 control-label">昵称</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="usercaption" name="nick" placeholder="昵称">
			    </div>
			  </div>
			  <div class="form-group opt">  
			  <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>  
			  <div class="col-sm-6">
			    <label class="radio-inline">
			  <input type="radio" name="sex" id="inlineRadio1" value="男"> 男
			</label>
			<label class="radio-inline">
			  <input type="radio" name="sex" id="inlineRadio2" value="女"> 女
			</label>
			</div>
			  </div>		

			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">验证码</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control"  >
			      
			    </div>
			    <div class="col-sm-2">
			    <img src="./image/captcha.jhtml"/>
			    </div>
			    
			  </div>
			 
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit"  width="100" value="注册" name="submit" border="0"
				    style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
			    </div>
			  </div>
			</form>
	</div>
	
	<div class="col-md-2"></div>
  
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

</body></html>




