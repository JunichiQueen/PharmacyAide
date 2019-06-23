package com.qa.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Medicine;

@RunWith(MockitoJUnitRunner.class)
public class MedicineTest {
	@InjectMocks
	Medicine medicine;
	
	@Mock
	Medicine medicine1;
	
	@Before
	public void setup() {
		medicine.setId(1);
		medicine.setDrugName("Steroids");
		medicine.setStock(50);
	}
	
	@Test
	public void getIDTest() {
		Mockito.when(medicine1.getId()).thenReturn(1);
		assertEquals(1, medicine.getId());
	}
	
	@Test
	public void getDrugNameTest() {
		Mockito.when(medicine1.getDrugName()).thenReturn("Steroids");
		assertEquals("Steroids", medicine.getDrugName());
	}
	
	@Test
	public void getStockTest() {
		Mockito.when(medicine1.getStock()).thenReturn(50);
		assertEquals(50, medicine.getStock());
	}

}
