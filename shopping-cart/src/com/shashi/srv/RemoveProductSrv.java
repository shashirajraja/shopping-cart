package com.shashi.srv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashi.dao.ProductDaoImpl;

@WebServlet("/RemoveProductSrv")
public class RemoveProductSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RemoveProductSrv() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userType = (String)session.getAttribute("usertype");
		String userName = (String)session.getAttribute("username");
		String password = (String)session.getAttribute("password");
	
		if(userType== null || !userType.equals("admin")){
			
			response.sendRedirect("loginFirst.jsp");
			
		}
		
		else if(userName == null || password==null){
	
			response.sendRedirect("loginFirst.jsp");
		}	
		
		//login checked
		
		
		String prodId = request.getParameter("prodid");
		/*System.out.println("Here: ");
		System.out.println("Hi"+prodId+"Hi");*/
		
		PrintWriter pw = response.getWriter();
		response.setContentType("removeProduct.jsp");
		
		ProductDaoImpl product = new ProductDaoImpl();
		
		String status = product.removeProduct(prodId);
		
		RequestDispatcher rd = request.getRequestDispatcher("removeProduct.jsp");
		
		rd.include(request, response);
		
		pw.println("<script>document.getElementById('message').innerHTML='"+status+"'</script>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
