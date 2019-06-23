package com.qa.persistence.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Condition;
import com.qa.persistence.domain.Medicine;
import com.qa.persistence.repository.MedicineDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class MedicineDBTest {
	@InjectMocks
	private MedicineDBRepository medDBRepo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;
	
	@Mock
	Medicine newMedicine;
	
	@Mock
	Condition newCondition;
	
	@Mock
	List<Medicine> medicineList2 = new ArrayList<Medicine>();

	private JSONUtil json;
	
	private static final String MOCK_ARRAY = "[{\"id\":1,\"drugName\":\"Statin\",\"stock\":20}]";
	
	private static final String MOCK_OBJECT = "{\"id\":1,\"drugName\":\"Statin\",\"stock\":20}";
	
	private static final int MOCK_ID = 1;
	
	private static final String MOCK_DRUGNAME = "{drugName: Roids}";
	
	private static final int MOCK_STOCK = 50;
	

	@Before
	public void setup() {
		medDBRepo.setManager(manager);
		json = new JSONUtil();
		medDBRepo.setJson(json);
	}
	
	@Test
	public void getAllMedicinesDBTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Medicine> medicineList = new ArrayList<Medicine>();
		medicineList.add(new Medicine(1, "Statin", 20));
		Mockito.when(query.getResultList()).thenReturn(medicineList);
		assertEquals(MOCK_ARRAY, medDBRepo.getAllMedicines());
	}
	
	@Test
	public void findAMedicineDBTest() {
		List<Medicine> medicineList = new ArrayList<Medicine>();
		medicineList.add(new Medicine(1, "Statin", 20));
		Mockito.when(manager.find(Medicine.class, 1)).thenReturn(medicineList.get(0));
		assertEquals(MOCK_OBJECT, medDBRepo.findMedicine(1));
	}
	
	@Test
	public void addAMedicineDBTest() {
		List<Condition> conditionList = new ArrayList<Condition>();
		conditionList.add(new Condition(1, "Cholera"));
		Mockito.when(json.getObjectForJSON(MOCK_DRUGNAME, Medicine.class)).thenReturn(newMedicine);
		newMedicine.setStock(MOCK_STOCK);
		Mockito.when(manager.find(Condition.class, 1)).thenReturn(newCondition);
		newCondition.getMedicineList().add(newMedicine);
		String reply = medDBRepo.addMedicine(MOCK_ID, MOCK_DRUGNAME, MOCK_STOCK);
		assertEquals("You have successfully added a drug", reply);
	}
	
	@Test
	public void deleteMedicineDBTest() {
		String reply = medDBRepo.deleteMedicine(1);
		assertEquals("You have successfully deleted a drug", reply);
	}
	
	@Test
	public void updateMedicineDBTEst() {
		String reply = medDBRepo.updateMedicine(1, "{ drugName : Vancomycin, stock : 30 }");
		assertEquals("You have successfully updated a drug", reply);
	}


}
