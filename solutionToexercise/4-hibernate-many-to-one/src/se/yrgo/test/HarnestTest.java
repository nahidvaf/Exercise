package se.yrgo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import se.yrgo.domain.Author;
import se.yrgo.domain.Book;

public class HarnestTest {
	
	private static SessionFactory sessionFactory = null;

	public static void main(String[] args) {
		
		Book book1= new Book( "My book 1" );
		Book book2= new Book("My book 2");
		Book book3= new Book( "My book 3");
		
		Author author = new Author("Arthur Bengt");
		book3.allocateAuthor(author);
		

		SessionFactory sf = getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
				
		session.save(book1); 
		session.save(book2);
		session.save(book3);
		session.save(author);
		
		System.out.println(book3.getAuthorName());
		
//		Book myBook = (Book)session.get(Book.class, 3);
//		System.out.println("The book is: " +myBook  );
				
//		Book bookToDelete = (Book) session.get(Book.class, 2);
//		session.delete(bookToDelete);

				
//		 Book bookToEdit = (Book) session.get(Book.class, 1);
//		 bookToEdit.setAuthor("David Graveyard");

		

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
