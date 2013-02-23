package ru.nelk.productmanagement.domain;

import java.util.List;

import ru.nelk.productmanagement.dao.CompaniesDAO;



public interface ICompanies {
	
	public List<CompaniesDAO> getCompanies();
	public CompaniesDAO getCompanyById(long id);
	public long insertCompany(String company_name, String company_address);
	public void deleteCompanyById(long id);
	public CompaniesDAO getCompanyByPersonID(long id);
	public void updateCompany(long id, String company_name, String company_address);
	
	
	
	

}
