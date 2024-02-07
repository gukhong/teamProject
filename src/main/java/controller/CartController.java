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


@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CartController() {
        super();
    }
    
    protected void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String cmd = req.getParameter("cmd");
    	System.out.println(cmd);
    	CartService cartservise = new CartService();
    
    	//장바구니 뽑기
    	if(cmd.equals("list")) {
    		List<CartDTO> list = cartservise.list();
    		req.setAttribute("list", list);
    		req.getRequestDispatcher("/cart/list.jsp");
    	}
    	
    	//장바구니 추가하기
    	else if (cmd.equals("list")) {
    		BufferedReader br = req.getReader();
    		String data = br.readLine();
    		Gson gson = new Gson(); 
    		CartDTO cartdto = gson.fromJson(data, CartDTO.class);
    		int result = cartservise.add(cartdto.getCode(), cartdto.getUsername());
    		if(result ==1) {
    			req.getSession().setAttribute("cart", 1);
    		}
    
    		PrintWriter out = res.getWriter();
    		out.print("ok");
    		out.flush();
    		out.close();
    		
			
		}
    	
    			
		
	}//process 종료

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
