package service;

import java.util.List;

import domain.cart.CartDAO;
import domain.cart.CartDTO;

public class CartService {
	
	// 필드
	CartDAO cartDAO = new CartDAO();
	
	// 장바구니 리스트
	public List<CartDTO> list (String userName){
		return cartDAO.list(userName);
	}
	
	//장바구니 추가
	public int add (String code , String userName) {
		return cartDAO.add(code, userName);
	}

}
