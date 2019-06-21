package com.qa.business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.ConditionServiceImpl;
import com.qa.persistence.domain.Condition;
import com.qa.persistence.repository.ConditionRepository;

@RunWith(MockitoJUnitRunner.class)
public class ConditionServiceImplTest {
	
	@InjectMocks
	private ConditionServiceImpl conSerImpl;
	
	@Mock
	ConditionRepository conRepo;
	
	private static final String MOCK_ARRAY = "[{\"ID\":1,\"conditionName\":\"Cholera\",\"medicineList\":[]}]";
	
	private static final String MOCK_OBJECT = "{\"ID\":1,\"conditionName\":\"Cholera\",\"medicineList\":[]}";
	
	
	@Test
	public void getAllConditionsTest() {
		
		Mockito.when(conRepo.getAllConditions()).thenReturn("[{\"ID\":1,\"conditionName\":\"Cholera\",\"medicineList\":[]}]");
		
		assertEquals(MOCK_ARRAY, conSerImpl.getAllConditions());
	}
	
	@Test
	public void findConditionTest() {
		Mockito.when(conRepo.findCondition(1)).thenReturn("{\"ID\":1,\"conditionName\":\"Cholera\",\"medicineList\":[]}");
		assertEquals(MOCK_OBJECT, conSerImpl.findACondition(1));
	}
	
	@Test
	public void addConditionTest() {
		Mockito.when(conRepo.addCondition(MOCK_OBJECT)).thenReturn("You have successfully added a condition");
		assertEquals("You have successfully added a condition", conSerImpl.addCondition(MOCK_OBJECT));
	}
	
	@Test
	public void deleteConditionTest() {
		Mockito.when(conRepo.deleteCondition(1)).thenReturn("You have successfully deleted a condition");
		assertEquals("You have successfully deleted a condition", conSerImpl.deleteCondition(1));
	}
	
	@Test
	public void updateConditionTest() {
		Mockito.when(conRepo.updateCondition(1, MOCK_OBJECT)).thenReturn("You have successfully updated a condition");
		assertEquals("You have successfully updated a condition", conSerImpl.updateCondition(1, MOCK_OBJECT));
	}

}
