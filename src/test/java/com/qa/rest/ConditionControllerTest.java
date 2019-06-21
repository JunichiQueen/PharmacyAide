package com.qa.rest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.ConditionService;

@RunWith(MockitoJUnitRunner.class)
public class ConditionControllerTest {
	
	@InjectMocks 
	ConditionController conCon;
	
	@Mock
	ConditionService conSer;
	
	private static final String MOCK_ARRAY = "[{\"ID\":1,\"conditionName\":\"Cholera\",\"medicineList\":[]}]";
	
	private static final String MOCK_OBJECT = "{\"ID\":1,\"conditionName\":\"Cholera\",\"medicineList\":[]}";
	
	@Test
	public void getAllConditionsTest() {
		Mockito.when(conSer.getAllConditions()).thenReturn(MOCK_ARRAY);
		assertEquals(MOCK_ARRAY, conCon.getAllConditions());
	}
	
	@Test
	public void findConditionTest() {
		Mockito.when(conSer.findACondition(1)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, conCon.findACondition(1));
	}
	
	@Test
	public void addConditionTest() {
		Mockito.when(conSer.addCondition(MOCK_OBJECT)).thenReturn("You have successfully added a condition");
		assertEquals("You have successfully added a condition", conCon.addCondition(MOCK_OBJECT));
	}
	
	@Test
	public void deleteConditionTest() {
		Mockito.when(conSer.deleteCondition(1)).thenReturn("You have successfully deleted a condition");
		assertEquals("You have successfully deleted a condition", conCon.deleteCondition(1));
	}
	
	@Test
	public void updateConditionTest() {
		Mockito.when(conSer.updateCondition(1, MOCK_OBJECT)).thenReturn("You have successfully updated a condition");
		assertEquals("You have successfully updated a condition", conCon.updateCondition(1, MOCK_OBJECT));
	}

}
