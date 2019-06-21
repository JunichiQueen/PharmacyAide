package com.qa.persistence.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Condition;
import com.qa.persistence.domain.Medicine;
import com.qa.persistence.repository.ConditionMapRepository;
import com.qa.persistence.repository.MedicineMapRepository;
import com.qa.util.JSONUtil;

public class ConditionMapTest {
	
	ConditionMapRepository conditionMapRepo;
	MedicineMapRepository medicineMapRepo;
	JSONUtil json;
	
	@Before
	public void setup() {
		conditionMapRepo = new ConditionMapRepository();
		medicineMapRepo = new MedicineMapRepository();
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
	
//	@Test
//	public void findConditionTest() {
//		Condition con1 = new Condition(1, "Salmonellosis");
//		Condition con2 = new Condition(2, "Flu");
//		conditionMapRepo.getConditionMap().put(1, con1);
//		conditionMapRepo.getConditionMap().put(2, con2);
//		System.out.println(conditionMapRepo.findCondition(1));
//		assertEquals("{\"ID\":1,\"conditionName\":\"Salmonellosis\"}", conditionMapRepo.findCondition(1));
//	}
	
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
	
	@Test
	public void getAllMedicinesTest() {
		assertEquals("{}", medicineMapRepo.getAllMedicines());
	}
	
	@Test
	public void getAllMedicinesTest2() {
		Medicine med1 = new Medicine(1, "Paracetamol", 30);
		Medicine med2 = new Medicine(2, "Lemsip", 45);
		medicineMapRepo.getMedicineMap().put(1, med1);
		medicineMapRepo.getMedicineMap().put(2, med2);
		assertEquals(2, medicineMapRepo.getMedicineMap().size());
	}
	
	@Test
	public void findMedicineTest() {
		Medicine med1 = new Medicine(1, "Paracetamol", 30);
		Medicine med2 = new Medicine(2, "Lemsip", 45);
		medicineMapRepo.getMedicineMap().put(1, med1);
		medicineMapRepo.getMedicineMap().put(2, med2);
		//System.out.println(medicineMapRepo.findMedicine(1));
		assertEquals("{\"id\":1,\"drugName\":\"Paracetamol\",\"stock\":30}", medicineMapRepo.findMedicine(1));
	}
	
	@Test
	public void addMedicineTest() {
		Medicine med1 = new Medicine(1, "Paracetamol", 30);
		String drugString = json.getJSONForObject(med1);
		//System.out.println(drugString);
		medicineMapRepo.addMedicine(drugString);
		assertEquals(1, medicineMapRepo.getMedicineMap().size());
		assertEquals("You have successfully added a drug", medicineMapRepo.addMedicine(drugString));
		
	}
	
	@Test
	public void deleteMedicineTest() {
		Medicine med1 = new Medicine(1, "Paracetamol", 30);
		Medicine med2 = new Medicine(2, "Lemsip", 45);
		medicineMapRepo.getMedicineMap().put(1, med1);
		medicineMapRepo.getMedicineMap().put(2, med2);
		medicineMapRepo.deleteMedicine(1);
		assertEquals(1, medicineMapRepo.getMedicineMap().size());
		assertEquals("You have successfully deleted a drug", medicineMapRepo.deleteMedicine(1));
	}
	
	@Test
	public void updateMedicineTest() {
		Medicine med1 = new Medicine(1, "Paracetamol", 30);
		Medicine med2 = new Medicine(2, "Lemsip", 45);
		Medicine med3 = new Medicine(1, "Aspirin", 80);
		String medString = new JSONUtil().getJSONForObject(med3);
		medicineMapRepo.getMedicineMap().put(1, med1);
		medicineMapRepo.getMedicineMap().put(2, med2);
		medicineMapRepo.updateMedicine(1, medString);
		assertEquals("Aspirin", medicineMapRepo.getMedicineMap().get(1).getDrugName());
		
	}

	

}
