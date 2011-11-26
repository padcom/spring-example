package org.example.gorm

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Program {
	static main(args) {
		ApplicationContext context = new ClassPathXmlApplicationContext([ "beans.xml" ] as String[]);
		def p = new Person(firstName: "John", lastName: "Smith")
		p.save(flush: true)
	}
}
