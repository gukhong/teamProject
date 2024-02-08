<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>대현문고 main</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> <!-- Jquery -->
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
     <!-- 섬머노트 -->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	

    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f8f9fa;
            color: #333;
        }
        .navbar-custom {
            background-color: #000;
        }
        .navbar-custom .navbar-brand,
        .navbar-custom .navbar-nav .nav-link {
            color: #fff;
        }
        .footer-custom {
            background-color: #212529;
            color: #fff;
            padding: 10px 0;
        }
           color: #333;
            background-color: #fff;
        }
        .navbar, .footer {
            background-color: #000;
            color: #fff;
        }
        .carousel-inner img {
            filter: grayscale(100%);
        }
        .book-title {
            color: #000;
        }
        .book-description {
            color: #666;
        }
        .navbar-custom .navbar-toggler-icon {
    background-image: url("data:image/svg+xml;charset=utf8,%3Csvg viewBox='0 0 30 30' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath stroke='rgba(255, 255, 255, 1)' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 7h22M4 15h22M4 23h22'/%3E%3C/svg%3E");
}
        
    </style>
</head>
<body>
<!-- 로그인 ID가 있으면 세션으로 userId 전송 -->
<%
	String userId = null;
	if(session.getAttribute("user") != null){
		userId = (String)session.getAttribute("user");
	}
%>	
<%
	if(userId == null){
%>
<!-- 비로그인 시 헤더 출력부 -->
    <nav class="navbar navbar-expand-lg navbar-custom">
        <div class="container">
            <a class="navbar-brand" href="<c:url value='/main.jsp'/>">대현문고</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav ml-auto">
                    <a class="nav-item nav-link" href="<c:url value='/main.jsp'/>">홈</a>
                    <a class="nav-item nav-link" href="<c:url value='/user/join.jsp'/>">회원가입</a>
                    <a class="nav-item nav-link" href="<c:url value='/user/login.jsp'/>">로그인</a>
                    <a class="nav-item nav-link" href="<c:url value='/goods?cmd=list&page=0'/>">도서쇼핑</a>
                    <a class="nav-item nav-link" href="<c:url value='/cart?cmd=list&page=0&userName=${sessionScope.userName }'/>">장바구니</a>
                </div>
            </div>
        </div>
    </nav>
<%
	}else{
%>
<!-- 로그인 시 헤더 출력부 -->
    <nav class="navbar navbar-expand-lg navbar-custom">
        <div class="container">
            <a class="navbar-brand" href="<c:url value='/main.jsp'/>">대현문고</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav ml-auto">
                    <a class="nav-item nav-link" href="<c:url value='/main.jsp'/>">홈</a>

					<a class="nav-item nav-link" href="<c:url value='/logout'/>">[로그아웃]</a>
					<!-- admin으로 접속시 관리자메뉴 버튼 생성 -->
					<% if("admin".equals(userId)){ %>
						<a class="nav-item nav-link" href="<c:url value='/admin/adminpage.jsp'/>" target="_blank">[관리자 페이지]</a>
					<% } %>
                    <a class="nav-item nav-link" href="<c:url value='/user/login.jsp'/>">장바구니</a>
                    <a class="nav-item nav-link" href="<c:url value='/goods?cmd=list&page=0'/>">도서쇼핑</a>
                    <a class="nav-item nav-link" href="<c:url value='/cart?cmd=list&page=0&userName=${sessionScope.userName }'/>">장바구니</a>
                </div>
            </div>
        </div>
    </nav>

<%
	}
%>
