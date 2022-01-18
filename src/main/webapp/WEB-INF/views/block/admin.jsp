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
				
				<span>Chào ${sessionScope.username }</span>
				<span>|</span>
				<a href="logout" class="register">Đăng xuất</a>
				
			</div> 
		</div>
		<ul class="main-menu">
			<li><a href="http://localhost:8080/demonhac/admin_casi">Ca sĩ</a></li>
			<li><a href="http://localhost:8080/demonhac/admin_theloai">Thể loại</a></li>
			<li><a href="http://localhost:8080/demonhac/admin_baihat">Bài hát</a></li>
			<li><a href="http://localhost:8080/demonhac/admin_taikhoan">Tài khoản</a></li>
			
		</ul>
	</header>
	<!-- Header section end -->
     	<tiles:insertAttribute name="admin_casi" />
     	<tiles:insertAttribute name="admin_theloai" />
     	<tiles:insertAttribute name="admin_baihat" />
     	<tiles:insertAttribute name="admin_taikhoan" />
     	<tiles:insertAttribute name="admin_index" />
     	
     	

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