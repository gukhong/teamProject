package domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.DBConnection;
import domain.user.dto.UserDTO;

public class UserDAO {

    public void insertUser(UserDTO userDTO) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "INSERT INTO USER_INFO (IDX, USERID, USERNAME, USERPASS, REGISTERDATE) VALUES (USER_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
            System.out.println("db연결 성공");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userDTO.getUserId());
            pstmt.setString(2, userDTO.getUserName());
            pstmt.setString(3, userDTO.getUserPass());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

