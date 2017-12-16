package com.pd.junitTest.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.*;
import org.junit.Test;

public class RegexLearningTest {

	@Test
	public void testHowGroupCountWorks() throws Exception {
		String haystak = "The needle shop sells needles";
		String regex = "(needle)";
		Matcher matcher = Pattern.compile(regex).matcher(haystak);
		assertEquals(1, matcher.groupCount());
	}

	@Test
	public void testFindStartAndEnd() throws Exception {
		String haystack = "The needle shop sells needles";
		String regex = "(needle)";
		Matcher matcher = Pattern.compile(regex).matcher(haystack);
		assertTrue(matcher.find());
		assertEquals("wrong start index of 1st match", 4, matcher.start());
		assertEquals("Wrong end index of 1st match", 10, matcher.end());
		
		assertTrue(matcher.find());
		assertEquals("wrong start index of 2st match", 22, matcher.start());
		assertEquals("Wrong end index of 2st match", 28, matcher.end());
		
		assertFalse("Should not have any more matches",matcher.find());
	}
	@Test
	public void aass() {
		// TODO Auto-generated method stub

	}
}
