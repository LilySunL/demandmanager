package com.pd.junitTest;

import java.util.Map;

public class PlainText implements Segment{
	private String text;
	
	public PlainText(String text){this.text = text;}
	
	public String evaluate(Map<String, String> variables) {
		return text;
	}
	
	public boolean equals(Object other){
		return text.equals(((PlainText)other).text);
	}

	public int hashCode(Object other){
		return ((PlainText)other).getText().hashCode();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	
	
}
