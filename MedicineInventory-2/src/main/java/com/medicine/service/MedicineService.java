package com.medicine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.dao.MedicineDao;
import com.medicine.entity.Medicine;

@Service
public class MedicineService {
	private final MedicineDao medicineDao;
	
	@Autowired
	public MedicineService(MedicineDao medicineDao) {
		this.medicineDao=medicineDao;
	}
	
	public List<Medicine> getLowStockMedicine(){
		return medicineDao.finAllByLowStock(50);
	}
	
	public Medicine addMedicine(Medicine medicine) {
	    return medicineDao.save(medicine);
	  }
	  public List<Medicine> getAllMedicines() {
	    return medicineDao.findAll();
	  }
	  public Medicine updateMedicine(Long medicineId, Medicine medicine) {
	    Medicine existingMedicine = medicineDao.findById(medicineId).orElseThrow(() -> new IllegalArgumentException("Medicine not found"));
	    
	    existingMedicine.setName(medicine.getName());
	    existingMedicine.setDescription(medicine.getDescription());
	    existingMedicine.setStock(medicine.getStock());
	    return medicineDao.save(medicine);
	    }

}
