package ru.nelk.productmanagement.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.nelk.productmanagement.dao.MessageSourceDAO;

public class MessageSourceTest {
	IMessageSource messageSource;
	long ms_id;
	IMessageSource messageSource2;
	long ms_id2;
	

	@Before
	public void setUp() throws Exception {
		messageSource = new MessageSource();
		messageSource2 = new MessageSource();
		testInsertMessageSource();
	}

	@After
	public void tearDown() throws Exception {
		testDeleteMesssageSource();
	}

	public void testInsertMessageSource() {
		ms_id = messageSource.insertMessageSource("Message source 1");
		System.out.println("Message source id = "+ms_id+" inserted");
		ms_id2 = messageSource2.insertMessageSource("Message source 2");
		System.out.println("Message source id = "+ms_id2+" inserted");
		
	}

	public void testDeleteMesssageSource() {
		messageSource.deleteMesssageSource(ms_id);
		messageSource2.deleteMesssageSource(ms_id2);
		System.out.println("Message source id = "+ms_id+" deleted");
		System.out.println("Message source id = "+ms_id2+" deleted");
	}

	@Test
	public void testGetMessageSourceList() {
		List<MessageSourceDAO> msList = messageSource.getMessageSourceList();
		System.out.println("msList.size()"+ msList.size());
		for (int i=0;i<msList.size();i++) {			
		System.out.println("Message source: "+msList.get(i).getSource_name());
		}
	}

	@Test
	public void testGetMessageSourceById() {
		assertEquals(messageSource.getMessageSourceById(ms_id).getSource_name(), "Message source 1");
	}

	@Test
	public void testUpdateMessageSource() {
		messageSource.updateMessageSource(ms_id, "updated source");
		System.out.println("testUpdateMessageSource: "+messageSource.getMessageSourceById(ms_id).getSource_name());
	}

}
