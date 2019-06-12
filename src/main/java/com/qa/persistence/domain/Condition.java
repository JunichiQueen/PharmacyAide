package com.qa.persistence.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Condition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String conditionName;
	
	//@ManyToOne
	//Set<Medicine> medicineList = new HashSet<Medicine>();
	
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
	

}
