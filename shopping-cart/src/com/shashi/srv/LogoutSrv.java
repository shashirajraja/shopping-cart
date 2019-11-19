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

/**
 * Servlet implementation class LogoutSrv
 */
@WebServlet("/LogoutSrv")
public class LogoutSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LogoutSrv() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("username", null);
		session.setAttribute("password", null);
		session.setAttribute("usertype", null);
		session.setAttribute("userdata", null);
		
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		
		rd.include(request, response);
		
		pw.print("<script>document.getElementById('message').innerHTML='Successfully Logged Out!'</script>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
