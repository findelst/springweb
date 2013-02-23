package ru.nelk.productmanagement.domain;

import java.util.List;

import ru.nelk.productmanagement.dao.StatesDAO;

public interface IStates {
	
	public long insertState(String state_name, String st_comment);
	public void updateState(long state_id, String state_name, String st_comment);
	public void deleteState(long state_id);
	public List<StatesDAO> getStates();
	public StatesDAO getStateById();
	
}
