package ru.nelk.productmanagement.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.nelk.productmanagement.dao.CompaniesDAO;

public class CompaniesTest {

	private ICompanies comp;
	private long idRow;
	
	@Before
	public void setUp() throws Exception {
		comp = new Companies();
		testInsertCompany();
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		testDeleteCompanyById();
	}

	@Test
	public void testGetCompaniesNames() {		
		 List<CompaniesDAO> comp1 = comp.getCompanies();
		 for (int i=0;i<comp1.size();i++) {			 
			 assertEquals("company 1", comp1.get(i).getCompany_name());
			 System.out.println("Company: "+comp1.get(i).getCompany_name());	
			 
		 }
	}

	@Test
	public void testGetCompanyById() {
		CompaniesDAO company =  comp.getCompanyById(idRow);
				
		System.out.println("testGetCompanyById: "+company.getCompany_name());
	}
	
	@Test
	public void testUpdateCompany() {
		comp.updateCompany(idRow, "updated company", "updated address");
		System.out.println("testUpdateCompany: "+comp.getCompanyById(idRow).getCompany_name());
		
	}
	
	
	public void testInsertCompany() {
		System.out.println("Starting insert...");
		idRow = comp.insertCompany("company 1", "company 1 address");
		
		System.out.println("Inserted.");
	}

	public void testDeleteCompanyById() {
		comp.deleteCompanyById(idRow);
		
	}
	

}
