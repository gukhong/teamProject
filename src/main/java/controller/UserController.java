package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.user.dto.UserDTO;
import service.UserService;

@WebServlet("/user")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService = new UserService();
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("process called");
        String cmd = request.getParameter("cmd");
        
        if ("login".equals(cmd)) {
            String userId = request.getParameter("userId");
            String userPass = request.getParameter("userPass");
            
            boolean isLoginSuccess = userService.login(userId, userPass);
            if (isLoginSuccess) {
                request.getSession().setAttribute("user", userId);
                try {
                    UserDTO userDetails = userService.getUserDetails(userId); // 사용자 상세 정보 조회
                    request.getSession().setAttribute("userName", userDetails.getUserName()); // 세션에 사용자 이름 저장
                    response.sendRedirect(request.getContextPath() + "/user/loginSuccess.jsp");
                } catch (Exception e) {
                    e.printStackTrace();
                    // 예외 처리 로직, 예를 들어 로그를 남기고 에러 페이지로 리다이렉션
                    response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
                }
            } else {
                request.setAttribute("loginError", "아이디 또는 비밀번호가 잘못되었습니다.");
                request.getRequestDispatcher("/user/login.jsp").forward(request, response);
            }
        }



        
        if ("join".equals(cmd)) {
            System.out.println("join cmd");
    
            String userId = request.getParameter("userId");
            String userName = request.getParameter("userName");
            String userPass = request.getParameter("userPass");

            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(userId);
            userDTO.setUserName(userName);
            userDTO.setUserPass(userPass);

            try {
                userService.join(userDTO);
                response.sendRedirect(request.getContextPath() + "/user/joinSuccess.jsp");
            } catch (Exception e) {
                request.setAttribute("errorMessage", e.getMessage()); // 에러 메시지를 request에 저장
                request.getRequestDispatcher("/user/join.jsp").forward(request, response); // 회원가입 페이지로 다시 이동
            }
        } else if ("joinForm".equals(cmd)) {
            request.getRequestDispatcher("/user/join.jsp").forward(request, response); // 회원가입 페이지로 이동
        }
        }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
}
