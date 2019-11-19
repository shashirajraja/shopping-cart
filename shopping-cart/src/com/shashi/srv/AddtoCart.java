package com.shashi.srv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.dao.UserDaoImpl;

/**
 * Servlet implementation class AddtoCart
 */
@WebServlet("/AddtoCart")
public class AddtoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public AddtoCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("uid");
		String prodId = request.getParameter("pid");
		
		UserDaoImpl user = new UserDaoImpl();
		
		String status = user.addProductToCart(userId, prodId);
		
		PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		RequestDispatcher rd = request.getRequestDispatcher("userHome.jsp");
		
		rd.include(request, response);
		
		pw.print("<script>alert('"+status+"')</script>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
