package ru.nelk.productmanagement.domain;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.nelk.productmanagement.dao.PersonsDAO;

public class PersonsTest {
	private IPersons pers;
	private IPersons pers2;
	private long idRow;
	private long idRow2;
	private long comp_id;

	@Before
	public void setUp() throws Exception {
		pers = new Persons();
		pers2 = new Persons();
		testInsertPerson();
	}

	@After
	public void tearDown() throws Exception {
		testDeletePerson();
	}

	
	public void testInsertPerson() {
		System.out.println("Starting inserting person...");
		Companies comp = new Companies();
		comp_id = comp.insertCompany("Apple", "Kupertiono");
		idRow = pers.insertPerson("Ivanov", "Ivan", "Ivanovich", comp.getCompanyById(comp_id), "engeneer", "1111111", "skype_login", "test@test");		
		idRow2 = pers2.insertPerson("Petrov", "Petr", "Petrovich", comp.getCompanyById(comp_id), "manager", "22222", "skype2_login", "test2@test2");	
		System.out.println("Person "+ idRow + " inserted.");
		System.out.println("Person "+ idRow2 + " inserted.");
	
	}

	
	public void testDeletePerson() {
		pers.deletePerson(idRow);
		pers2.deletePerson(idRow2);
	}

	@Test
	public void testGetPersonById() {
		PersonsDAO person = pers.getPersonById(idRow);
		System.out.println("testGetPersonById: "+ person);
	}
	
	@Test
	public void testGetPersonsByCompanyID() {
		List<PersonsDAO> p = pers.getPersonsByCompanyID(comp_id);
		for (int i = 0; i < p.size(); i++) {
			System.out.println("Person id: "+ p.get(i).getPerson_id());
			
		}
	
	}
	
	@Test
	public void testUpdatePerson(){
		Companies comp2 = new Companies();
		long comp_id2 = comp2.insertCompany("New Company", "Moscow");		
		pers.updatePerson(idRow, "family_name", "name", "fathers_name", comp2.getCompanyById(comp_id2), "position", "telephone", "skype", "e_mail");
		System.out.println("testUpdatePerson: "+pers.getPersonById(idRow).getFamily_name());
	}
	
	
	

}
