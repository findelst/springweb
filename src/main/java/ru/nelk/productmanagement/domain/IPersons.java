package ru.nelk.productmanagement.domain;

import java.util.List;

import ru.nelk.productmanagement.dao.CompaniesDAO;
import ru.nelk.productmanagement.dao.PersonsDAO;

public interface IPersons {
	
	public long insertPerson(String family_name, String name, String fathers_name, CompaniesDAO company, String position,
			String telephone, String skype, String e_mail);
	public void deletePerson(long id);
	public void updatePerson(long id, String family_name, String name, String fathers_name, CompaniesDAO company, String position,
			String telephone, String skype, String e_mail);
	public PersonsDAO getPersonById(long id);
	public List<PersonsDAO> getPersonsByCompanyID(long id);

	

}
