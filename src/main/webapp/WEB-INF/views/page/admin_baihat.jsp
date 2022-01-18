<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


     	<h2 style="margin-top: 2%"> Bài hát </h2>
     	
     	<table style="margin-top: 2%" class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Tên ca sĩ</th>
      <th scope="col">Tên thể loại</th>
      <th scope="col">Ngày tạo</th>
      <th scope="col">Hinh ảnh</th>
      <th scope="col">Tên nhạc</th>
      <th scope="col">Link nhạc</th>
      <th scope="col">Lời bài hát</th>
      <th scope="col">Luợt nghe</th>
      <th scope="col"></th>
  </thead>
  <tbody>
  <%int i = 1;%>
  <c:forEach var="item" items="${baihat}">
    <tr>
      <th scope="row"><% out.print(i++); %></th>
      <td>${item.tencasi }</td>
      <td>${item.tentheloai }</td>
      <td>${item.ngaytao }</td> 
      <td><img style="width: 100%; height: 100%" src="${item.linkhinhanh }" alt="" ></td> 
      <td>${item.tennhac }</td> 
      <td>${item.linknhac }</td> 
      <td>${item.loibaihat }</td> 
      <td>${item.luotnghe }</td> 
      <td>
      	<span>
      		<a href= "http://localhost:8080/demonhac/xoabaihat?idbaihat=${item.id}" > Xóa </a> 
      		|
      		<a href= "" > Sửa </a>
      	</span>
      </td>
      
    </tr>
   </c:forEach>
  </tbody>
</table>


     	<button type="button" style="margin-left: 5%" class="btn btn-dark"><a style="color: #FFF" href= "" > Tạo mới  </a></button>