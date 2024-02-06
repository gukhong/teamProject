<%@page import="java.sql.Connection"%>
<%@page import="config.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>DB test page</h2>

<%
	Connection con = DBConnection.getConnection();
%>

</body>
</html>