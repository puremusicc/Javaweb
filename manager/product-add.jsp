<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function-manage.js"></script>
	<link rel="stylesheet" href="editor/default.css" />
	<link rel="stylesheet" href="editor/prettify.css" />
	<script charset="UTF-8" src="editor/kindeditor.js"></script>
	<script charset="UTF-8" src="editor/zh_CN.js"></script>
	<script charset="UTF-8" src="editor/prettify.js"></script>
	<script charset="UTF-8" src="../js/jquery-1.11.3.min.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="context"]', {
				cssPath : 'editor/prettify.css',
				uploadJson : 'upload_json.jsp',
				fileManagerJson : 'file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
		$(function(){
			$("#file").change(function(){
				//创建提交数据对象
				var formData=new FormData();
				//添加提交数据
				formData.append("pic",$("#file")[0].files[0])
				//ajax提交
				$.ajax({
					url:"upload",	//路径
					dataType:"text",	//返回数据类型
					type:"post",	//请求方式
					data:formData,	//请求数据
					async:false,	//是否异步
					processData:false, //不处理数据
					contentType:false,	//是否设置content-type
					success:function(data){
						var strs=data.split("-")
						$("#pic").val(strs[1]);  //设置隐藏域的值
						$("#img").attr("src",strs[0]+"/"+strs[1])	//设置图片路径
					},
					error:function(){
						alert("上传失败")
					}
				})
			})
		})
	</script>
</head>
<c:if test="${typeList==null}">
	<%--	<jsp:forward page="users.do?mth=findAll"></jsp:forward>--%>
	<script type="text/javascript">
		window.location.href="goods.do?mth=toAdd";
	</script>
</c:if>
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
		<h2>添加商品</h2>
		<div class="manage">
			<form action="goods.do" METHOD="post" ENCTYPE="multipart/form-data">
				<input type="hidden" name="mth" value="add">
				<table class="form">
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" class="text" name="gname" value="" /></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="tid">
								<c:forEach items="${typeList}" var="type">
									<option value="${type.tid}">${type.tname}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" class="text" id="file" /></td>
					</tr>
					<tr>
						<td class="field">图片预览：</td>
						<td>
							<input type="hidden" name="pic" value="" id="pic">
							<img src="images/yl.jpg" width="100px" id="img" height="100px"/>
						</td>
					</tr>
					<tr>
						<td class="field">商品价格：</td>
						<td><input type="text" class="text tiny" name="price" /> 元</td>
					</tr>
					<tr>
						<td class="field">是否上架：</td>
						<td>
							<select name="state">
								<option value="1">上架</option>
								<option value="0">不上架</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">商品描述：</td>
						<td>
							<textarea name="context" cols="100" rows="8" style="width:500px;height:200px;visibility:hidden;"></textarea>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="添加" /></label></td>
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
<%!
	private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
%>