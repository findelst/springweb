package ru.nelk.productmanagement.domain;

import java.util.List;

import ru.nelk.productmanagement.dao.ProductGroupDAO;
import ru.nelk.productmanagement.dao.ProductsDAO;

public interface IProducts {
	
	public long insertProduct(String product_name, String serial_number, ProductGroupDAO productGroup);
	public void deleteProduct(long id);
	public ProductsDAO getProductById(long id);
	public List<ProductsDAO> getProductsList();
	public List<ProductsDAO> getProductsFromGroup(long pgroup_id);
	public void updateProduct(long id, String product_name, String serial_number, ProductGroupDAO productGroup);
	

}
