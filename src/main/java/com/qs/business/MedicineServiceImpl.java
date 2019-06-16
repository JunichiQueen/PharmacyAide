package com.qs.business;

import javax.inject.Inject;

import com.qa.persistence.repository.MedicineRepository;

public class MedicineServiceImpl implements MedicineService {
	
	@Inject
	MedicineRepository medicineRepo;

	@Override
	public String getAllMedicines() {
		return medicineRepo.getAllMedicines();
	}

	@Override
	public String findAMedicine(int id) {
		return medicineRepo.findMedicine(id);
	}

	@Override
	public String addMedicine(String drugName) {
		return medicineRepo.addMedicine(drugName);
	}

	@Override
	public String deleteMedicine(int id) {
		return medicineRepo.deleteMedicine(id);
	}

	@Override
	public String updateMedicine(int id, String drugName) {
		return medicineRepo.updateMedicine(id, drugName);
	}

}
