<%@page import="config.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 페이지</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%
   Connection conn = null;
   Statement stmt = null;
   ResultSet rs = null;
   try {
       conn = DBConnection.getConnection(); // 데이터베이스 연결 얻기
       stmt = conn.createStatement();
       String sql = "SELECT * FROM user_info";
       rs = stmt.executeQuery(sql);

       while (rs.next()) {
           String userId = rs.getString("userId");
           String userPass = rs.getString("userPass");
           String userName = rs.getString("userName");
           String regiDate = rs.getString("registerDate");
%>
<h2>가입자 정보</h2>
	<table border="1">
	    <tr>
	        <th>ID</th>
	        <th>PASSWORD</th>
	        <th>NAME</th>
	        <th>JOINDATE</th>
	    </tr>
	    <tr>
	        <td><%= userId %></td>
	        <td><%= userPass %></td>
	        <td><%= userName %></td>
	        <td><%= regiDate %></td>
	    </tr>
</table>
<%
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("<p>이용자 정보를 불러오는데 실패했습니다.</p>");
    } /* finally {
        DBConnection.close(conn, stmt, rs); // 자원 해제
    } */
   
%>
<br>
<br>
<h2>등록상품 정보</h2>
<table border="1">
    <tr>
        <th>코드</th>
        <th>도서명</th>
        <th>유형</th>
        <th>가격</th>
        <th>출판사</th>
        <th>저자</th>
        <th>발간일</th>
        <th>등록일</th>
        <th>재고</th>
    </tr>
    <%
       try {
           // 가입자 정보 출력 후 Connection을 재사용하거나 새로 연결
           String bookSql = "SELECT * FROM book_info";
           stmt = conn.createStatement();
           rs = stmt.executeQuery(bookSql);
   
           while (rs.next()) {
               String code = rs.getString("code");
               String bookName = rs.getString("bookName");
               String bookType = rs.getString("bookType");
               String bookPrice = rs.getString("bookPrice");
               String publisher = rs.getString("publisher");
               String author = rs.getString("author");
               String publicationDate = rs.getString("publicationDate");
               String registerDate = rs.getString("registerDate");
               String stack = rs.getString("stack");
    %>
    <tr>
        <td><%= code %></td>
        <td><%= bookName %></td>
        <td><%= bookType %></td>
        <td><%= bookPrice %></td>
        <td><%= publisher %></td>
        <td><%= author %></td>
        <td><%= publicationDate %></td>
        <td><%= registerDate %></td>
        <td><%= stack %></td>
    </tr>
    <%
           }
       } catch (Exception e) {
           e.printStackTrace();
           out.println("<p>등록상품 정보를 불러오는데 실패했습니다.</p>");
       } finally {
    	   DBConnection.close(conn, stmt, rs);
       }
    %>
</table>
</body>
</html>
