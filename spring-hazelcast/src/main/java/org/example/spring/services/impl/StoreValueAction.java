package org.example.spring.services.impl;

import java.util.Map;

import javax.inject.Inject;

import org.example.spring.services.Action;

public class StoreValueAction implements Action {

	private final Map<String, String> values;

	@Inject
	public StoreValueAction(Map<String, String> values) {
		this.values = values;
	}
	
	@Override
	public void execute(String data) {
		String[] params = data.split(":");
		assert params.length == 2;
		values.put(params[0], params[1]);
	}
}
