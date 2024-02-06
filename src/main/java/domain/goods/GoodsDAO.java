package domain.goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;
import domain.goods.dto.GoodsDTO;

public class GoodsDAO {
	//필드
    Connection con;
    PreparedStatement psmt ;
    Statement stmt ;
    ResultSet rs ;

	public List<GoodsDTO> goodslist(){

		List<GoodsDTO> list = new ArrayList<>(); //리턴할 list
		new DBConnection();
		con = DBConnection.getConnection(); // 커넥션 열결
		String query = "select * from book_info";// 쿼리문 작성

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				GoodsDTO dto = new GoodsDTO();
				dto.setCode(rs.getString("code"));
				dto.setBookname(rs.getString("Bookname"));
				dto.setAuthor(rs.getString("author"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;


		}//goodslist마지막

}//클래스 마지막




