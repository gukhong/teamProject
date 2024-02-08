package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import domain.cart.CartDTO;
import service.CartService;
import utile.Script;


@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CartController() {
        super();
    }
    
    protected void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String cmd = req.getParameter("cmd");
    	System.out.println("cart  " +cmd);
    	CartService cartservise = new CartService();
    
    	//장바구니 뽑기
    	if(cmd.equals("list")) {
    		String userName = req.getParameter("userName");
    		
    		if(userName!=null) {
    			List<CartDTO> list = cartservise.list(userName);
    			req.setAttribute("list", list);
        		req.getRequestDispatcher("/cart/list.jsp")
        		.forward(req, res);
    		}else {
    			Script.back("로그인 해주세요 ", res);
    		}
    	}
    	
    	//장바구니 추가하기
    	else if (cmd.equals("add")) {
    		String userName = req.getParameter("userName");
    		String code = req.getParameter("code");
    		if(userName!=null) {
    			int result = cartservise.add(code, userName);
    			if(result!=0) {
    				Script.back("장바구니 담기 성공", res);
    			} else {
    				Script.back("장바구니 담기 실패", res);
    			}
    		}else {
    			Script.back("로그인 해주세요 ", res);
    		}
    		
    		
    		
			
		}
    	
    			
		
	}//process 종료

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
