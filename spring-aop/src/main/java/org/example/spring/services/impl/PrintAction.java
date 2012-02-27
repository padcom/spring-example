package org.example.spring.services.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.spring.services.Action;
import org.example.spring.services.Formatter;
import org.example.spring.services.Printer;

/**
 * This is some example action class. All it does is it uses a formatter to dump the input
 * 
 * It uses the JSR-330 annotations to stay IoC container agnostic.
 * The default bean name is derived from class name with the first letter lower-case
 * so "PrintAction" becomes "printAction" bean instance   
 * 
 * @author Matthias Hryniszak
 */
@Named 
public class PrintAction implements Action {
	private final Printer printer;

	@Inject // this field is injected - optional field
	private Formatter formatter;

	@Inject // this constructor will be used to inject must-have dependencies
	public PrintAction(Printer printer) {
		this.printer = printer;
		this.formatter = formatter;
	}

	@Override
	public void execute(String data) {
		printer.print(formatter.format("The message is %s", data));
	}

	public void setFormatter(Formatter formatter) {
		System.out.println(String.format("PrintAction.setFormatter(%s)", formatter));
		this.formatter = formatter;
	}
}
