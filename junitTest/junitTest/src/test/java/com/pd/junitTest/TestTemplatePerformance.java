package com.pd.junitTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
public class TestTemplatePerformance {
	private Template template;

	@Before
	public void setUp() {
		StringBuilder templateText = new StringBuilder(512);

		for (int i = 0; i < 100; i++) {
			templateText.append("${").append(i).append("},");
		}
		templateText.setLength(templateText.length() - 1);
		template = new Template(templateText.toString());
		for (int i = 0; i < 100; i++) {
			template.set(i + "", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + i);
		}
	}
	
	@Test
	public void templatewith100WordAnd20Variables() throws Exception {
		long expected = 200L;
		long time = System.currentTimeMillis();
		template.evaluate();
		time = System.currentTimeMillis() - time;
		assertTrue("Rendering the template took " + time + "ms while the target was " + expected + "ms",
				time <= expected);
	}
}
