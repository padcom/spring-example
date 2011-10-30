package org.example.spring;

import org.mule.api.MuleContext;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;

public class Program {
	public static void main(String[] args) throws Exception {
		DefaultMuleContextFactory factory = new DefaultMuleContextFactory();
		SpringXmlConfigurationBuilder configuration = new SpringXmlConfigurationBuilder("mule-config.xml");
		MuleContext context = factory.createMuleContext(configuration);
		context.start();
		System.out.println("Press any key to close...");
		System.in.read();
		context.stop();
		context.dispose();
	}
}
