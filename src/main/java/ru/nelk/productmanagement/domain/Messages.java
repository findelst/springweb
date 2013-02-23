package ru.nelk.productmanagement.domain;

import java.net.URL;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.nelk.productmanagement.dao.MessageDAO;
import ru.nelk.productmanagement.dao.MessageSourceDAO;
import ru.nelk.productmanagement.dao.PersonsDAO;
import ru.nelk.productmanagement.dao.ProductsDAO;

public class Messages implements IMessage{
	private Session session;

	private void begin() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();		
	}



	@Override
	public List<MessageDAO> getMessages() {
		begin();
		List<MessageDAO> messageList = session.createQuery("from Messages").list();		
		session.getTransaction().commit();
		return messageList;
	}

	@Override
	public MessageDAO getMessageById(long id) {
		begin();
		MessageDAO message = (MessageDAO) session.load(MessageDAO.class, id);
		session.getTransaction().commit();
		return message;
	}

	@Override
	public long insertMessage(String message_name,
			MessageSourceDAO message_source, Date create_date, URL ticket_url,
			ProductsDAO product, PersonsDAO person) {
		begin();
		MessageDAO message = new MessageDAO();
		message.setMessage_name(message_name);
		message.setMessage_source(message_source);
		message.setCreate_date(create_date);
		message.setTicket_url(ticket_url);
		message.setProduct(product);
		message.setPerson(person);
		session.save(message);
		session.getTransaction().commit();
		return message.getMessage_id();
	}

	@Override
	public void deleteMessageById(long id) {
		begin();
		MessageDAO message = (MessageDAO) session.load(MessageDAO.class, id);
		session.delete(message);
		session.getTransaction().commit();
		
		
	}

	@Override
	public void updateMessage(long id, String message_name,
			MessageSourceDAO message_source, Date create_date, URL ticket_url,
			ProductsDAO product, PersonsDAO person) {
		begin();
		MessageDAO message = (MessageDAO) session.load(MessageDAO.class, id);
		message.setMessage_name(message_name);
		message.setMessage_source(message_source);
		message.setCreate_date(create_date);
		message.setTicket_url(ticket_url);
		message.setProduct(product);
		message.setPerson(person);
		session.update(message);
		session.getTransaction().commit();
		
	}

	@Override
	public List<MessageDAO> getMessagesByProductID(long id) {
		begin();		
		Query query = session.createQuery("from Messages where product_id = :prod_id ");
		List<MessageDAO> messages = query.setParameter("prod_id", id).list();
		session.getTransaction().commit();
		return messages;
	}

	@Override
	public List<MessageDAO> getMessagesForPeriod(Date date_from, Date date_to) {
		begin();
		Query query = session.createQuery("from Messages where create_date between :from and :to");
		query.setParameter("from", date_from);
		query.setParameter("to", date_to);
		List<MessageDAO> messages = query.list();	
		return messages;
	}

}
