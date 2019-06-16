package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Condition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String conditionName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "condition", fetch = FetchType.EAGER, orphanRemoval = true)
	List<Medicine> medicineList = new ArrayList<>();
	
	public Condition(int ID, String conditionName) {
		this.ID = ID;
		this.conditionName = conditionName;
	}
	
	public Condition() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public List<Medicine> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(List<Medicine> medicineList) {
		this.medicineList = medicineList;
	}
	

}
