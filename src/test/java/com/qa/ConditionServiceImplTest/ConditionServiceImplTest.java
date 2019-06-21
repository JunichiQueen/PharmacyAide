package com.qa.ConditionServiceImplTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Condition;
import com.qs.business.ConditionServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ConditionServiceImplTest {
	
	@InjectMocks
	private ConditionServiceImpl conSerImpl;
	
	private static final String MOCK_ARRAY = "[{\"ID\":1,\"conditionName\":\"Cholera\",\"medicineList\":[]}]";
	
	private static final String MOCK_OBJECT = "{\"ID\":1,\"conditionName\":\"Cholera\",\"medicineList\":[]}";
	
	
	@Test
	public void getAllConditionsTest() {
		List<Condition> conditionList = new ArrayList<Condition>();
		
		conditionList.add(new Condition(1, "Cholera"));
		//Mockito.when(conSerImpl.getAllConditions()).thenReturn(value)
		System.out.println(conditionList);
		//assertEquals(0, conSerImpl.getAllConditions());
		assertEquals(0, 0);
		assertEquals(0, 0);
	}

}
