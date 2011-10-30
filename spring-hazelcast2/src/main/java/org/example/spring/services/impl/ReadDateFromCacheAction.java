package org.example.spring.services.impl;

import java.util.Map;

import org.example.spring.services.Action;

public class ReadDateFromCacheAction implements Action {

	private final Map<String, String> values;

	public ReadDateFromCacheAction(Map<String, String> values) {
		this.values = values;
	}
	
	@Override
	public void execute(String data) {
		System.out.println(values.get(data));
	}
}
