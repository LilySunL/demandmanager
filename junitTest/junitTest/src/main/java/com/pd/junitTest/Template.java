package com.pd.junitTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Template {
	private Map<String, String> variables; // 用 散 列表 存储 变量
	private String templateText;

	public Template(String templateText) {
		this.variables = new HashMap<String, String>(); // 用 散 列表 存储 变量
		this.templateText = templateText;
	}

	public void set(String name, String value) { /* （ 以下 3 行） 用 散 列表 存储 变量 */
		this.variables.put(name, value);
	}

	public String evaluate() {
		TemplateParse parser = new TemplateParse();
		List<Segment> segments = parser.parseSegments(templateText);
		StringBuilder sb = concatenate(segments);
		return sb.toString();
	}

	private StringBuilder concatenate(List<Segment> segments) {
		StringBuilder result = new StringBuilder();
		for (Segment segment : segments) {
			result.append(segment.evaluate(variables));
		}
		return result;
	}

}
