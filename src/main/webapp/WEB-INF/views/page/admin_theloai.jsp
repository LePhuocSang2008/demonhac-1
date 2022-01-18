<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<h2 style="margin-top: 2%"> Thể loại </h2>
     	
     	<table style="margin-top: 2%;  table-layout: auto; font-size: 100%" class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Tên thể loại</th>
      <th scope="col">Hình ảnh</th>
      <th scope="col"></th>
      
  </thead>
  <tbody>
  <%int i = 1;%>
     <c:forEach var="item" items="${theloai}">
    <tr>
      <th  scope="row"><% out.print(i++); %></th>
      <td>${item.tentheloai }</td>
      <td><img style="width: 10%; height: 20%" src="${item.hinhanh }" alt="" ></td> 
      <td>
      	<span>
      		<a href= "http://localhost:8080/demonhac/xoatheloai?idtheloai=${item.id}" > Xóa </a> 
      		|
      		<a href= "" > Sửa </a>
      	</span>
      </td>
      
    </tr>
      </c:forEach>
    
    
  </tbody>
</table>

     	


     	<button type="button" style="margin-left: 5%" class="btn btn-dark"><a style="color: #FFF" href= "" > Tạo mới  </a></button>