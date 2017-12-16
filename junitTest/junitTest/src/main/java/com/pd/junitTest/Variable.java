package com.pd.junitTest;

import java.util.Map;

public class Variable implements Segment{
	private String text;
	
	public Variable(String text){this.text = text;}

	public String evaluate(Map<String, String> variables) {
		if(!variables.containsKey(text)){
			throw new MissValueException("no value for ${"+text+"}");
		}
		return variables.get(text);
	}

	
	public boolean equals(Object other){
		return text.equals(((Variable)other).text);
	}
	public int hashCode(Object other){
		return ((Variable)other).getText().hashCode();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}
