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
        
        //로그인 기능
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

        //회원가입 기능
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
        
        //비밀번호 변경
        if ("updatePassword".equals(cmd)) {
            String userId = (String) request.getSession().getAttribute("user");
            String currentPassword = request.getParameter("currentPassword");
            String newPassword = request.getParameter("newPassword");
            String confirmNewPassword = request.getParameter("confirmNewPassword");

            try {
                boolean isCurrentPasswordValid = userService.checkPassword(userId, currentPassword);
                if (!isCurrentPasswordValid) {
                    // 현재 비밀번호가 일치하지 않는 경우
                    request.setAttribute("updateMessage", "현재 비밀번호가 잘못되었습니다.");
                    request.getRequestDispatcher("/user/update.jsp").forward(request, response);
                    return;
                }

                if (!newPassword.equals(confirmNewPassword)) {
                    // 새 비밀번호와 확인 비밀번호가 일치하지 않는 경우
                    request.setAttribute("updateMessage", "새 비밀번호가 일치하지 않습니다.");
                    request.getRequestDispatcher("/user/update.jsp").forward(request, response);
                    return;
                }

                // 비밀번호 업데이트
                userService.updatePassword(userId, newPassword);
                response.sendRedirect(request.getContextPath() + "/user/updateSuccess.jsp");
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("updateMessage", "비밀번호 업데이트 중 오류가 발생했습니다.");
                request.getRequestDispatcher("/user/updatePassword.jsp").forward(request, response);
            }
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
