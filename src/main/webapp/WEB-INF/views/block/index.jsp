
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="zxx">
<head>
	<title>SolMusic | HTML Template</title>
	<meta charset="UTF-8">
	<meta name="description" content="SolMusic HTML Template">
	<meta name="keywords" content="music, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	


</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	<!-- Header section -->
	<header class="header-section clearfix">
		<a href="http://localhost:8080/demonhac" class="site-logo">
			<img src="<c:url value="/resources/img/logo.png" />" alt="">
		</a>
		<div class="header-right">
			
			
 
			<div class="user-panel" >
				
				<a href="http://localhost:8080/demonhac/login" class="login">Đăng nhập</a>
				<span>|</span>
				
				<a href="http://localhost:8080/demonhac/registration" class="register">Đăng ký</a>
				
				
				
			</div> 
		</div>
		<ul class="main-menu">
			<li><a href="http://localhost:8080/demonhac/">Trang chủ</a></li>
			<li><a href="http://localhost:8080/demonhac/singer">Ca sĩ</a></li>
			<li><a href="#">Thể loại</a>
				<ul class="sub-menu">	
				<c:forEach var="item" items="${theloai}">
					<li><a href="http://localhost:8080/demonhac/category?idtheloai=${item.id}">${item.tentheloai}</a></li>
				</c:forEach>	
				</ul>			
			</li>
			<li><a href="http://localhost:8080/demonhac/blog">Tin tức</a></li>
			<li><a href="http://localhost:8080/demonhac/contact">Liên hệ</a></li>
			
		</ul>
	</header>
	<!-- Header section end -->
    	<tiles:insertAttribute name="hero" />
     	<tiles:insertAttribute name="playlist" />
     	<tiles:insertAttribute name="category" />
     	<tiles:insertAttribute name="artist" />
     	<tiles:insertAttribute name="contact" />
     	<tiles:insertAttribute name="blog" />
     	<tiles:insertAttribute name="singer" />
     	<tiles:insertAttribute name="singerDetails" />
     	
	<!-- Footer section -->
	<footer class="footer-section">
		<div class="container">
			<div class="row">
				<div class="col-xl-6 col-lg-7 order-lg-2">
					<div class="row">
						<div class="col-sm-4">
							<div class="footer-widget">
								<h2>About us</h2>
								<ul>
									<li><a href="">Our Story</a></li>
									<li><a href="">Sol Music Blog</a></li>
									<li><a href="">History</a></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="footer-widget">
								<h2>Products</h2>
								<ul>
									<li><a href="">Music</a></li>
									<li><a href="">Subscription</a></li>
									<li><a href="">Custom Music</a></li>
									<li><a href="">Footage</a></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="footer-widget">
								<h2>Playlists</h2>
								<ul>
									<li><a href="">Newsletter</a></li>
									<li><a href="">Careers</a></li>
									<li><a href="">Press</a></li>
									<li><a href="">Contact</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-6 col-lg-5 order-lg-1">
					<img src="img/logo.png" alt="">
					<div class="copyright"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></div>
					<div class="social-links">
						<a href=""><i class="fa fa-instagram"></i></a>
						<a href=""><i class="fa fa-pinterest"></i></a>
						<a href=""><i class="fa fa-facebook"></i></a>
						<a href=""><i class="fa fa-twitter"></i></a>
						<a href=""><i class="fa fa-youtube"></i></a>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer section end -->
	
	<!--====== Javascripts & Jquery ======-->

<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.slicknav.min.js" />"></script>
<script src="<c:url value="/resources/js/owl.carousel.min.js" />"></script>
<script src="<c:url value="/resources/js/mixitup.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>
<script type="text/javascript">
	function doitrang(url) {
		window.location=url;
	}
</script>
	</body>
</html>