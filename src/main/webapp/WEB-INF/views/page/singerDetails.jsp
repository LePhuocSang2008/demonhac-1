<%@ include file="/common/taglib.jsp" %>
	  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 


<!-- Player section -->
	<section class="player-section set-bg" data-setbg="https://i.ytimg.com/vi/0BzZO8ElOhQ/sddefault.jpg">
		<div class="player-box">
			<div class="tarck-thumb-warp">
				<div class="tarck-thumb">
					<img src="${dulieucasi.hinhanh }" alt="">
					
				</div>
			</div>
			<div class="wave-player-warp">
				<div class="row">
					<div class="col-lg-8">
						<div class="wave-player-info">
							<h2>${dulieucasi.tencasi }</h2>
							<p>Mô tả: ${dulieucasi.mota }</p>
							 
						</div>
					</div>
					
				</div>
				
			</div>
		</div>
	</section>
	<!-- Player section end -->

	

	<!-- Similar Songs section -->
	<section class="similar-songs-section">
		<div class="container-fluid">
			<h3>Bài hát của ca sĩ ${dulieucasi.tencasi }</h3> 
			<div class="row">
				<c:forEach var="item" items="${dulieutrang }" >
				<div class="col-xl-3 col-sm-6" onclick="doitrang('http://localhost:8080/demonhac/artist/?idmusic=${item.id}')"> 
					<div class="similar-song">					
						<img style="height: 50%; width: 70%" class="ss-thumb" src="${item.linkhinhanh }" alt="">
						<h4>${item.tennhac }</h4>
						<p>${item.tentheloai }</p>						
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="container">    
		  <ul style=" display: flex; justify-content: center" class="pagination">	    
		    <c:if test="${trang > 1 }">
		    	<li class="page-item"><a class="page-link" href="http://localhost:8080/demonhac/singerDetails?idcasi=${dulieucasi.id }&&page=${trang-1 }">Trước</a></li>
		    </c:if>
		    <c:forEach var = "i" step="1" begin = "1" end = "${tongsotrang}" >
		    	<c:choose>
				    <c:when test="${trang == i}">
				       <li class="page-item active"><a class="page-link " href="http://localhost:8080/demonhac/singerDetails?idcasi=${dulieucasi.id }&&page=${i}">${i}</a></li>
				    </c:when>    
				    <c:otherwise>
				        <li class="page-item"><a class="page-link" href="http://localhost:8080/demonhac/singerDetails?idcasi=${dulieucasi.id }&&page=${i}">${i}</a></li>
				    </c:otherwise>
				</c:choose>
		    </c:forEach>		    
		     <c:if test="${trang < tongsotrang }">
		    	<li class="page-item"><a class="page-link" href="http://localhost:8080/demonhac/singerDetails?idcasi=${dulieucasi.id }&&page=${trang+1 }">Sau</a></li>
		    </c:if>
		  </ul>
		</div>
		
	</section>
	</section>
	<!-- Similar Songs section end -->