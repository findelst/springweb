package ru.nelk.productmanagement.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="States")
public class StatesDAO {
	
	@Id @GeneratedValue
	private long state_id;
	private String state_name;
	private String st_comment;
	
	public long getState_id() {
		return state_id;
	}
	public void setState_id(long state_id) {
		this.state_id = state_id;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public String getSt_comment() {
		return st_comment;
	}
	public void setSt_comment(String st_comment) {
		this.st_comment = st_comment;
	}
	
	

}
