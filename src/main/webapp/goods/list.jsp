<%@page import="domain.goods.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	List<GoodsDTO> list = (List<GoodsDTO>) request.getAttribute("/list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>갤러리 리스트</h3>
	<table>
		<tr>
			<th>글번호</th>
			<th>사진</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<c:forEach var="dto" items="<%= list  %>">
			<tr>
				<td>${dto.code}</td>
				<td><img src="upload/big/${dto.code}.jpg" width="500" /></td>
				<td>${dto.bookname}</td>
				<%-- <a href="galleryview.jsp?idx=${dto.idx}"></a> --%>
				<td>${dto.author}</td>
				
			</tr>
		</c:forEach>
	</table>


</body>
</html>