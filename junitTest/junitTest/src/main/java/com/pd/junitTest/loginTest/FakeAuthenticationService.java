package com.pd.junitTest.loginTest;

import java.util.HashMap;
import java.util.Map;

public class FakeAuthenticationService implements AuthenticationService{

	private Map<String,String> users = new HashMap<>();
	
	public void addUser(String user,String pass) {
		users.put(user, pass);
	}
	
	@Override
	public boolean isvalidlogin(String username, String password) {
		return users.containsKey(username)
				&& password.equals(users.get(username));
	}
	
}
