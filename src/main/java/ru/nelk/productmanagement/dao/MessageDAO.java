package ru.nelk.productmanagement.dao;

import java.net.URL;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Messages")
public class MessageDAO {
	
	@Id @GeneratedValue
	private long message_id;
	private String message_name;
	@ManyToOne
	@JoinColumn(name="source_id")
	private MessageSourceDAO message_source;
	private Date create_date;
	private URL ticket_url;
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductsDAO product;
	@ManyToOne
	@JoinColumn(name="person_id")
	private PersonsDAO person;
	
	public long getMessage_id() {
		return message_id;
	}
	public void setMessage_id(long message_id) {
		this.message_id = message_id;
	}
	public MessageSourceDAO getMessage_source() {
		return message_source;
	}
	public void setMessage_source(MessageSourceDAO message_source) {
		this.message_source = message_source;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public URL getTicket_url() {
		return ticket_url;
	}
	public void setTicket_url(URL ticket_url) {
		this.ticket_url = ticket_url;
	}
	public ProductsDAO getProduct() {
		return product;
	}
	public void setProduct(ProductsDAO product) {
		this.product = product;
	}
	public PersonsDAO getPerson() {
		return person;
	}
	public void setPerson(PersonsDAO person) {
		this.person = person;
	}
	public String getMessage_name() {
		return message_name;
	}
	public void setMessage_name(String message_name) {
		this.message_name = message_name;
	}

}
