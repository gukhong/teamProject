<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>로그인 성공</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <style>
        .center {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
    </style>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">
        // 페이지 로드 후 2초 후에 메인 페이지로 자동 리다이렉션
        setTimeout(function() {
            window.location.href = "<%=request.getContextPath()%>/main.jsp"; 
        }, 2000);
    </script>
</head>
<body>
<div class="center">
    <div class="spinner-border text-dark" style="width: 100px; height: 100px"></div>

<%
    String userName = (String) session.getAttribute("userName");
    if (userName != null) {
        out.println("<h3>" + userName + "님 반갑습니다! 메인 페이지로 이동합니다.</h3>");
    }
%>
</div>
</body>
</html>
