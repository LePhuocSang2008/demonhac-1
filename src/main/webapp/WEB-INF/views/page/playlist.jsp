<%@ include file="/common/taglib.jsp" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!-- Playlist section -->
	<section class="playlist-section spad">
		<div class="container-fluid">
			<div style="width: 100%" class="section-title">
				<h2>Các bài hát được yêu thích</h2>
			</div>   
			                                       
			
			
			<div  class="row playlist-area">
			<c:forEach var="item" items="${newMusic}">
					<div class="mix col-lg-3 col-md-4 col-sm-6 genres">
					<div  class="playlist-item" onclick="doitrang('http://localhost:8080/demonhac/artist/?idmusic=${item.id}')">
						<img style="height: 50%; width: 70%" src="${item.linkhinhanh }" alt="">
						<h5>${item.tennhac }</h5>
					</div>
				</div>
			</c:forEach>
										
			</div>
		</div>
		<div class="container">    
		  <ul class="pagination">	    
		    <c:if test="${trang > 1 }">
		    	<li class="page-item"><a class="page-link" href="http://localhost:8080/demonhac/?page=${trang-1 }">Truoc</a></li>
		    </c:if>
		    <c:forEach var = "i" step="1" begin = "1" end = "${tongsotrang}" >
		    	<c:choose>
				    <c:when test="${trang == i}">
				       <li class="page-item active"><a class="page-link" href="http://localhost:8080/demonhac/?page=${i}">${i}</a></li>
				    </c:when>    
				    <c:otherwise>
				        <li class="page-item"><a class="page-link" href="http://localhost:8080/demonhac/?page=${i}">${i}</a></li>
				    </c:otherwise>
				</c:choose>
		    </c:forEach>		    
		     <c:if test="${trang < tongsotrang }">
		    	<li class="page-item"><a class="page-link" href="http://localhost:8080/demonhac/?page=${trang+1 }">Sau</a></li>
		    </c:if>
		  </ul>
		</div>
	</section>
	<!-- Playlist section end -->