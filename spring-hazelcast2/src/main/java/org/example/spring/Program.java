package org.example.spring;

import org.example.spring.services.impl.ExampleAction;
import org.example.spring.services.impl.ReadDateFromCacheAction;
import org.example.spring.services.impl.StoreDateInCacheAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hazelcast.core.Hazelcast;

public class Program {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });
		context.getBean(StoreDateInCacheAction.class).execute("key");
		context.getBean(ReadDateFromCacheAction.class).execute("key");
		context.getBean(ExampleAction.class).execute("");
		Hazelcast.shutdownAll();
	}
}
