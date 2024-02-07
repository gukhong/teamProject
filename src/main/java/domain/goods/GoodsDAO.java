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

  //전체리스르 반환
  	public List<GoodsDTO> goodslist(int page){
  		con = DBConnection.getConnection();
  		List<GoodsDTO> list = new ArrayList<GoodsDTO>(); //리턴할 list
  		String query = "select * from "
  						+ " (select rownum as rnum , td.* from (select * from book_info) td)"
  						+ " where rnum between ? and ?";
  		int start = 1+page*5;
  		try {
  			psmt = con.prepareStatement(query);
  			psmt.setInt(1,start);
  			psmt.setInt(2,start+4);
  			rs = psmt.executeQuery();
  			while (rs.next()) {
  				GoodsDTO dto = new GoodsDTO();
  				dto = GoodsDTO.builder()
  						. code(rs.getString("code")) 						
  						.  bookname(rs.getString("bookname")) 					
  						.  booktype(rs.getString("booktype")) 		
  						 . bookprice(rs.getInt("bookprice"))		
  						.  publisher(rs.getString("publisher")) 			
  						.  author(rs.getString("author")) 							
  						.  stack(rs.getInt("stack"))													
  						.  publicationdate(rs.getDate("publicationdate"))						
  						.  registerdate(rs.getDate("registerdate"))		
  						.  smallcontent(rs.getString("smallcontent")) 					
  						.  detailcontent(rs.getString("detailcontent")) 	
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
  		}//goodslist마지막
  	
  	//총 상품 갯수 리턴
  	public int count() {
  		con = DBConnection.getConnection();
  		int result = 0;
  		String query = "select count(*) as num from book_info";
  		
  		try {
  			stmt = con.createStatement();
  			rs = stmt.executeQuery(query);
  			if(rs.next()){
  			result = rs.getInt("num");
  			}
  		} catch (SQLException e) {
  			e.printStackTrace();
  		} finally {
  			DBConnection.close(con, stmt, rs);
  		}
  		
  		return result; 
  	}
  	
  	//1개 상품 상세보기
  	public GoodsDTO findCodeDetail(String code) {
  		con = DBConnection.getConnection();
  		GoodsDTO dto = null;
  		String query = "select * from book_info where code=?";
  		
  		try {
  			psmt = con.prepareStatement(query);
  			psmt.setString(1, code);
  			rs = psmt.executeQuery();
  			if(rs.next()) {
  				dto = GoodsDTO.builder()
  						. code(rs.getString("code")) 						
  						.  bookname(rs.getString("bookname")) 					
  						.  booktype(rs.getString("booktype")) 		
  						 . bookprice(rs.getInt("bookprice"))		
  						.  publisher(rs.getString("publisher")) 			
  						.  author(rs.getString("author")) 							
  						.  stack(rs.getInt("stack"))													
  						.  publicationdate(rs.getDate("publicationdate"))						
  						.  registerdate(rs.getDate("registerdate"))		
  						.  smallcontent(rs.getString("smallcontent")) 					
  						.  detailcontent(rs.getString("detailcontent")) 	
  						.build();
  			}
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} finally {
  			DBConnection.close(con, stmt, rs);
  		}
  		
  		return dto ;
  	}

}//클래스 마지막




