package com.medicine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.dao.HospitalDao;
import com.medicine.entity.Hospital;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalDao hospitalDao;
	
	public List<Hospital> getAllHospitals(String location)
	{
		return hospitalDao.findBylocation(location);
	}
	
	public List<Hospital> getAllBylocation(String location) {
		return hospitalDao.findBylocation(location);
		
	}

}
