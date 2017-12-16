package com.pd.junitTest;

import java.util.Map;

public interface Segment {

//	public void append(StringBuilder result, Map<String, String> variables) ;
	String evaluate(Map<String,String> variables);
	String getText();
}
