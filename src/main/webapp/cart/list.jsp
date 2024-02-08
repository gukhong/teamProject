<%@page import="javax.websocket.Session"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="domain.goods.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>



<h3>장바구니</h3>

	
	<c:forEach var="dto" items="${list}">
	<div class="card">
	  	<div class="card-body" style="display:flex">
	  	<div>
	  	<img src="upload/small/${dto.code}.jpg" width="200" height="300" style="margin-right:30px" />
	  	</div>
	  	<div>
	  		<h3>주문자 : ${dto.username}</h3>
	  		<p>도서명 : ${dto.bookname }</p>
	  		<p>CODE : ${dto.code} // 수량 : ${dto.stack }</p>
	  		<p>작가 : ${dto.author }</p>
	  		<p>가격 : ${dto.bookprice }</p>
	  	</div>
	  
		</div>
	</div>
	<br>
	</c:forEach>
	
	<!-- 페이지 정보 -->
	<br>

		<a href="#" class="btn btn-primary">구매하기</a>
		<a href="<%=request.getContextPath() %>/cart?cmd=deleteAll&userName=${sessionScope.userName}" class="btn btn-primary">장바구니 비우기</a>
		
		
	





<%@ include file="../include/footer.jsp" %>