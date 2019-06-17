package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Medicine;
import com.qa.util.JSONUtil;

@Alternative
public class MedicineMapRepository implements MedicineRepository{
	
	
	Map<Integer, Medicine> medicineMap = new HashMap<Integer, Medicine>();
	
	JSONUtil json;

	@Override
	public String getAllMedicines() {
		return new JSONUtil().getJSONForObject(medicineMap);
	}

	@Override
	public String findMedicine(int id) {
		return new JSONUtil().getJSONForObject(medicineMap.get(1));
	}

	@Override
	public String addMedicine(String drugName) {
		Medicine newMedicine = new JSONUtil().getObjectForJSON(drugName, Medicine.class);
		medicineMap.put(medicineMap.size() + 1, newMedicine);
		return "You have successfully added a drug";
	}

	@Override
	public String deleteMedicine(int id) {
		medicineMap.remove(id);
		return "You have successfully deleted a drug";
	}

	@Override
	public String updateMedicine(int id, String drugName) {
		Medicine newDrug = new JSONUtil().getObjectForJSON(drugName, Medicine.class);
		medicineMap.put(id, newDrug);
		return "You have successfully updated a drug";
	}

	public Map<Integer, Medicine> getMedicineMap() {
		return medicineMap;
	}

	public void setMedicineMap(Map<Integer, Medicine> medicineMap) {
		this.medicineMap = medicineMap;
	}

}
