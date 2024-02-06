<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<div class="container mt-5">
    <h2 class="mb-4">회원가입</h2>
    <% if (request.getAttribute("errorMessage") != null) { %>
    <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
<% } %>
    
    <form action="${pageContext.request.contextPath}/user?cmd=join" method="post" class="needs-validation" novalidate>
        <div class="form-group">
            <label for="userId">아이디:</label>
            <input type="text" class="form-control" id="userId" name="userId" required>
        </div>
        <div class="form-group">
            <label for="userName">이름:</label>
            <input type="text" class="form-control" id="userName" name="userName" required>
        </div>
        <div class="form-group">
            <label for="userPass">비밀번호:</label>
            <input type="password" class="form-control" id="userPass" name="userPass" required>
        </div>
        <button type="submit" class="btn btn-primary">회원가입</button>
    </form>
    <br><br><br>
</div>
<%@ include file="/include/footer.jsp" %>
