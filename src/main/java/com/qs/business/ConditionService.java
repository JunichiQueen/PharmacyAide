package com.qs.business;

public interface ConditionService {
	
	String getAllAccounts();
	String findAnAccount(int id);
	String addAccount(String conditionName);
	String deleteAccount(int id);
	String updateAccount(int id, String conditionName);

}
