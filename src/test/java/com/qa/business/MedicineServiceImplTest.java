package com.qa.business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.MedicineServiceImpl;
import com.qa.persistence.repository.MedicineRepository;

@RunWith(MockitoJUnitRunner.class)
public class MedicineServiceImplTest {
	
	@InjectMocks
	private MedicineServiceImpl medSerImpl;
	
	@Mock
	MedicineRepository medicineRepo;
	
	private static final String MOCK_ARRAY = "[{\"id\":1,\"drugName\":\"Statin\",\"stock\":20}]";
	
	private static final String MOCK_OBJECT = "{\"id\":1,\"drugName\":\"Statin\",\"stock\":20}";

	
	@Test
	public void getAllMedicinesTest() {
		Mockito.when(medicineRepo.getAllMedicines()).thenReturn(MOCK_ARRAY);
		assertEquals(MOCK_ARRAY, medSerImpl.getAllMedicines());
	}
	
	@Test
	public void findMedicineTest() {
		Mockito.when(medicineRepo.findMedicine(1)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, medSerImpl.findAMedicine(1));
	}
	
	@Test
	public void addMedicineTest() {
		Mockito.when(medicineRepo.addMedicine(MOCK_OBJECT)).thenReturn("You have successfully added a drug");
		assertEquals("You have successfully added a drug", medSerImpl.addMedicine(MOCK_OBJECT));
	}
	
	@Test
	public void deleteMedicineTest() {
		Mockito.when(medicineRepo.deleteMedicine(1)).thenReturn("You have successfully deleted a drug");
		assertEquals("You have successfully deleted a drug", medSerImpl.deleteMedicine(1));
	}
	
	@Test
	public void updateMedicineTest() {
		Mockito.when(medicineRepo.updateMedicine(1, MOCK_OBJECT)).thenReturn("You have successfully updated a drug");
		assertEquals("You have successfully updated a drug", medSerImpl.updateMedicine(1, MOCK_OBJECT));
	}

}
