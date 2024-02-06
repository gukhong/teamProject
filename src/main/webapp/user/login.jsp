<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>


<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h2 class="mt-5">로그인</h2>
            <form action="${pageContext.request.contextPath}/user?cmd=login" method="post">
                <!-- 로그인 에러 메시지 -->
                <c:if test="${not empty requestScope.loginError}">
                    <div class="alert alert-danger" role="alert">
                        ${requestScope.loginError}
                    </div>
                </c:if>
                
                <div class="form-group">
                    <label for="userId">아이디</label>
                    <input type="text" class="form-control" id="userId" name="userId" required>
                </div>
                
                <div class="form-group">
                    <label for="userPass">비밀번호</label>
                    <input type="password" class="form-control" id="userPass" name="userPass" required>
                </div>
                
                <button type="submit" class="btn btn-primary">로그인</button>

            </form>
        </div>
    </div>
</div>
<br><br><br>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<%@ include file="/include/footer.jsp" %>