package org.example.spring.services.impl;

import org.example.spring.services.Printer;
import org.springframework.beans.factory.annotation.Value;

public class PrefixedPrinter implements Printer {
	private String prefix;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	@Override
	public void print(String message) {
		System.out.println(prefix + ": " + message);
	}
}
