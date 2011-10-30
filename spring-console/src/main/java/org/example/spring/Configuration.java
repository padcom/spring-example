package org.example.spring;

import javax.inject.Named;

@Named
public class Configuration {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
