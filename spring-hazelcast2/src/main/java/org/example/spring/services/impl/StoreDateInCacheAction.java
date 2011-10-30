package org.example.spring.services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.example.spring.services.Action;

public class StoreDateInCacheAction implements Action {

	private final Map<String, String> values;
	private final SimpleDateFormat format;

	public StoreDateInCacheAction(Map<String, String> values, SimpleDateFormat format) {
		this.values = values;
		this.format = format;
	}
	
	@Override
	public void execute(String data) {
		values.put(data, format.format(new Date()));
	}
}
