<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Loding font -->
<!--<link href="https://fonts.googleapis.com/css?family=Montserrat:300,700" rel="stylesheet">-->

<!-- Custom Styles -->
<link rel="stylesheet" type="text/css" href="css/styles.css">

<title>Home</title>
</head>
<body>

<!-- Backgrounds -->

<div id="login-bg" class="container-fluid">

  <div class="bg-img"></div>
  <div class="bg-color"></div>
</div>

<!-- End Backgrounds -->

<div class="container" id="login">
	<div class="row justify-content-center">
	<div class="col-lg-8">
	  <div class="login">

		<h1>管理员登录</h1>
		
		<!-- Loging form -->
			  <form action="admin.do" method="post">
				  <input type="hidden" name="mth" value="login">
				<div class="form-group">
				  <input type="text" class="form-control" id="exampleInputEmail1" name="aname"
						 aria-describedby="emailHelp" placeholder="登录名">
				</div>
				<div class="form-group">
				  <input type="password" class="form-control" name="pwd"
						 id="exampleInputPassword1" placeholder="密码">
				</div>
				  <div class="form-check" style="color: red;text-align: center">
						${bmsg!=null? bmsg:lmsg}
				  </div>
				<br>
				<button type="submit" class="btn btn-lg btn-block btn-success">登录</button>
			  </form>
		 <!-- End Loging form -->

	  </div>Copyright &copy; 2019.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
	</div>
	</div>
</div>


</body>
</html>