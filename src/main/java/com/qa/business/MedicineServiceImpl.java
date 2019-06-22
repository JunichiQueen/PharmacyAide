package com.qa.business;

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
	public String addMedicine(int id, String drugName, int stock) {
		return medicineRepo.addMedicine(id, drugName, stock);
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
