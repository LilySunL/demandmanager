package com.pd.junitTest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.pd.junitTest.loginTest.AuthenticationService;
import com.pd.junitTest.loginTest.FakeAuthenticationService;

public class TestLoginServlet {

	private FakeAuthenticationService authenticator;
	public static String VALID_USERNAME = "validuser";
	public static String CORRECT_PASSWORD = "validpassword";		
	private HttpServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	public static String USER_STR = "j_username";
	public static String PASS_STR = "j_password";
	
	@Test
	public void wrongPasswordShouldRedirectToErrorPage() throws Exception {

		
		request.addParameter(USER_STR, VALID_USERNAME);
		request.addParameter(PASS_STR, "wrongpasswor");


		servlet.service(request, response);
		assertEquals("/invalidlogin", response.getRedirectedUrl());
	}

	@Test
	public void validLoginForwardToFrontPageAndStroresUsername() throws ServletException, IOException {
		request.addParameter(USER_STR, VALID_USERNAME);
		request.addParameter(PASS_STR, CORRECT_PASSWORD);
		servlet.service(request, response);
		assertEquals("/frontpage", response.getRedirectedUrl());
		assertEquals("validuser", request.getSession().getAttribute("username"));
	}

	@Before
	private void setup() {
		authenticator = new FakeAuthenticationService();
		authenticator.addUser(VALID_USERNAME, CORRECT_PASSWORD);
		
		
		servlet = new LoginServlet(){
			@Override
			protected AuthenticationService getAuthenticationService(){
				return authenticator;
			}
		};

		request = new MockHttpServletRequest("GET", "login");
		response = new MockHttpServletResponse();
	}
}
