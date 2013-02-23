package ru.nelk.productmanagement.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Products")
public class ProductsDAO {

	@Id @GeneratedValue
	private long product_id;
	private String product_name;
	private String serial_number;
	@ManyToOne
	@JoinColumn(name="productGroup_id")	
	private ProductGroupDAO productGroup;
	
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	public ProductGroupDAO getProductGroup() {
		return productGroup;
	}
	public void setProductGroup(ProductGroupDAO productGroup) {
		this.productGroup = productGroup;
	}
	
	
}
