package org.example.spring.services.impl;

import java.util.Map;

import javax.inject.Inject;

import org.example.spring.services.Action;
import org.example.spring.services.Formatter;
import org.example.spring.services.Printer;

public class DumpValueAction implements Action {

	private final Printer printer;
	private final Formatter formatter;
	private final Map<String, String> values;

	@Inject
	public DumpValueAction(Printer printer, Formatter formatter, Map<String, String> values) {
		this.values = values;
		this.printer = printer;
		this.formatter = formatter;
	}
	
	@Override
	public void execute(String data) {
		printer.print(formatter.format("VALUE: %s", values.get(data)));
	}
}
