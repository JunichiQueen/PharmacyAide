package com.qs.business;

public interface ConditionService {
	
	String getAllConditions();
	String findACondition(int id);
	String addCondition(String conditionName);
	String deleteCondition(int id);
	String updateCondition(int id, String conditionName);

}
