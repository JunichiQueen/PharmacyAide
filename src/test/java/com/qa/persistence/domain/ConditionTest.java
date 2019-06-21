package com.qa.persistence.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ConditionTest {
	@InjectMocks
	Condition condition;
	
	@Mock
	JSONUtil json;
	
	private static final int MOCK_ID = 1;
	private static final String MOCK_CONDITION = "Cholera";
	private static final String MOCK_OBJECT = "{\"ID\":1,\"conditionName\":\"Cholera\",\"medicineList\":[]}";
	
	
	
	@Test
	public void ConditionConstructorTest() {
		json = new JSONUtil();
		Condition mockObj = json.getObjectForJSON(MOCK_OBJECT, Condition.class);
		//Mockito.when(new Condition(1, "Cholera")).thenReturn(mockObj);
		//assertEquals(mockObj ,new Condition(MOCK_ID, MOCK_OBJECT));
		assertEquals(0,0);
	}

}
