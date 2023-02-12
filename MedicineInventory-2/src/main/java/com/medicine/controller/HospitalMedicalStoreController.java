package com.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.entity.HospitalMedicalStore;
import com.medicine.service.HospitalMedicalStoreService;

@RequestMapping("/lists")
@RestController
public class HospitalMedicalStoreController {
	
	@Autowired
	private HospitalMedicalStoreService hospitalMedicalStoreService;
	
	@GetMapping("/medicalstore/{area}")
	public List<HospitalMedicalStore> getAllhospitalsstore(@PathVariable String area)
	{
		return hospitalMedicalStoreService.getAllByarea(area);
	}

}
