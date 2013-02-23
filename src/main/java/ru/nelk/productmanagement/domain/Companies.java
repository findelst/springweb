package ru.nelk.productmanagement.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.nelk.productmanagement.dao.CompaniesDAO;
import ru.nelk.productmanagement.dao.PersonsDAO;

public class Companies implements ICompanies{
	private Session session;

	private void begin() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();		
	}
	
	@SuppressWarnings("rawtypes")
	public List<CompaniesDAO> getCompanies() {

		List<CompaniesDAO> companies = null;
		begin();
		companies = session.createQuery("from Companies").list();		
		session.getTransaction().commit();
		//session.close();
		
		return companies;
	}

	public CompaniesDAO getCompanyById(long id) {
		
		begin();
		CompaniesDAO company = (CompaniesDAO) session.load(CompaniesDAO.class, id);
		session.getTransaction().commit();
		//session.close();		
		return company;
	}

	public long insertCompany(String company_name, String company_address) {
		CompaniesDAO company = new CompaniesDAO();
		company.setCompany_name(company_name);
		company.setCompany_address(company_address);
		
		begin();
		session.save(company);
		session.getTransaction().commit();
		return company.getCompany_id();
		
	}

	public void deleteCompanyById(long id) {
		begin();    
		Object company = session.load(CompaniesDAO.class, id);
		session.delete(company);
		session.getTransaction().commit();
		
		
	}

	public CompaniesDAO getCompanyByPersonID(long id) {
		begin();
		PersonsDAO person = (PersonsDAO) session.load(PersonsDAO.class, id);
		CompaniesDAO company = person.getCompany();
		session.getTransaction().commit();
		return company;
	}

	@Override
	public void updateCompany(long id, String company_name,
			String company_address) {
		begin();
		CompaniesDAO company = (CompaniesDAO) session.get(CompaniesDAO.class, id);
		company.setCompany_name(company_name);
		company.setCompany_address(company_address);
		session.update(company);
		session.getTransaction().commit();
		
	}


}
