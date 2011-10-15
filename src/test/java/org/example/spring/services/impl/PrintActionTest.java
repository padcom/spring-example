package org.example.spring.services.impl;

import static org.junit.Assert.assertEquals;

import org.example.spring.services.Formatter;
import org.example.spring.services.Printer;
import org.example.spring.services.Action;
import org.junit.Test;

public class PrintActionTest {
	private static final String HELLO_WORLD = "Hello, world!";
	
	private String msg = "";
	
	@Test
	public void should_properly_process_the_given_data() {
		Action processor = new PrintAction(mockPrinter(), mockFormatter());
		processor.execute(HELLO_WORLD);
		assertEquals(HELLO_WORLD, msg);
	}

	private Printer mockPrinter() {
		return new Printer() {
			@Override
			public void print(String message) {
				msg = message;
			}
		};
	}

	private Formatter mockFormatter() {
		return new Formatter() {
			@Override
			public String format(String template, Object... params) {
				return (String) params[0];
			}
		};
	}

}
