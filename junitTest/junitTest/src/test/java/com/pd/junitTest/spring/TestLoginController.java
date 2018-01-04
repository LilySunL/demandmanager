package com.pd.junitTest.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.pd.junitTest.LoginServlet;
import com.pd.junitTest.loginTest.AuthenticationService;
import com.pd.junitTest.loginTest.FakeAuthenticationService;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServlet;
public class TestLoginController {
	private FakeAuthenticationService mockAuthenticator;
	public static String VALID_USERNAME = "validuser";
	public static String CORRECT_PASSWORD = "validpassword";		
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	public static String USER_STR = "j_username";
	public static String PASS_STR = "j_password";
	public LoginController c;
	
	
	@Before
	public void setup() {
		mockAuthenticator = new FakeAuthenticationService();
		mockAuthenticator.addUser(VALID_USERNAME, CORRECT_PASSWORD);
		
		c = new LoginController();
		c.setAuthenticationService(mockAuthenticator);

		request = new MockHttpServletRequest();
		request.setMethod("GET");
		response = new MockHttpServletResponse();
	}
	@Test
	public void wrongPasswordShouldRedirectToErrorPage()throws Exception{
		
		request.addParameter(USER_STR, "nosuchusername");
		request.addParameter(PASS_STR, "nosuchpassword");
		
		
		ModelAndView v = c.handleRequest(request, response);
		
		assertEquals("wrongpassword",v.getViewName());
		
	}
	
	@Test
	public void validLoginForwardsToFrontPage()throws Exception{
		request.setParameter(USER_STR, VALID_USERNAME);
		request.setParameter(PASS_STR, CORRECT_PASSWORD);
		
		ModelAndView v = c.handleRequest(request, response);
		
		assertEquals("frontpage", v.getViewName());
	}
	
	
}
