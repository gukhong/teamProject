package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReviewController() {
        super();
    }

    //임대현 : get, post 전송타입 상관없이 처리하겠다.
    // requset -> req , response -> res
    protected void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String cmd = req.getParameter("cmd");


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
