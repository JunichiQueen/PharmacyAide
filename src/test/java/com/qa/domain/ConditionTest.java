package com.qa.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Condition;
import com.qa.persistence.domain.Medicine;

@RunWith(MockitoJUnitRunner.class)
public class ConditionTest {
	@InjectMocks
	Condition condition;
	
	@Mock
	Condition condition1;
	
	@Before
	public void setup() {
		condition.setID(1);
		condition.setConditionName("Cholera");
		
	}
	
	@Test
	public void getIDTest() {
		Mockito.when(condition1.getID()).thenReturn(1);
		assertEquals(1, condition.getID());
	}
	
	@Test
	public void getConditionNameTest() {
		Mockito.when(condition1.getConditionName()).thenReturn("Cholera");
		assertEquals("Cholera", condition.getConditionName());
	}
	

}
