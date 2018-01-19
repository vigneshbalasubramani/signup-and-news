package com.ztech.vignesh.servlets;

import java.io.IOException;
import com.ztech.vignesh.constants.ServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ztech.vignesh.beans.*;
import com.ztech.vignesh.dao.*;

@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyFirstServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean userBean = new UserBean();
		UserBeanValidator userBeanValidator = new UserBeanValidator();
		ServletDAO servletDAO = new ServletDAO();
		String invalidField = null;
		
		try {
			if(userBeanValidator.setFirstName(request.getParameter("firstname"))) {
				userBean.setFirstname(request.getParameter("firstname"));
			}
			else{
				invalidField = "firstName";
			}
			if(userBeanValidator.setLastName(request.getParameter("lastname"))){
				userBean.setLastname(request.getParameter("lastname"));
			}
			else {
				invalidField = "lastName";
			}
			if(userBeanValidator.setPhone(request.getParameter("phone"))) {
				userBean.setPhone(request.getParameter("phone"));
			}
			else {
				invalidField = "phone";
			}
			if(userBeanValidator.setEmail(request.getParameter("email"))) {
				userBean.setEmail(request.getParameter("email"));
			}
			else {
				invalidField = "email";
			}
			if(userBeanValidator.setPassword(request.getParameter("password"))) {
				userBean.setPassword(request.getParameter("password"));
			}
			else {
				invalidField = "password";
			}
			if(invalidField == null) {
			servletDAO.insertUserDetails(userBean);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.html");
			requestDispatcher.include(request, response);
			}
			else {
				response.getWriter().append(ServletConstants.INVALID_DETAILS + " : " + invalidField);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
				requestDispatcher.include(request, response);
			}
		} catch (Exception e) {
//			e.printStackTrace();
			response.getWriter().append(ServletConstants.INVALID_DETAILS);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
			requestDispatcher.include(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
