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

import com.shashi.beans.UserBean;
import com.shashi.service.impl.OrderServiceImpl;
import com.shashi.utility.MailMessage;

/**
 * Servlet implementation class ShipmentServlet
 */
@WebServlet("/ShipmentServlet")
public class ShipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShipmentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");

		if (userName == null || password == null) {

			response.sendRedirect("loginFirst.jsp");
		}

		UserBean user = (UserBean) session.getAttribute("userdata");
		String orderId = request.getParameter("orderid");
		Double amount = Double.parseDouble(request.getParameter("amount"));
		String status = new OrderServiceImpl().shipNow(orderId);
		String pagename = "shippedItems.jsp";
		if ("FAILURE".equalsIgnoreCase(status)) {
			pagename = "unshippedItems.jsp";
		} else {
			MailMessage.orderShipped(userName, user.getName(), orderId, amount);
		}
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		RequestDispatcher rd = request.getRequestDispatcher(pagename);

		rd.include(request, response);

		pw.println("<script>document.getElementById('message').innerHTML='" + status + "'</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
