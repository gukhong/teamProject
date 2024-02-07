package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.goods.dto.GoodsDTO;
import service.GoodsService;

@WebServlet("/goods")
public class GoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GoodsController() {
        super();
    }



    //임대현 : get, post 전송타입 상관없이 처리하겠다.
    // requset -> req , response -> res
    protected void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String cmd = req.getParameter("cmd");
    	GoodsService goodsService = new GoodsService();
    	System.out.println(cmd);

    	//리스트 페이지 요청
    	if(cmd.equals("list")) {
    		int page = Integer.parseInt(req.getParameter("page"));//필요정보 받아오기
    		List<GoodsDTO> list = goodsService.listAll(page);  //리턴할 리스트 만들기
    		int goodscount = goodsService.count(); // 총상품 갯수 리턴
    		int lastpage = 0; 
    		if(goodscount%5==0) {
    			lastpage = (goodscount-1)/5;
    		}else {
    			lastpage = goodscount/5;
    		}
    		
    		//보낼정보 담아주기
    		req.setAttribute("page", page);
    		req.setAttribute("list", list);
    		req.setAttribute("lastpage", lastpage);
    		
    		//페이지 이동
    		req.getRequestDispatcher("goods/list.jsp")
    		.forward(req, res);
    	}
    	
    	//상세보기
    	else if (cmd.equals("detail")) {
    		String code = req.getParameter("code"); //기준이 되는 코드값 받아오기
    		GoodsDTO dto = goodsService.detailview(code); //코드값에 맞는 1개의 레코드 불러오기 (dto type)
    		
    		req.setAttribute("dto", dto); //request 내장객체에 1개 레코드 담아주기
    		req.getRequestDispatcher("/goods/detail.jsp")
    		.forward(req, res);
    		
    	}






    }













    //get전송
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	//post전송
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
