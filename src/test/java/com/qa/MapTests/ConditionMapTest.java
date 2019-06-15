package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Condition;
import com.qa.persistence.repository.ConditionMapRepository;
import com.qa.util.JSONUtil;

public class ConditionMapTest {
	
	ConditionMapRepository conditionMapRepo;
	JSONUtil json;
	
	@Before
	public void setup() {
		conditionMapRepo = new ConditionMapRepository();
		json = new JSONUtil();
	}
	
	@Test
	public void getAllConditionsTest() {
		assertEquals("{}", conditionMapRepo.getAllConditions());
	}
	
	@Test
	public void getAllConditionsTest2() {
		Condition con1 = new Condition(1, "Salmonellosis");
		Condition con2 = new Condition(2, "Flu");
		conditionMapRepo.getConditionMap().put(1, con1);
		conditionMapRepo.getConditionMap().put(2, con2);
		assertEquals(2, conditionMapRepo.getConditionMap().size());
	}
	
	@Test
	public void findConditionTest() {
		Condition con1 = new Condition(1, "Salmonellosis");
		Condition con2 = new Condition(2, "Flu");
		conditionMapRepo.getConditionMap().put(1, con1);
		conditionMapRepo.getConditionMap().put(2, con2);
		System.out.println(conditionMapRepo.findCondition(1));
		assertEquals("{\"ID\":1,\"conditionName\":\"Salmonellosis\"}", conditionMapRepo.findCondition(1));
	}
	
	@Test
	public void addConditionTest() {
		Condition con1 = new Condition(1, "Salmonellosis");
		String jsonString = json.getJSONForObject(con1);
		//System.out.println(jsonString);
		conditionMapRepo.addCondition(jsonString);
		assertEquals(1, conditionMapRepo.getConditionMap().size());
		assertEquals("You have successfully added a condition", conditionMapRepo.addCondition(jsonString));
	}
	
	@Test
	public void deleteCondition() {
		Condition con1 = new Condition(1, "Salmonellosis");
		Condition con2 = new Condition(2, "Flu");
		conditionMapRepo.getConditionMap().put(1, con1);
		conditionMapRepo.getConditionMap().put(2, con2);
		conditionMapRepo.deleteCondition(1);
		assertEquals(1, conditionMapRepo.getConditionMap().size());
		assertEquals("You have successfully deleted a condition", conditionMapRepo.deleteCondition(1));
	}
	
	@Test
	public void updateCondition() {
		Condition con1 = new Condition(1, "Salmonellosis");
		Condition con2 = new Condition(2, "Flu");
		Condition con3 = new Condition(1, "Headache");
		String jsonString = json.getJSONForObject(con3);
		conditionMapRepo.getConditionMap().put(1, con1);
		conditionMapRepo.getConditionMap().put(2, con2);
		conditionMapRepo.updateCondition(1, jsonString);
		//System.out.println(jsonString);
		assertEquals("Headache", conditionMapRepo.getConditionMap().get(1).getConditionName());
	}

	

}
