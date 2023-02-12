package com.medicine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.dao.HospitalMedicalStoreDao;
import com.medicine.entity.HospitalMedicalStore;

@Service
public class HospitalMedicalStoreService {
	
	@Autowired
	private HospitalMedicalStoreDao  hospitalMedicalStoreDao;
		
		/*public List<HospitalMedicalStore> getAllHospitalstore(String area)
		{
			return hospitalMedicalStoreDao.findByarea(area);
		}*/

		public List<HospitalMedicalStore> getAllByarea(String area) {
			return hospitalMedicalStoreDao.findByarea(area);
		}

}
