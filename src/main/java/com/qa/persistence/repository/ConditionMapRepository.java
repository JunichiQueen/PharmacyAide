package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Condition;

public class ConditionMapRepository implements ConditionRepository{
	
	Map<Integer, Condition> conditionMap = new HashMap<Integer, Condition>();

	public String getAllConditions() {
		return conditionMap;
	}

	public String findCondition(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String createCondition(String conditionName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteCondition(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateCondition(int id, String conditionName) {
		// TODO Auto-generated method stub
		return null;
	}

}
