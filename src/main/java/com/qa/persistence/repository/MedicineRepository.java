package com.qa.persistence.repository;

public interface MedicineRepository {
	
	String getAllMedicines();
	String findMedicine(int id);
	String addMedicine(String drugName);
	String deleteMedicine(int id);
	String updateMedicine(int id, String drugName);

}
