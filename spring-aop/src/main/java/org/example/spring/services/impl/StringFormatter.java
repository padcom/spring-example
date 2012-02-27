package org.example.spring.services.impl;

import org.example.spring.services.Formatter;

import javax.inject.Named;

/**
 * This is some formatter implemented using String.format method
 * 
 * @author Matthias Hryniszak
 */
@Named("string-formatter") // the string here is optional. Default: "stringFormatter"
public class StringFormatter implements Formatter {
	@Override
	public String format(String template, Object... params) {
		return String.format(template, params);
	}
}
