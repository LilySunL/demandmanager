package com.pd.junitTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TemplateParseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void emptyTemplateRendersAsEmptyString() throws Exception {
		List<Segment> segments = parse("");
		assertSegments(segments,new PlainText(""));
	}

	@Test
	public void templateWithOnlyPlainText() throws Exception {
		List<Segment> segments = parse("plain text only");
		assertSegments(segments,new PlainText("plain text only"));
	}

	private void assertSegments(List<Segment> segments,Object ...expected) {
		assertEquals("Number of segments doesn't match.", expected.length, segments.size());
		assertEquals(Arrays.asList(expected), segments);
	}

	private List<Segment> parse(String template) {
		TemplateParse parse = new TemplateParse();
		List<Segment> segments = parse.parseSegments(template);
		return segments;
	}
	
	
	@Test
	public void parsingMultipleVariables()throws Exception{
		List<Segment> segments = parse("${a}:${b}:${c}");
		assertSegments(segments, new Variable("a"),new PlainText(":"),
				new Variable("b"),new PlainText(":"),new Variable("c"));
	}
	
	@Test
	public void parsingTemplateIntoSegmentObject()throws Exception{
		TemplateParse p = new TemplateParse();
		List<Segment> segments = p.parseSegments("a ${b} c ${d}");
		
		assertSegments(segments,new PlainText("a "),new Variable("b"),new PlainText(" c "),new Variable("d"));
	}

}
