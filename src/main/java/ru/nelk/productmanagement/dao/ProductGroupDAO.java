package ru.nelk.productmanagement.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="productGroups")
public class ProductGroupDAO {
	
	@Id @GeneratedValue
	private long pgroup_id;
	private String pgroup_name;
	
	public long getPgroup_id() {
		return pgroup_id;
	}
	public void setPgroup_id(long pgroup_id) {
		this.pgroup_id = pgroup_id;
	}
	public String getPgroup_name() {
		return pgroup_name;
	}
	public void setPgroup_name(String pgroup_name) {
		this.pgroup_name = pgroup_name;
	}
	

}
