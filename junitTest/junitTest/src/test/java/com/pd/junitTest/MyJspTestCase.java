package com.pd.junitTest;

import net.sf.jsptest.HtmlTestCase;

public class MyJspTestCase extends HtmlTestCase{
	protected String getWebRoot(){
		return "./websrc/jsp";
	}
}
