package org.example.spring.services.impl;

import org.example.spring.services.Action;

public class ExampleAction implements Action {

	private final Configuration configuration;

	public ExampleAction(Configuration configuration) {
		this.configuration = configuration;
	}
	
	@Override
	public void execute(String data) {
		System.out.println("VALUE1: " + configuration.getValue1());
		System.out.println("VALUE2: " + configuration.getValue2());
	}

}
