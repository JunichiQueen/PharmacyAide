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

	public Condition findCondition(int id) {
		return conditionMap.get(id);
	}

	public String addCondition(String conditionName) {
		Condition con1 = json.getObjectForJSON(conditionName, Condition.class);
		conditionMap.put(conditionMap.size()+1, con1);
		return "You have successfully added a condition";
	}

	public String deleteCondition(int id) {
		conditionMap.remove(id);
		return "You have successfully deleted a condition";
	}

	public String updateCondition(int id, String conditionName) {
		conditionMap.get(id).getConditionName() = conditionName;
		return null;
	}
	
	public Map<Integer, Condition> getConditionMap(){
		return conditionMap;
	}

	@Override
	public String toString() {
		return "ConditionMapRepository [json=" + json + ", conditionMap=" + conditionMap + "]";
	}
	
}
