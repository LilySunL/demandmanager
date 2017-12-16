package com.pd.junitTest;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class VariableTest {

	private Map<String, String> variables;
	@Before
	public void setUp() throws Exception {
		variables = new HashMap<>();
	}

	@Test
	public void evaluateVariableAsIs() {
		Map<String,String> variables = new HashMap<>();
		String name = "myname";
		String value = "myvalue";
		variables.put(name, value);
		assertEquals(value, new Variable(name).evaluate(variables));
	}
	@Test
	public void missingVariableRaisesException()throws Exception{
		String name = "abc";
		try {
			new Variable(name).evaluate(variables);
			fail("Miss variable shoud raise an exception");
		} catch (MissValueException e) {
			assertEquals("no value for ${"+name+"}", e.getMessage());
		}
	}
}
