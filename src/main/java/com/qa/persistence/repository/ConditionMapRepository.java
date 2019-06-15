package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Condition;
import com.qa.util.JSONUtil;

@Alternative
public class ConditionMapRepository implements ConditionRepository{
	
	JSONUtil json;
	
	Map<Integer, Condition> conditionMap = new HashMap<Integer, Condition>();

	public String getAllConditions() {
		
		return new JSONUtil().getJSONForObject(conditionMap);
	}

	public String findCondition(int id) {
		return new JSONUtil().getJSONForObject(conditionMap.get(id));
	}

	public String addCondition(String conditionName) {
		Condition con1 = new JSONUtil().getObjectForJSON(conditionName, Condition.class);
		conditionMap.put(conditionMap.size()+1, con1);
		return "You have successfully added a condition";
	}

	public String deleteCondition(int id) {
		conditionMap.remove(id);
		return "You have successfully deleted a condition";
	}

	public String updateCondition(int id, String conditionName) {
		Condition newCondition = new JSONUtil().getObjectForJSON(conditionName, Condition.class);
		conditionMap.put(id, newCondition);
		return "You have successfully updated a condition";
	}
	
	public Map<Integer, Condition> getConditionMap(){
		return conditionMap;
	}

	@Override
	public String toString() {
		return "ConditionMapRepository [json=" + json + ", conditionMap=" + conditionMap + "]";
	}
	
}
