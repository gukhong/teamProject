package domain.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDTO {
	private String username;
	private String code;
	private String bookname;
	private int bookprice;
	private String author;
	private int stack;
}
