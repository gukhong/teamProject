<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>로그인 성공</title>
    <script type="text/javascript">
        // 페이지 로드 후 2초 후에 메인 페이지로 자동 리다이렉션
        setTimeout(function() {
            window.location.href = "<%=request.getContextPath()%>/main.jsp"; 
        }, 2000);
    </script>
</head>
<body>
<%
    String userName = (String) session.getAttribute("userName");
    if (userName != null) {
        out.println("<h3>" + userName + "님 반갑습니다! 메인 페이지로 이동합니다.</h3>");
    }
%>
</body>
</html>
