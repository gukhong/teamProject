package service;

import java.util.List;

import domain.goods.GoodsDAO;
import domain.goods.dto.GoodsDTO;

public class GoodsService {

	//필드
	private GoodsDAO goodsDAO = new GoodsDAO() ;

	public List<GoodsDTO> listAll(int page) {
		return goodsDAO.goodslist(page);
	}
	
	public int count() {
		return goodsDAO.count();
	}
	
	public GoodsDTO detailview(String code) {
		return goodsDAO.findCodeDetail(code);
	}

}
