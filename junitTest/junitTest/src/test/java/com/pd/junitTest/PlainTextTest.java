package com.pd.junitTest;


import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class PlainTextTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void evaluateTextAsIs() {
		Map<String,String> variables = new HashMap<>();
		String text = "abc def";
		assertEquals(text, new PlainText(text).evaluate(variables));
	}

}
