package ru.nelk.productmanagement.domain;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.nelk.productmanagement.dao.MessageDAO;
import ru.nelk.productmanagement.dao.MessageSourceDAO;
import ru.nelk.productmanagement.dao.ProductsDAO;

public class MessagesTest {
	IMessage mes;
	//IMessage mes2;
	long m_id;
	//long m_id2;
	

	@Before
	public void setUp() throws Exception {
		mes = new Messages();
		//mes2 = new Messages();
		testInsertMessage();
	}

	@After
	public void tearDown() throws Exception {
		testDeleteMessageById();
	}

	@Test
	public void testGetMessages() {
		List<MessageDAO> mesList = mes.getMessages();
		for(int i=0;i<mesList.size();i++){
			System.out.println("Message: "+mesList.get(i).getMessage_name());
			
		}
		
	}

	@Test
	public void testGetMessageById() {
		assertEquals(mes.getMessageById(m_id).getMessage_name(), "First message");
	}

	public void testInsertMessage() {
		MessageSource messageSource = new MessageSource();
		long ms_id = messageSource.insertMessageSource("message test messageSource");
		Date create_date = new Date();
		URL ticket_url = null;
		String s = "http://vk.com/audios-26970810";
		try {
			ticket_url = new URL(s);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Products product = new Products();
		long prod_id = product.insertProduct("test product", "1111", null);
		Persons person  = new Persons();
		long pers_id = person.insertPerson("test person", "test person", "test person", 
				null, "test person", "1111", "fefwe", "ii@km");
		
		m_id = mes.insertMessage("First message", messageSource.getMessageSourceById(ms_id), 
				create_date, ticket_url, product.getProductById(prod_id), person.getPersonById(pers_id));
	}

	public void testDeleteMessageById() {
		mes.deleteMessageById(m_id);
		System.out.println("Message id = "+ m_id + " deleted");
	}

	@Test
	public void testUpdateMessage() {
		mes.updateMessage(m_id, "updated message", null, new Date(), null, null, null);
		System.out.println("Message "+m_id+" updated");
	}

	@Test
	public void testGetMessagesByProductID() {
		Products product = new Products();
		long p_id = product.insertProduct("test prod", "11", null);
		List<MessageDAO> mesList =  mes.getMessagesByProductID(p_id);
		for(int i=0;i<mesList.size();i++){
			System.out.println("Message by product: "+mesList.get(i).getMessage_name());
			
		}
	}

	@Test
	public void testGetMessagesForPeriod() {

		List<MessageDAO> mesList =  mes.getMessagesForPeriod(new Date(System.currentTimeMillis()-11111111), new Date(System.currentTimeMillis()+6000000));
		for(int i=0;i<mesList.size();i++){
			System.out.println("Message for period: "+mesList.get(i).getMessage_name());
			
		}
	}

}
