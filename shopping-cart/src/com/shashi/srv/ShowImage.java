package com.shashi.srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.dao.ProductDaoImpl;

@WebServlet("/ShowImage")
public class ShowImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ShowImage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prodId = request.getParameter("pid");
		
		//System.out.print("ProdId= "+prodId+" Image is available: ");

		ProductDaoImpl dao = new ProductDaoImpl();
		
		byte[] image = dao.getImage(prodId);
		
		//System.out.print("ProdId= "+prodId+" Image is available: ");
		
		ServletOutputStream sos = null;

		sos = response.getOutputStream();
		
		sos.write(image);
		/*
		sos.flush();
		
		sos.close();*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
