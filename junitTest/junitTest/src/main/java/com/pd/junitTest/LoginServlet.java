package com.pd.junitTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pd.junitTest.loginTest.AuthenticationService;

public class LoginServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("j_username");
		String password = request.getParameter("j_password");
		if(getAuthenticationService().isvalidlogin(username, password)){
			response.sendRedirect("/frontpage");
			request.getSession().setAttribute("username", username);
		}else{
			response.sendRedirect("/invalidlogin");
		}
		
	}
	
	
	protected AuthenticationService getAuthenticationService(){
		return null;
	}
}
