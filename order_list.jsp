<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>WEB01</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
	<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong>我的订单</strong>
					<table class="table table-bordered">
						<c:forEach items="${myOrders}" var="order">
							<tbody>
							<tr class="success">
								<th colspan="3">订单编号:${order.oid} </th>
								<th>创建时间 </th>
								<th colspan="2">${order.createTime} </th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>状态</th>
								<th>总计</th>
							</tr>
							<tr class="active">
								<td width="60" width="40%">
									<input type="hidden" name="id" value="22">
									<img src="${order.goods.pic}" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank">${order.goods.gname}</a>
								</td>
								<td width="20%">
										${order.price}
								</td>
								<td width="10%">
										${order.number}
								</td>
								<td width="10%">
									<c:choose>
										<c:when test="${order.state==1}">未付款</c:when>
										<c:when test="${order.state==2}">已付款</c:when>
										<c:when test="${order.state==3}">已发货</c:when>
										<c:when test="${order.state==4||order.state==0}">已完成</c:when>
									</c:choose>
								</td>
								<td width="15%">
									<span class="subtotal">${order.total}</span>
								</td>
							</tr>
							</tbody>
						</c:forEach>


					</table>
				</div>
			</div>

	</body>

</html>