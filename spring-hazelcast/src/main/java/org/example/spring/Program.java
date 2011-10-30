package org.example.spring;

import org.example.spring.services.Action;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hazelcast.client.HazelcastClient;

public class Program {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });
		Action store = (Action) context.getBean("store-value-action");
		Action dump = (Action) context.getBean("dump-value-action");
		
		store.execute("key:value");
		dump.execute("key");

		HazelcastClient hazelcast = (HazelcastClient) context.getBean("hazelcast-client");
		hazelcast.shutdown();
	}
}
