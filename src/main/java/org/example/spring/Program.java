package org.example.spring;

import org.example.spring.services.Action;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });
		//
		// Alternatively you can get the bean by name like this:
		//
		// Action action = (Action) context.getBean("printAction");
		//
		Action action = context.getBean(Action.class);
		action.execute("Hello, world!");
	}
}
