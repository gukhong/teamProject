<%@page import="javax.websocket.Session"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="domain.goods.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
<h3 id="test">상품 리스트 <a><input type="text" name="select" value="검색하기"/></a></h3>
	<c:forEach var="dto" items="${list}">
	<div class="card">
	  	<div class="card-body" style="display:flex">
	  	<div>
	  	<img src="upload/small/${dto.code}.jpg" width="200" height="300" style="margin-right:30px"/>
	  	</div>
	  	<div>
	  		<input type="hidden" name ="cartCode" value="${dto.code }" />
	  		<h3>책이름 : ${dto.bookname}</h3>
	  		<p>분류 : ${dto.booktype} //  CODE : ${dto.code} // 수량 : ${dto.stack }</p>
	  		<p>작가 : ${dto.author }</p>
	  		<p>가격 : ${dto.bookprice }</p>
	  		<p>간략 설명 : ${dto.smallcontent }</p>
	  		<p>출판사 : ${dto.publisher }</p>
	  		<p>출판일 : ${dto.publicationdate }</p>
	  	</div>
	  	
		</div>
		<a href="<%= request.getContextPath() %>/goods?cmd=detail&code=${dto.code}" class="btn btn-primary">상세보기</a>
		<button type="button" onclick="location.href='<%=request.getContextPath() %>/cart?cmd=add&userName=${sessionScope.userName }&code=${dto.code }'" class="btn btn-primary">장바구니 담기</button>
		
		
	</div>
	<br>
	</c:forEach>
	
	<!-- 페이지 정보 -->
	<br>
	<ul class="pagination justify-content-center">
		<!-- 이전 -->
		<c:choose>
			<c:when test="${page==0 || lastpage==0}">
				<li class="page-item disabled "><a class="page-link"
					href="/NO12/goods?cmd=list&page=${page-1}">이전</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item "><a class="page-link"
					href="/NO12/goods?cmd=list&page=${page-1}">이전</a></li>
			</c:otherwise>
		</c:choose>
		<p>${page+1}/ ${lastpage+1}</p>
		<!-- 다음 -->
		<c:choose>
			<c:when test="${page==lastpage}">
				<li class="page-item disabled "><a class="page-link"
					href="/NO12/goods?cmd=list&page=${page+1}">다음</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link"
					href="/NO12/goods?cmd=list&page=${page+1}">다음</a></li>
			</c:otherwise>
		</c:choose>
	</ul>





<%@ include file="../include/footer.jsp" %>