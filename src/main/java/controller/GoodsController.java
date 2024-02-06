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
    		List<GoodsDTO> list = goodsService.제품리스트반환();
    		req.setAttribute("list", list);
    		req.getRequestDispatcher("goods/list.jsp")
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
