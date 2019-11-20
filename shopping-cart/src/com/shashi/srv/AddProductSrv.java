package com.shashi.srv;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.shashi.dao.ProductDaoImpl;

/**
 * Servlet implementation class AddProductSrv
 */
@WebServlet("/AddProductSrv")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddProductSrv() {
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
		
		
		
		String status = "Product Registration Failed!";
		String prodName = request.getParameter("name");
		String prodType = request.getParameter("type");
		String prodInfo = request.getParameter("info");
		double prodPrice = Double.parseDouble(request.getParameter("price"));
		int prodQuantity = Integer.parseInt(request.getParameter("quantity"));
		
		Part part = request.getPart("image");
		
		InputStream inputStream = part.getInputStream();
		
		InputStream prodImage = inputStream;
		
		ProductDaoImpl product = new ProductDaoImpl();
		
		status = product.addProduct(prodName, prodType, prodInfo, prodPrice, prodQuantity, prodImage);
		
		RequestDispatcher rd = request.getRequestDispatcher("addProduct.jsp");
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		rd.include(request, response);
		pw.println("<script>document.getElementById('message').innerHTML='"+status+"'</script>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
