<%@page import="config.DBConnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String userId = request.getParameter("userId");

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = DBConnection.getConnection();
        String sql = "UPDATE user_info SET userPass = '0000' WHERE userId = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userId);
        pstmt.executeUpdate();
        response.sendRedirect("adminpage.jsp"); // 초기화 후 다시 관리자 페이지로 이동
    } catch (Exception e) {
        e.printStackTrace();
        out.println("<p>비밀번호 초기화에 실패했습니다.</p>");
    } finally {
        DBConnection.close(conn, pstmt);
    }
%>
