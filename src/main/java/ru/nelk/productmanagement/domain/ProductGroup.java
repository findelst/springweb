package ru.nelk.productmanagement.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.nelk.productmanagement.dao.CompaniesDAO;
import ru.nelk.productmanagement.dao.ProductGroupDAO;

public class ProductGroup implements IProductGroup{
	private Session session;

	private void begin() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();		
	}

	public List<ProductGroupDAO> getProductGroups() {
		begin();
		List<ProductGroupDAO> productGroups = session.createQuery("from productGroups").list();	
		session.getTransaction().commit();	
		return productGroups;
	}

	public ProductGroupDAO getProguctGroupById(long id) {
		begin();
		ProductGroupDAO productGroup = (ProductGroupDAO) session.load(ProductGroupDAO.class, id);
		session.getTransaction().commit();		
		return productGroup;
	}

	public long insertProductGroup(String pgroup_name) {	
		ProductGroupDAO productGroup = new ProductGroupDAO();
		productGroup.setPgroup_name(pgroup_name);
		begin();
		session.save(productGroup);
		session.getTransaction().commit();
		return productGroup.getPgroup_id();
	}

	public void deleteProductGroupById(long id) {
		begin();    
		Object proguctGroup = session.load(ProductGroupDAO.class, id);
		session.delete(proguctGroup);
		session.getTransaction().commit();
		
		
	}

	@Override
	public void updateProductGroup(long id, String pgroup_name) {
		begin();
		ProductGroupDAO productGroup = (ProductGroupDAO) session.get(ProductGroupDAO.class, id);
		productGroup.setPgroup_name(pgroup_name);
		session.update(productGroup);
		session.getTransaction().commit();
		
	}
	

}
