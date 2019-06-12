package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.repository.ConditionMapRepository;

public class ConditionMapTest {
	
	ConditionMapRepository conditionMapRepo;
	
	@Before
	public void setup() {
		conditionMapRepo = new ConditionMapRepository();
	}
	
	@Test
	public void getAllConditionsTest() {
		assertEquals("{}", conditionMapRepo.getAllConditions());
	}
	

}
