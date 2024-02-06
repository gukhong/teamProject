package service;

import java.util.List;

import domain.goods.GoodsDAO;
import domain.goods.dto.GoodsDTO;

public class GoodsService {

	//필드
	private GoodsDAO goodDAO = new GoodsDAO() ;

	public List<GoodsDTO> 제품리스트반환() {
		return goodDAO.goodslist();
	}

}
