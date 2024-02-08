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
    	System.out.println("cart cmd :  " +cmd);
    	CartService cartservise = new CartService();
    
    	//장바구니 뽑기
    	if(cmd.equals("list")) {
    		String userName = req.getParameter("userName");
 
    			List<CartDTO> list = cartservise.list(userName);
    			req.setAttribute("list", list);
        		req.getRequestDispatcher("/cart/list.jsp")
        		.forward(req, res);
    	}
    	
    	//장바구니 추가하기
    	else if (cmd.equals("add")) {
    		String userName = req.getParameter("userName");
    		String code = req.getParameter("code");
 
			int result = cartservise.add(code, userName);
			if (result != 0) {
				Script.back("장바구니 담기 성공", res);
			} else {
				Script.back("장바구니 담기 실패", res);
			}

		}
    	
    	//장바구니 비우기
    	else if(cmd.equals("deleteAll")) {
    		String userName = req.getParameter("userName");
    		int  result = cartservise.deleteAll(userName);
    		System.out.println("result = " +result);
    		if(result !=0) {
    			Script.alertmsg("장바구니 비우기 성공", "goods?cmd=list&page=0", res);
    		}else {
    			Script.back("장바구니 비우기 실패", res);
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
