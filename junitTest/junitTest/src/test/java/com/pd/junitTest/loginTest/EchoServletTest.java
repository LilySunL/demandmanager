package com.pd.junitTest.loginTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import static org.junit.Assert.*;
public class EchoServletTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEchoingParaetersWithMultipleValues()throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		request.addParameter("param1", "param1value1");
		request.addParameter("param2", "param2value1");
		request.addParameter("param2", "param2value2");
		
		new EchoServlet().doGet(request, response);
		String [] lines = response.getContentAsString().split("\n");
		assertEquals("Expected as many lines as we have parameter values ",
				3,lines.length);
		assertEquals("param1=param1value1", lines[0]);
		assertEquals("param2=param2value1", lines[1]);
		assertEquals("param2=param2value2", lines[2]);
	}

}
