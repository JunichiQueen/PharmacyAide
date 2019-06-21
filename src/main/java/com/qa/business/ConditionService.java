package com.qa.business;

public interface ConditionService {
	
	String getAllConditions();
	String findACondition(int id);
//	String findConditionByName(String conditionName);
	String addCondition(String conditionName);
	String deleteCondition(int id);
	String updateCondition(int id, String conditionName);
	

}
