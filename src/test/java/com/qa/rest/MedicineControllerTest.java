package com.qa.rest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.MedicineService;


@RunWith(MockitoJUnitRunner.class)
public class MedicineControllerTest {
	@InjectMocks
	MedicineController medCon;
	
	@Mock
	MedicineService medSer;
	
	private static final String MOCK_ARRAY = "[{\"id\":1,\"drugName\":\"Statin\",\"stock\":20}]";
	
	private static final String MOCK_OBJECT = "{\"id\":1,\"drugName\":\"Statin\",\"stock\":20}";
	
	@Test
	public void getAllMedicinesTest() {
		Mockito.when(medSer.getAllMedicines()).thenReturn(MOCK_ARRAY);
		assertEquals(MOCK_ARRAY, medCon.getAllMedicines());
	}
	
	@Test
	public void findAMedicineTest() {
		Mockito.when(medSer.findAMedicine(1)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, medCon.findAMedicine(1));
	}
	
//	@Test
//	public void addMedicineTest() {
//		Mockito.when(medSer.addMedicine(MOCK_OBJECT)).thenReturn("You have successfully added a drug");
//		assertEquals("You have successfully added a drug", medCon.addMedicine(MOCK_OBJECT));		
//	}
	
	@Test
	public void deleteMedicineTest() {
		Mockito.when(medSer.deleteMedicine(1)).thenReturn("You have successfully deleted a drug");
		assertEquals("You have successfully deleted a drug", medCon.deleteMedicine(1));
	}
	
	@Test
	public void updateMedicineTest() {
		Mockito.when(medSer.updateMedicine(1, MOCK_OBJECT)).thenReturn("You have successfully updated a drug");
		assertEquals("You have successfully updated a drug", medCon.updateMedicine(1, MOCK_OBJECT));
	}

}
