package com.pd.junitTest.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.pd.junitTest.loginTest.AuthenticationService;


public class LoginController implements  Controller {

	private AuthenticationService authenticator;
	
	public void setAuthenticationService(AuthenticationService authenticator){
		this.authenticator = authenticator;
	}
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("j_username");
		String password = request.getParameter("j_password");
		if(authenticator.isvalidlogin(username, password)){
			return new ModelAndView("frontpage");
		}else{
			
			return new ModelAndView("wrongpassword");
		}
	}


}
