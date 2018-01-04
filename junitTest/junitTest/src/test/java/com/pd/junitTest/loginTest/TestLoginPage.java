package com.pd.junitTest.loginTest;

import org.junit.Test;

import com.pd.junitTest.MyJspTestCase;

public class TestLoginPage extends MyJspTestCase{
	
	
	public void testFormFieldsArePresent()throws Exception{
		get("/login.jsp");
		form().shouldHaveField("j_username");
		form().shouldHaveField("j_password");
		
		form().shouldHaveSubmitButton("login");
		
	}
}
