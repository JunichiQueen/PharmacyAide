package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Condition;
import com.qa.util.JSONUtil;

public class ConditionMapRepository implements ConditionRepository{
	
	JSONUtil json = new JSONUtil();
	
	Map<Integer, Condition> conditionMap = new HashMap<Integer, Condition>();

	public String getAllConditions() {
		
		return json.getJSONForObject(conditionMap);
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
