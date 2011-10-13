package org.example.spring.services.impl;

import static org.junit.Assert.assertEquals;

import org.example.spring.services.Printer;
import org.example.spring.services.Action;
import org.junit.Test;

public class PrintActionTest {
	private static final String HELLO_WORLD = "Hello, world!";
	
	private String msg = "";
	
	@Test
	public void should_properly_process_the_given_data() {
		Action processor = new PrintAction(mockPrinter());
		processor.execute(HELLO_WORLD);
		assertEquals("The message is " + HELLO_WORLD, msg);
	}

	private Printer mockPrinter() {
		return new Printer() {
			@Override
			public void print(String message) {
				msg = message;
			}
		};
	}
}
