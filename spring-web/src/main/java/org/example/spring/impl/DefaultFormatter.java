package org.example.spring.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.example.spring.Formatter;

@Named
public class DefaultFormatter implements Formatter {
	@Inject
	private HttpServletRequest request;
	
	@Inject
	private HttpSession session;
	
	@Override
	public String format(String template, Object... params) {
		System.out.println("Here: " + request);
		System.out.println("Here: " + session);
		return String.format(template, params);
	}
}
