package org.example.gorm

import org.example.gorm.domain.Person
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.orm.hibernate3.SessionHolder
import org.springframework.transaction.support.TransactionSynchronizationManager

class Program {
	static main(args) {
		def context = new ClassPathXmlApplicationContext(["beans.xml"]as String[]);
		def sessionFactory = context.getBean("sessionFactory") as SessionFactory
		def session = sessionFactory.openSession()
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
		try {
			new Person(firstName: "John", lastName: "Smith").save(flush: true)
			println Person.findAllByFirstName("John")
		} finally {
			session.close()
		}
	}
}
