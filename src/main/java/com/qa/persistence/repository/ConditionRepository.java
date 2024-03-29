package com.qa.persistence.repository;

public interface ConditionRepository {
	
	String getAllConditions();
	String findCondition(int id);
	String addCondition(String conditionName);
	String deleteCondition(int id);
	String updateCondition(int id, String conditionName);

}
