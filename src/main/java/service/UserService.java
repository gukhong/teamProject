package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.DBConnection;
import domain.user.dto.UserDTO;

public class UserService {
    public boolean isUserExist(String userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
           System.out.println("커넥션객체 반환");
            String sql = "SELECT userId FROM user_info WHERE userId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true; // 사용자가 존재합니다.
            } else {
                return false; // 사용자가 존재하지 않습니다.
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }

        return false;
    }

    public void join(UserDTO userDTO) throws Exception {
        if (isUserExist(userDTO.getUserId())) {
            throw new Exception("존재하는 사용자입니다."); // 예외를 발생시켜 메시지를 전달합니다.
        }

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.getConnection();

            String sql = "INSERT INTO user_info (idx, userId, userName, userPass, registerDate) VALUES (user_seq.NEXTVAL, ?, ?, ?, SYSDATE)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userDTO.getUserId());
            pstmt.setString(2, userDTO.getUserName());
            pstmt.setString(3, userDTO.getUserPass());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, pstmt);
        }
    }
    
    public boolean login(String userId, String userPass) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
    		conn = DBConnection.getConnection();
    		String sql = "SELECT userId FROM user_info WHERE userId = ? AND userPass = ?";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, userId);
    		pstmt.setString(2, userPass);
    		
    		rs = pstmt.executeQuery();
			
    		if(rs.next()) {
    			return true; //사용자가 존재하고 비밀번호가 일치하는 경우
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, rs);
		}
    	return false; //사용자가 존재하지 않거나 비밀번호가 일치하지 않는 경우
    	
    }
    
    public UserDTO getUserDetails(String userId) throws Exception {
    	Connection conn = null;
    	PreparedStatement pstmt = null;;
    	ResultSet rs = null;
    	UserDTO userDTO = null;
    	
    	try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM user_info WHERE userId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userDTO = new UserDTO();
				userDTO.setUserId(rs.getString("userId"));
				userDTO.setUserName(rs.getString("userName"));
				userDTO.setUserPass(rs.getString("userPass"));
				//다른 필요한 필드도 설정가능
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBConnection.close(conn,  pstmt, rs);
		}
    	return userDTO;
    }
}
 
    



