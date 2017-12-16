package com.pd.junitTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		List<String> segments = parser.parse(templateText);
		StringBuilder sb = new StringBuilder();
		for (String segment : segments) {
			append(segment, sb);
		}
		return sb.toString();
	}

	private void append(String segment, StringBuilder result) {
		if (segment.startsWith("${") && segment.endsWith("}")) {
			String var = segment.substring(2, segment.length() - 1);
			if (!variables.containsKey(var)) {
				throw new MissValueException("no value for " + segment);
			}
			result.append(variables.get(var));

		} else {
			result.append(segment);
		}
	}

}
