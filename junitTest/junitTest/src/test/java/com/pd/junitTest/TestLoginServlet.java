package com.pd.junitTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import static org.junit.Assert.*;

import java.io.IOException;

public class TestLoginServlet {

	@Test
	public void wrongPasswordShouldRedirectToErrorPage() throws Exception {
		HttpServlet servlet = new LoginServlet();
		MockHttpServletRequest request = new MockHttpServletRequest("GET", "/login");

		request.addParameter("j_username", "nosuchuser");
		request.addParameter("j_password", "wrongpasswor");

		MockHttpServletResponse response = new MockHttpServletResponse();

		servlet.service(request, response);
		assertEquals("/invalidlogin", response.getRedirectedUrl());
	}

	@Test
	public void validLoginForwardToFrontPageAndStroresUsername() throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpServlet servlet = new LoginServlet();
		MockHttpServletRequest request = new MockHttpServletRequest("GET", "login");
		request.addParameter("j_username", "validuser");
		request.addParameter("j_password", "correctpassword");
		MockHttpServletResponse response = new MockHttpServletResponse();
		servlet.service(request, response);
		assertEquals("/frontpage", response.getRedirectedUrl());
		assertEquals("validuser", request.getSession().getAttribute("username"));
	}
}
