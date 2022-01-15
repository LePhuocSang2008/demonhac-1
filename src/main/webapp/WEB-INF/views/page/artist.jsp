<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Player section -->
<section class="player-section set-bg" data-setbg="https://i.ytimg.com/vi/0BzZO8ElOhQ/sddefault.jpg">
	<div class="player-box">
		<div class="tarck-thumb-warp">
			<div class="tarck-thumb">
				<img src="${dulieubaihat.linkhinhanh }" alt="">
				
			</div>
		</div>
		<div class="wave-player-warp">
			<div class="row">
				<div class="col-lg-8">
					<div class="wave-player-info">
						<h2>${dulieubaihat.tennhac }</h2>
						<p>${dulieubaihat.tencasi }</p>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="songs-links">
						<a href=""><img src="<c:url value="/resources/img/icons/p-1.png"/>" alt=""></a>
						<a href=""><img src="<c:url value="/resources/img/icons/p-2.png"/>" alt=""></a>
						<a href=""><img src="<c:url value="/resources/img/icons/p-3.png"/>" alt=""></a>
					</div>
				</div>
			</div>
			<div id="wavePlayer" class="clierfix">
				<div id="audiowave"
					data-waveurl="<c:url value="/resources/music-files/8.mp3"/>"></div>
				<div id="currentTime"></div>
				<div id="clipTime"></div>
				<!-- Player Controls -->
				<div class="wavePlayer_controls">
					<audio controls style="width: 100%">
						<source
							src="${dulieubaihat.linknhac }" 
							type="audio/mpeg"/>
					</audio>
					
					
					
				</div>
			</div>
		</div>
</section>
<!-- Player section end -->

<!-- Songs details section -->
<section class="songs-details-section">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-3">
				<div class="song-details-box">
					<h3>Chi tiết bài hát</h3>
					<ul>
						<li><strong>Thể loại:</strong><span>${nametheloai}</span></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="row">
					<div class="col-lg-6">
						<div class="song-details-box">
							<h3>Ca sĩ</h3>
							<div class="artist-details">
								<img src="${dulieubaihat.hinhanh}" alt="lỗi">
								<div class="ad-text">
									<h5>${dulieubaihat.tencasi }</h5>
									<span>Artist/ Songwriter</span>
									<p>${dulieubaihat.mota }</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="song-details-box">
							<h3>Bài hát cùng ca sĩ</h3>
							<!-- song -->
							<c:forEach var="item" items="${listmusic_casi}">
							<div class="song-item">
								<div class="row">
									<div class="col-xl-5 col-lg-12 col-md-5">
										<div class="song-info-box">
											<img  src="${item.linkhinhanh }" alt="" onclick="doitrang('http://localhost:8080/demonhac/artist/?idmusic=${item.id}')">
											<div class="song-info">
												<h4>${item.tennhac }</h4>
												<p>${item.tentheloai }</p>
											</div>
										</div>
									</div>
								</div>
							</div>
							</c:forEach>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Thông tin bài hát -->
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="col-lg-12">
						<div class="song-details-box">
							<h3>Lời bài hát</h3>
							<div class="artist-details">${dulieubaihat.loibaihat }</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Songs details section -->

<!-- Bình luận -->
<section class="player-section set-bg " style="padding: 25px 47px;"  data-setbg="https://i.ytimg.com/vi/0BzZO8ElOhQ/sddefault.jpg">		
	<div class="player-box" style="padding: 13px 69px 20px 19px;">
			
		<div class="tarck-thumb">
			<img style="height: 60px;" src="https://png.pngtree.com/png-clipart/20190904/original/pngtree-hand-drawn-flat-wind-user-avatar-icon-png-image_4492039.jpg" alt="">			
		</div>
	<div class="wave-player-warp" style="padding-top: 0px;padding-left: 15px;">
		<div class="row-lg-3">
			<div class="col-lg-8">
				<div class="wave-player-info" >
					<h2  style="font-size: 14px;">Sơn bùi</h2>
					<p style="font-size: 13px;">Hay quá anh ơi</p>
				</div>
			</div>
		</div>
		<div id="wavePlayer" class="clierfix">
			<div class="wavePlayer_controls" style="    padding-top: 0px;">
				<button type="button" class="btn btn-primary">comment</button>
			</div>
		</div>
	</div>
	
	</div>
	<hr style="margin-top: -9.9px;">
	<div class="player-box" style="padding: 13px 69px 20px 19px;">
			
		<div class="tarck-thumb">
			<img style="height: 60px;" src="https://png.pngtree.com/png-clipart/20190904/original/pngtree-hand-drawn-flat-wind-user-avatar-icon-png-image_4492039.jpg" alt="">			
		</div>
	<div class="wave-player-warp" style="padding-top: 0px;  padding-left: 15px;">
		<div class="row-lg-3">
			<div class="col-lg-8">
				<div class="wave-player-info" >
					<h2  style="font-size: 14px;">Sơn bùi</h2>
					<p style="font-size: 13px;">Hay quá anh ơi</p>
				</div>
			</div>
		</div>
		<div id="wavePlayer" class="clierfix">
			<div class="wavePlayer_controls" style="    padding-top: 0px;">
				<button type="button" class="btn btn-primary">comment</button>
			</div>
		</div>
	</div>
	
	</div>
	</section>

<!-- Player section end -->

<!-- Similar Songs section -->
<section class="similar-songs-section">
	<div class="container-fluid">
		<h3>Bài hát cùng thể loại</h3>
		<div class="row">
			<c:forEach var="item" items="${listmusic_notcasi}">
				<div class="col-xl-3 col-sm-6">
					<div class="similar-song">
						<img class="ss-thumb" src="${item.linkhinhanh }" alt="" onclick="doitrang('http://localhost:8080/demonhac/artist/?idmusic=${item.id}')">
						<h4>${item.tennhac }</h4>
						<p>${item.tencasi }</p>					
					</div>
				</div>
			</c:forEach>
		
		</div>
	</div>
</section>
<!-- Similar Songs section end -->