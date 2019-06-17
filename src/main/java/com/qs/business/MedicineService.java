package com.qs.business;

public interface MedicineService {
	
	String getAllMedicines();
	String findAMedicine(int id);
	String addMedicine(String drugName);
	String deleteMedicine(int id);
	String updateMedicine(int id, String drugName);

}
