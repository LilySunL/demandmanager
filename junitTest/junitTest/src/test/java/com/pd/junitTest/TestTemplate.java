package com.pd.junitTest;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;
public class TestTemplate {
	private Template template ;
	
	@Before
	public void setUp()throws Exception{
		template = new Template("${one},${two},${three}");
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
	}
	

	@Test
	public void multipleVariables() throws Exception {


		assertTemplateEvaluatesTo("1,2,3");
	}


	private void assertTemplateEvaluatesTo(String expected) {
		String templateEnd = template.evaluate();
//		System.out.println(templateEnd);
		assertEquals(expected, templateEnd);
	}

	@Test
	public void unknownVariablesAreIgnored() throws Exception {
		template.set("doesnotexist", "whatever");//不在 模版里面，不能替换
		assertTemplateEvaluatesTo("1,2,3");
	}
	
	@Test
	public void missValueRaisesException(){
		try {
			new Template("${foo}").evaluate();
			fail("evaluate shoud throw a exception ,when a variable is left without a value");
		} catch (MissValueException e) {
			assertEquals("no value for ${foo}", e.getMessage());
		}
	}
	
//	@Test
	public void variablesGetProcessedJustOnce()throws Exception{
		template.set("one", "${one}");
		template.set("two", "${three}");
		template.set("three", "${two}");
		
		assertTemplateEvaluatesTo("${one},${three},${two}");
		
	}
}
