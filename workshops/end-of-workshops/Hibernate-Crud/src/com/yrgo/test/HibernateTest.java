package com.yrgo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.yrgo.domain.Student;

public class HibernateTest {

	private static SessionFactory sessionFactory = null;
	
	public static void main(String[] args) {
		//Student newStudent = new Student("Nick Fame", "Diamond Cameron");
	 
		SessionFactory sf = getSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//session.save(newStudent);
		//System.out.println("The student has an id  of: " + newStudent.getId());
		
		//To retrieve a student
	    // Student myStudent = (Student)session.get(Student.class, 6);
		 //System.out.println(myStudent + " is the student.");
		
		//To delete a student
		 //session.delete(myStudent);
		
		//To update the name of the tutor for a student.
		//Student anotherStudent = new Student("Bob Jones" , "John Westland");
		//session.save(anotherStudent);
		
		//Student anotherStudent = (Student) session.get(Student.class, 7);
		//anotherStudent.setTutor("David Graveyard");
		
		Student newStudent = new Student("Ada Svensson");
		session.save(newStudent);
		
		tx.commit();	
		session.close();
	}
	

	public static SessionFactory getSessionFactory() {
	   if(sessionFactory ==null) {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
			.applySettings(configuration.getProperties())
			.buildServiceRegistry();
		sessionFactory = 
	             configuration.buildSessionFactory(serviceRegistry);
	   }
	   return sessionFactory;
	}


}
