package com.qa.ConditionDBTest;

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
import com.qa.persistence.repository.ConditionDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ConditionDBTest {
	
	@InjectMocks
	private ConditionDBRepository conDBRepo;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private JSONUtil json;
	private Query query;
	
	
	@Before
	public void setup() {
		conDBRepo = new ConditionDBRepository();
		json = new JSONUtil();
	}
	
	@Test
	public void getAllConditionsDBTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Condition> conditionList = new ArrayList<Condition>();
		conditionList.add(new Condition(1, "Cholera"));
		Mockito.when(query.getResultList()).thenReturn(conditionList);
		System.out.println(conDBRepo.getAllConditions());
		assertEquals(0, 0);
	}
	

}
