package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.repository.ConditionRepository;

public class ConditionServiceImpl implements ConditionService{
	
	@Inject
	ConditionRepository conRepo;

	@Override
	public String getAllConditions() {
		
		return conRepo.getAllConditions();
	}

	@Override
	public String findACondition(int id) {
		return conRepo.findCondition(id);
	}

	@Override
	public String addCondition(String conditionName) {
		return conRepo.addCondition(conditionName);
	}

	@Override
	public String deleteCondition(int id) {
		return conRepo.deleteCondition(id);
	}

	@Override
	public String updateCondition(int id, String conditionName) {
		return conRepo.updateCondition(id, conditionName);
	}

}
