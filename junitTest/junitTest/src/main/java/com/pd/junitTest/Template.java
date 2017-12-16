package com.pd.junitTest;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;

import static java.util.Map.Entry;

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
		String result = templateText;
		result = replaceVariables(result);
		checkMissValue(result);
		return result;
	}

	private String replaceVariables(String result) {
		System.err.println(variables);
		for (Entry<String, String> entry : variables.entrySet()) { // 遍历 变量

			String regex = "\\$\\{" + entry.getKey()
					+ "\\}"; /* （ 以下 2 行） 用 变量 值 替换 变量 */
			result = result.replaceAll(regex, entry.getValue());

		}
		return result;
	}

	private void checkMissValue(String result) throws MissValueException {
		Matcher matcher = Pattern.compile(".*\\$\\{.+\\}.*").matcher(result);
		if (matcher.find()) {
			throw new MissValueException("no value for " + matcher.group());
		}
	}
}
