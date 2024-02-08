<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h2 class="mt-5">회원 정보 수정</h2>
            <form action="${pageContext.request.contextPath}/user?cmd=updatePassword" method="post">
                
                <!-- 비밀번호 수정 성공/실패 메시지 -->
                <c:if test="${not empty requestScope.updateMessage}">
                    <div class="alert alert-${requestScope.updateStatus ? 'success' : 'danger'}" role="alert">
                        ${requestScope.updateMessage}
                    </div>
                </c:if>
                
                <div class="form-group">
                    <label for="currentPassword">현재 비밀번호</label>
                    <input type="password" class="form-control" id="currentPassword" name="currentPassword" required>
                </div>
                
                <div class="form-group">
                    <label for="newPassword">새 비밀번호</label>
                    <input type="password" class="form-control" id="newPassword" name="newPassword" required>
                </div>
                
                <div class="form-group">
                    <label for="confirmNewPassword">새 비밀번호 확인</label>
                    <input type="password" class="form-control" id="confirmNewPassword" name="confirmNewPassword" required>
                </div>
                
                <button type="submit" class="btn btn-primary">비밀번호 변경</button>

            </form>
        </div>
    </div>
</div>
<br><br><br>
<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<%@ include file="/include/footer.jsp" %>
</body>
</html>
