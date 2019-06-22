package com.qa.business;

public interface MedicineService {
	
	String getAllMedicines();
	String findAMedicine(int id);
	String addMedicine(int id, String drugName, int stock);
	String deleteMedicine(int id);
	String updateMedicine(int id, String drugName);

}
