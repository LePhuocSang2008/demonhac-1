<%@ include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 


<!DOCTYPE html>
<html lang="en">
<head>
<title>Glassy Login Form A Responsive Widget Template :: w3layouts</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Glassy Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Meta tag Keywords -->
<link href="<c:url value="/resources/css/login/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/login/font-awesome.css" />" rel="stylesheet">


</head>
<body style="background-image: url(resources/img/bann.jpg);">
		<!--header-->
		<div class="header-w3l">
			<h1>Đăng nhập</h1>
			<%
			out.print(request.getAttribute("test"));
			%>
		</div>
		<!--//header-->
		<!--main-->
		<div class="main-w3layouts-agileinfo">
	           <!--form-stars-here-->
						<div class="wthree-form">
							<h2>Điền vào biểu mẫu bên dưới để đăng nhập</h2>
							<h2 style="font-size: 15px">${error }</h2>
							
							
							<form action="xulilogin" method="post">
								<div class="form-sub-w3">
									<input type="text" name="username" placeholder="Username " required="" />
								<div class="icon-w3">
									<i class="fa fa-user" aria-hidden="true"></i>
								</div>
								</div>
								<div class="form-sub-w3">
									<input type="password" name="password" placeholder="Password" required="" />
								<div class="icon-w3">
									<i class="fa fa-unlock-alt" aria-hidden="true"></i>
								</div>
								</div>
								<label class="anim">
								<input type="checkbox" class="checkbox">
									<span> Nhớ Tôi</span> 
									<a href="http://localhost:8080/demonhac/registration">Đăng kí</a>
								</label> 
								<div class="clear"></div>
								<div class="submit-agileits">
									<input type="submit" value="Đăng nhập">
								</div>
								<a style=" display: flex; justify-content: center; color: #FFF ; margin-top: 8%" href="http://localhost:8080/demonhac/">Trang chủ</a>
							</form>
							
						</div>
				<!--//form-ends-here-->

		</div>
		<!--//main-->
		<!--footer-->
		<div class="footer">
			
		</div>
		<!--//footer-->
</body>
</html>