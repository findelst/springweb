package ru.nelk.productmanagement.domain;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.Expression;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.nelk.productmanagement.dao.CompaniesDAO;
import ru.nelk.productmanagement.dao.PersonsDAO;

public class Persons implements IPersons{
	private Session session;

	private void begin() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();		
	}

	public long insertPerson(String family_name, String name,
			String fathers_name, CompaniesDAO company, String position,
			String telephone, String skype, String e_mail) {
		
		PersonsDAO person = new PersonsDAO();
		person.setFamily_name(family_name);
		person.setName(name);
		person.setFathers_name(fathers_name);	
		person.setCompany(company);
		person.setPosition(position);
		person.setTelephone(telephone);
		person.setSkype(skype);
		person.setE_mail(e_mail);
		
		begin();
		session.save(person);
		session.getTransaction().commit();
		return person.getPerson_id();
	}


	public void deletePerson(long id) {
		begin();    
		Object person = session.load(PersonsDAO.class, id);
		session.delete(person);
		session.getTransaction().commit();
		
	}

	public PersonsDAO getPersonById(long id) {
		begin();
		PersonsDAO person = (PersonsDAO) session.load(PersonsDAO.class, id);
		session.getTransaction().commit();		
		return person;
	}

	public List<PersonsDAO> getPersonsByCompanyID(long id) {		
		begin();		
		org.hibernate.Query query = session.createQuery("from Persons where company_id = :compId ");
		List<PersonsDAO> persons = query.setParameter("compId", id).list();
		session.getTransaction().commit();
		return persons;
	}

	@Override
	public void updatePerson(long id, String family_name, String name,
			String fathers_name, CompaniesDAO company, String position,
			String telephone, String skype, String e_mail) {
		begin();
		PersonsDAO person = (PersonsDAO) session.get(PersonsDAO.class, id);
		person.setFamily_name(family_name);
		person.setName(name);
		person.setFathers_name(fathers_name);
		person.setCompany(company);
		person.setPosition(position);
		person.setTelephone(telephone);
		person.setSkype(skype);
		person.setE_mail(e_mail);
		session.update(person);
		session.getTransaction().commit();
		
	}

}
