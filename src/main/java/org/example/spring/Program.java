package org.example.spring;

import org.example.spring.services.Action;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });
		Action action = context.getBean(Action.class);
		action.execute("Hello, world!");
	}
}
