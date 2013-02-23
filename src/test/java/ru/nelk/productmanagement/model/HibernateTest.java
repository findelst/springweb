package ru.nelk.productmanagement.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.nelk.productmanagement.domain.MessageSource;

public class HibernateTest {

	/**
	 * @param args
	 
	public static void main(String[] args) {
			MessageSource messageSource = new MessageSource();
			messageSource.setSource_name("Letter");		
		
			MessageSourceource messageSource2 = new MessageSource();
			messageSource2.setSource_name("Forum");
			
			Message message = new Message();
			message.setProduct("first product");
			message.setCreate_date(new Date());
			message.setMessage_source(messageSource);
			

			Message message2 = new Message();
			message2.setProduct("second product");
			message2.setCreate_date(new Date());
			message2.setMessage_source(messageSource);
			
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(message);
			session.save(message2);
			session.save(messageSource);
			session.save(messageSource2);
			session.getTransaction().commit();
			session.close();
			
			// message = (Message) session.get(Message.class, 1);
			
		
	}*/

}
