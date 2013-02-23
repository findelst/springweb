package ru.nelk.productmanagement.domain;

import java.util.List;

import ru.nelk.productmanagement.dao.MessageSourceDAO;



public interface IMessageSource {

	public long insertMessageSource(String source_name);
	public void deleteMesssageSource(long id);
	public List<MessageSourceDAO> getMessageSourceList();
	public MessageSourceDAO getMessageSourceById(long id);
	public void updateMessageSource(long id, String source_name);
		
}
