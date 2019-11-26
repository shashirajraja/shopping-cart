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

import com.shashi.beans.ProductBean;
import com.shashi.beans.DemandBean;
import com.shashi.dao.CartDaoImpl;
import com.shashi.dao.DemandDaoImpl;
import com.shashi.dao.ProductDaoImpl;

/**
 * Servlet implementation class UpdateToCart
 */
@WebServlet("/UpdateToCart")
public class UpdateToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateToCart() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("username");
		String password = (String)session.getAttribute("password");
	
		if(userName == null || password==null){
	
			response.sendRedirect("loginFirst.jsp");
		}	
		
		//login Check Successfull
		
		
		String userId = userName;
		String prodId = request.getParameter("pid");		
		int pQty = Integer.parseInt(request.getParameter("pqty"));
		
		CartDaoImpl cart = new CartDaoImpl();
		
		
		ProductDaoImpl productDao = new  ProductDaoImpl();
		
		ProductBean product= productDao.getProductDetails(prodId);
		
		int availableQty = product.getProdQuantity();
		
		PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		if(availableQty < pQty) {
			
			
			String status = cart.updateProductToCart(userId, prodId, availableQty);
			
			status = "Only "+availableQty+" no of "+product.getProdName()+" are available in the shop! So we are adding only "+availableQty+" products into Your Cart"
					+ "";
			
			
			DemandBean demandBean = new DemandBean(userName,product.getProdId(),pQty-availableQty);
			
			DemandDaoImpl demand = new DemandDaoImpl();
			
			boolean flag = demand.addProduct(demandBean);
			
			if(flag)
				status += "<br/>Later, We Will Mail You when "+product.getProdName()+" will be available into the Store!";
			
			RequestDispatcher rd = request.getRequestDispatcher("cartDetails.jsp");
			
			rd.include(request, response);
			
			pw.println("<script>document.getElementById('message').innerHTML='"+status+"'</script>");
			
		}
		else {
			String status = cart.updateProductToCart(userId, prodId, pQty);
			
			RequestDispatcher rd = request.getRequestDispatcher("cartDetails.jsp");
			
			rd.include(request, response);
			
			pw.println("<script>document.getElementById('message').innerHTML='"+status+"'</script>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
