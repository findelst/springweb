package ru.nelk.productmanagement.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="MessageSource")
public class MessageSourceDAO {

	@Id @GeneratedValue
	private long source_id;
	private String source_name;
	
	public long getSource_id() {
		return source_id;
	}
	public void setSource_id(long source_id) {
		this.source_id = source_id;
	}
	public String getSource_name() {
		return source_name;
	}
	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}
}
