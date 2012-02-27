package org.example.spring.services.impl;

import org.example.spring.annotations.MyService;
import org.example.spring.services.Formatter;

/**
 * This is some formatter implemented using String.format method
 * 
 * @author Matthias Hryniszak
 */
@MyService // using custom stereotype annotation
public class StringFormatter implements Formatter {
	@Override
	public String format(String template, Object... params) {
		return String.format(template, params);
	}
}
