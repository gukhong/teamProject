package domain.goods.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//임대현 : 재품 DTO 필드는 모든 열이름
public class GoodsDTO {
	private String code; 					// 상품코드(이름_타입_발간(년도)) <- 사진 등록시 사용
	private String bookname; 			// 책이름
	private String booktype; 				// 책타입(요리,소설,it, ... 등)
	private int bookprice;					// 책가격
	private String publisher; 				// 출판사(예-한빛)
	private String author; 				// 작가(작가미상으로 null허용)
	private int stack; 						// 재고
	private Date publicationdate; 		// 발간일
	private Date registerdate;			// 상품 등록일(기본-시스템 시간)
	private String smallcontent; 			// 간량한 설명
	private String detailcontent; 		// 상세설명(summerNote)

}
