package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import com.qa.persistence.domain.Condition;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ConditionDBRepository implements ConditionRepository{
	
	@Inject
	private JSONUtil json;

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Override
	public String getAllConditions() {
		
		Query query = manager.createQuery("SELECT c FROM Condition c");
		
		Collection<Condition> conditions = (Collection<Condition>) query.getResultList();
		
		return json.getJSONForObject(conditions);
	}

	@Override
	public String findCondition(int id) {
		return json.getJSONForObject(manager.find(Condition.class, id));
	}
	
	public String findConditionByName(String conditionName) {
		 Condition findConditionName = manager.find(Condition.class, manager.contains(conditionName));
		 return json.getJSONForObject(findConditionName);
	}
		 
	@Override
	@Transactional(REQUIRED)
	public String addCondition(String conditionName) {
		Condition newCondition = json.getObjectForJSON(conditionName, Condition.class);
		manager.persist(newCondition);
		return "You have successfully added a condition";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteCondition(int id) {
		manager.remove(manager.find(Condition.class, id));
		return "You have successfully deleted a condition";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateCondition(int id, String conditionName) {
		Condition newCondition = json.getObjectForJSON(conditionName, Condition.class);
		Condition oldCondition = manager.find(Condition.class, id);
		if (oldCondition != null) {
			oldCondition.setConditionName(newCondition.getConditionName());
			manager.persist(oldCondition);
		}
		
		return "You have successfully updated a condition";
	}

	public JSONUtil getJson() {
		return json;
	}

	public void setJson(JSONUtil json) {
		this.json = json;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
