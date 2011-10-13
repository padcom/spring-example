package org.example.spring.services.impl;

import org.example.spring.services.Action;
import org.example.spring.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintAction implements Action {
	private final Printer printer;

	@Autowired
	public PrintAction(Printer printer) {
		this.printer = printer;
	}

	@Override
	public void execute(String data) {
		printer.print("The message is " + data);
	}
}
