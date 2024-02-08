<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 성공</title>
 <script type="text/javascript">
        // 페이지 로드 후 2초 후에 메인 페이지로 자동 리다이렉션
        setTimeout(function() {
            window.location.href = "<%=request.getContextPath()%>/main.jsp"; 
        }, 2000);
    </script>
</head>
<body>
<p>비밀번호가 성공적으로 변경되었습니다.</p>
</body>
</html>
