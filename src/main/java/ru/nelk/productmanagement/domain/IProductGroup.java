package ru.nelk.productmanagement.domain;

import java.util.List;

import ru.nelk.productmanagement.dao.ProductGroupDAO;


public interface IProductGroup {
	
	public List<ProductGroupDAO> getProductGroups();
	public ProductGroupDAO getProguctGroupById(long id);
	public long insertProductGroup(String pgroup_name);
	public void deleteProductGroupById(long id);
	public void updateProductGroup(long id, String pgroup_name);

}
