package ru.nelk.productmanagement.domain;

import java.net.URL;
import java.util.Date;
import java.util.List;

import ru.nelk.productmanagement.dao.MessageDAO;
import ru.nelk.productmanagement.dao.MessageSourceDAO;
import ru.nelk.productmanagement.dao.PersonsDAO;
import ru.nelk.productmanagement.dao.ProductsDAO;

public interface IMessage {
	
	public List<MessageDAO> getMessages();
	public MessageDAO getMessageById(long id);
	public long insertMessage(String message_name, MessageSourceDAO message_source, Date create_date, 
			URL ticket_url, ProductsDAO product, PersonsDAO person);
	public void deleteMessageById(long id);
	public void updateMessage(long id, String message_name, MessageSourceDAO message_source, Date create_date, 
			URL ticket_url, ProductsDAO product, PersonsDAO person);
	public List<MessageDAO> getMessagesForPeriod(Date date_from, Date date_to);
	public List<MessageDAO> getMessagesByProductID(long id);
	
	

}
