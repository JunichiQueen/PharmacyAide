package com.qa.MedicineDBTest;

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

	private JSONUtil json;
	
	private static final String MOCK_ARRAY = "[{\"id\":1,\"drugName\":\"Statin\",\"stock\":20}]";
	
	private static final String MOCK_OBJECT = "{\"id\":1,\"drugName\":\"Statin\",\"stock\":20}";

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
		System.out.println(medDBRepo.getAllMedicines());
		assertEquals("[{\"id\":1,\"drugName\":\"Statin\",\"stock\":20}]", medDBRepo.getAllMedicines());
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
		String reply = medDBRepo.addMedicine(MOCK_OBJECT);
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
