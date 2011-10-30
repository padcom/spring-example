package org.example.spring.services.impl;

import org.example.spring.services.Formatter;
import org.springframework.stereotype.Component;

/**
 * This is some formatter implemented using String.format method
 * 
 * It uses the Spring stereotype annotation 
 * 
 * @author Matthias Hryniszak
 */
@Component
public class StringFormatter implements Formatter {
	@Override
	public String format(String template, Object... params) {
		return String.format(template, params);
	}
}
