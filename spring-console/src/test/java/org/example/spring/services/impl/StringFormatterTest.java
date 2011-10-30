package org.example.spring.services.impl;

import static org.junit.Assert.assertEquals;

import org.example.spring.services.Formatter;
import org.junit.Test;

public class StringFormatterTest {
	@Test
	public void should_format_string_with_template() {
		// given
		Formatter formatter = new StringFormatter();
		// when
		String actual = formatter.format("A %s %d", "Hello", 1);
		// then
		assertEquals("A Hello 1", actual);
	}
}
