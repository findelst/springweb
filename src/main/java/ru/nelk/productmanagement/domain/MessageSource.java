package ru.nelk.productmanagement.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.nelk.productmanagement.dao.MessageSourceDAO;

public class MessageSource implements IMessageSource{
	private Session session;
	
	private void begin() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();		
	}

	@Override
	public long insertMessageSource(String source_name) {		
		MessageSourceDAO messageSource = new MessageSourceDAO();
		messageSource.setSource_name(source_name);
		begin();
		session.save(messageSource);
		session.getTransaction().commit();
		return messageSource.getSource_id();
	}

	@Override
	public void deleteMesssageSource(long id) {
		begin();
		Object messageSource = session.load(MessageSourceDAO.class, id);
		session.delete(messageSource);
		session.getTransaction().commit();
		
	}

	@Override
	public List<MessageSourceDAO> getMessageSourceList() {
		begin();
		List<MessageSourceDAO> messageSourceList = session.createQuery("from MessageSource").list();
		session.getTransaction().commit();
		return messageSourceList;
	}

	@Override
	public MessageSourceDAO getMessageSourceById(long id) {
		begin();
		MessageSourceDAO messageSource = (MessageSourceDAO) session.load(MessageSourceDAO.class, id);
		session.getTransaction().commit();
		return messageSource;
	}

	@Override
	public void updateMessageSource(long id, String source_name) {
		begin();
		MessageSourceDAO messageSource = (MessageSourceDAO) session.get(MessageSourceDAO.class, id);
		messageSource.setSource_name(source_name);
		session.update(messageSource);
		session.getTransaction().commit();
		
		
	}

}
