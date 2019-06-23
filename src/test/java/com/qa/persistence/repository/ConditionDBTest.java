package com.qa.persistence.repository;

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
	private Query query;
	
	@Mock
	private Condition condition;

	private JSONUtil json;
	
	private static final String MOCK_ARRAY = "[{\"ID\":1,\"conditionName\":\"Cholera\",\"medicineList\":[]}]";
	
	private static final String MOCK_OBJECT = "{\"ID\":1,\"conditionName\":\"Cholera\",\"medicineList\":[]}";

	@Before
	public void setup() {
		conDBRepo.setManager(manager);
		json = new JSONUtil();
		conDBRepo.setJson(json);
	}

	@Test
	public void getAllConditionsDBTest() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		
		List<Condition> conditionList = new ArrayList<Condition>();
		
		conditionList.add(new Condition(1, "Cholera"));
		
		Mockito.when(query.getResultList()).thenReturn(conditionList);
		
		assertEquals(MOCK_ARRAY, conDBRepo.getAllConditions());
	}
	
	@Test
	public void findConditionDBTest() {
		
		List<Condition> conditionList = new ArrayList<Condition>();

		conditionList.add(new Condition(1, "Cholera"));
		
		Mockito.when(manager.find(Condition.class, 1)).thenReturn(conditionList.get(0));
		
		assertEquals(MOCK_OBJECT, conDBRepo.findCondition(1));
	}

	@Test
	public void addConditionDBTest() {
		
		String reply = conDBRepo.addCondition(MOCK_OBJECT);
		assertEquals("You have successfully added a condition", reply);
		
	}
	
	@Test
	public void deleteConditionDBTest() {
		 String reply = conDBRepo.deleteCondition(1);
		 assertEquals("You have successfully deleted a condition", reply);
	}
	
	@Test
	public void updateCondition() {
		String reply = conDBRepo.updateCondition(1, "{ conditionName : Pertussis }");
		assertEquals("You have successfully updated a condition", reply);
	}
	

}
