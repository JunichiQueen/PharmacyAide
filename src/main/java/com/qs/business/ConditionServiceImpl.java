package com.qs.business;

import javax.inject.Inject;

import com.qa.persistence.repository.ConditionRepository;

public class ConditionServiceImpl implements ConditionService{
	
	@Inject
	ConditionRepository conRepo;

	@Override
	public String getAllAccounts() {
		
		return conRepo.getAllConditions();
	}

	@Override
	public String findAnAccount(int id) {
		return conRepo.findCondition(id);
	}

	@Override
	public String addAccount(String conditionName) {
		return conRepo.addCondition(conditionName);
	}

	@Override
	public String deleteAccount(int id) {
		return conRepo.deleteCondition(id);
	}

	@Override
	public String updateAccount(int id, String conditionName) {
		return conRepo.updateCondition(id, conditionName);
	}

}
