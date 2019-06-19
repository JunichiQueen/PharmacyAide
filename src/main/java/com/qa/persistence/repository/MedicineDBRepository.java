package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Medicine;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

@Default
@Transactional(SUPPORTS)
public class MedicineDBRepository implements MedicineRepository {

	@Inject
	private JSONUtil json;

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Override
	public String getAllMedicines() {
		Query query = manager.createQuery("SELECT m FROM Medicine m");
		Collection<Medicine> medicines = query.getResultList();
		return json.getJSONForObject(medicines);
	}

	@Override
	public String findMedicine(int id) {
		return json.getJSONForObject(manager.find(Medicine.class, id));
	}

	@Override
	@Transactional(REQUIRED)
	public String addMedicine(String drugName) {
		Medicine newMedicine = new JSONUtil().getObjectForJSON(drugName, Medicine.class);
		manager.persist(newMedicine);
		return "You have successfully added a drug";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteMedicine(int id) {
		manager.remove(manager.find(Medicine.class, id));
		return "You have successfully deleted a drug";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateMedicine(int id, String drugName) {
		Medicine newMedicine = json.getObjectForJSON(drugName, Medicine.class);
		Medicine oldMedicine = manager.find(Medicine.class, id);
		if (oldMedicine != null) {
			oldMedicine.setDrugName(newMedicine.getDrugName());
			manager.persist(oldMedicine);
		}
		return "You have successfully updated a drug";
	}

	public JSONUtil getJson() {
		return json;
	}

	public void setJson(JSONUtil json) {
		this.json = json;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
