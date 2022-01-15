<%@ include file="/common/taglib.jsp" %>
	  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<!-- Category section -->
	<section class="category-section spad">
		<div class="container-fluid">
			<div class="section-title">
			
				<!-- %
				out.print(request.getAttribute("tentheloaihientai"));
				%> -->
				<h2>${tentheloaihientai.tentheloai}</h2>
				
			</div>
			<div class="container">
				<div class="category-links">
					<a href="" class="active">Tất cả bài hát</a>
					
				</div>
			</div>
			<div class="category-items">
				<div class="row" >
					<c:forEach var="item" items="${dulieutrang}">
						<div class="col-md-4" onclick="doitrang('http://localhost:8080/demonhac/artist/?idmusic=${item.id}')">
						<div class="category-item">
							<img style="height: 70%; width: 70%" src="${item.linkhinhanh }" alt="">
							<div class="ci-text">
								<h4>${item.tennhac }</h4>
								<p>${item.tencasi }</p>
								
							</div>
							<a href="http://localhost:8080/demonhac/artist/?idmusic=${item.id}" class="ci-link"><i class="fa fa-play"></i></a>
						</div>
					</div>
					</c:forEach>									
				</div>
			</div>
		</div>
		<div class="container">    
		  <ul style=" display: flex; justify-content: center" class="pagination">	    
		    <c:if test="${trang > 1 }">
		    	<li class="page-item"><a class="page-link" href="http://localhost:8080/demonhac/category?idtheloai=${idtheloai }&&page=${trang-1 }">Trước</a></li>
		    </c:if>
		    <c:forEach var = "i" step="1" begin = "1" end = "${tongsotrang}" >
		    	<c:choose>
				    <c:when test="${trang == i}">
				       <li class="page-item active"><a class="page-link " href="http://localhost:8080/demonhac/category?idtheloai=${idtheloai }&&page=${i}">${i}</a></li>
				    </c:when>    
				    <c:otherwise>
				        <li class="page-item"><a class="page-link" href="http://localhost:8080/demonhac/category?idtheloai=${idtheloai}&&page=${i}">${i}</a></li>
				    </c:otherwise>
				</c:choose>
		    </c:forEach>		    
		     <c:if test="${trang < tongsotrang }">
		    	<li class="page-item"><a class="page-link" href="http://localhost:8080/demonhac/category?idtheloai=${idtheloai }&&page=${trang+1 }">Sau</a></li>
		    </c:if>
		  </ul>
		</div>
	</section>
	<!-- Category section end -->
