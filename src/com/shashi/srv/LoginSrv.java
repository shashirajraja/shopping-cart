package com.shashi.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashi.beans.StudentBean;
import com.shashi.beans.UserBean;
import com.shashi.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginSrv
 */
@WebServlet("/LoginSrv")
public class LoginSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginSrv() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String userType = request.getParameter("usertype");
		String concordiaId = request.getParameter("concordiaId");
		response.setContentType("text/html");

		String status = "Login Denied! Invalid Username or password.";

		if (userType.equals("admin")) { // Login as Admin

			if (password.equals("admin") && userName.equals("admin@gmail.com")) {
				// valid

				RequestDispatcher rd = request.getRequestDispatcher("adminViewProduct.jsp");

				HttpSession session = request.getSession();

				session.setAttribute("username", userName);
				session.setAttribute("password", password);
				session.setAttribute("usertype", userType);

				rd.forward(request, response);

			} else {
				// Invalid;
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp?message=" + status);
				rd.include(request, response);
			}

		} else { // Login as student

			UserServiceImpl udao = new UserServiceImpl();

			status = udao.isValidCredential(userName, password, concordiaId);

			if (status.equalsIgnoreCase("valid")) {
				// valid user

				StudentBean user = udao.getStudentDetails(userName, password);

				HttpSession session = request.getSession();

				session.setAttribute("userdata", user);

				session.setAttribute("username", userName);
				session.setAttribute("password", password);
				session.setAttribute("usertype", userType);

				RequestDispatcher rd = request.getRequestDispatcher("userHome.jsp");

				rd.forward(request, response);

			} else {
				// invalid user;

				RequestDispatcher rd = request.getRequestDispatcher("login.jsp?message=" + status);

				rd.forward(request, response);

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
