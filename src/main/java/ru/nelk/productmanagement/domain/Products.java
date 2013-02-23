package ru.nelk.productmanagement.domain;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.nelk.productmanagement.dao.CompaniesDAO;
import ru.nelk.productmanagement.dao.PersonsDAO;
import ru.nelk.productmanagement.dao.ProductGroupDAO;
import ru.nelk.productmanagement.dao.ProductsDAO;

public class Products implements IProducts{
	private Session session;
	
	private void begin() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
	}

	public long insertProduct(String product_name, String serial_number,
			ProductGroupDAO productGroup) {
		begin();
		ProductsDAO product = new ProductsDAO();
		product.setProduct_name(product_name);
		product.setProductGroup(productGroup);
		product.setSerial_number(serial_number);
		session.save(product);
		session.getTransaction().commit();
		
		return product.getProduct_id();
	}

	public void deleteProduct(long id) {
		begin();
		Object product = session.load(ProductsDAO.class, id);
		session.delete(product);
		session.getTransaction().commit();
		
	}

	public ProductsDAO getProductById(long id) {
		begin();
		ProductsDAO product = (ProductsDAO) session.load(ProductsDAO.class, id);
		session.getTransaction().commit();
		return product;
	}

	public List<ProductsDAO> getProductsList() {
		begin();
		List<ProductsDAO> productsList = session.createQuery("from Products").list();
		session.getTransaction().commit();
		return productsList;
	}

	public List<ProductsDAO> getProductsFromGroup(long pgroup_id) {
		begin();
		Query query = session.createQuery("from Products where product_id = :prodId ");
		List<ProductsDAO> products = query.setParameter("prodId", pgroup_id).list();
		session.getTransaction().commit();
		return products;
	}

	@Override
	public void updateProduct(long id, String product_name,
			String serial_number, ProductGroupDAO productGroup) {
		begin();
		ProductsDAO product = (ProductsDAO) session.get(ProductsDAO.class, id);
		product.setProduct_name(product_name);
		product.setSerial_number(serial_number);
		product.setProductGroup(productGroup);
		session.update(product);
		session.getTransaction().commit();
		
	}

}
