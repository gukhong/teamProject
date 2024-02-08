package domain.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;

public class CartDAO {
	
	//field
	Connection con ;
	PreparedStatement psmt ;
	Statement stmt;
	ResultSet rs;
	
	public List<CartDTO> list(String userName){
		con = DBConnection.getConnection();
		List<CartDTO> list = new ArrayList<CartDTO>();
		String query = "select * from cart where username = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, userName);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CartDTO dto = new CartDTO();
				dto = CartDTO.builder()
						.username(rs.getString("username"))
						.code(rs.getString("code"))
						.bookname(rs.getString("bookname"))
						.author(rs.getString("author"))
						.bookprice(rs.getInt("bookprice"))
						.stack(rs.getInt("stack"))
						.build();
				list.add(dto);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, stmt, rs);
		}
		

		return list;
		
	} 
	
	public int add(String code , String userName) {
		int result = 0 ;
		CartDTO cartDTO = new CartDTO();
		con = DBConnection.getConnection();
		String sql = "select * from book_info where code = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, code);
			rs = psmt.executeQuery();
			if(rs.next()) {
				cartDTO = CartDTO.builder()
						.bookname(rs.getString("bookname"))
						.bookprice(rs.getInt("bookprice"))
						.author(rs.getString("author"))
						.stack(rs.getInt("stack"))
						.build();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, stmt, rs);
		}
		
		con = DBConnection.getConnection();
		String query = "insert into cart (username ,code ,bookname, bookprice, author, stack )"
						 + " values (?,?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1,userName );
			psmt.setString(2, code);
			psmt.setString(3, cartDTO.getBookname());
			psmt.setInt(4, cartDTO.getBookprice());
			psmt.setString(5, cartDTO.getAuthor());
			psmt.setInt(6, cartDTO.getStack());
			result = psmt.executeUpdate();
			
			System.out.println();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, stmt);
		}
		
		
		
		return result ;
		
	}
	
	
	
}
