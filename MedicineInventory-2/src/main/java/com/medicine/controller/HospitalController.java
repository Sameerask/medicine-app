package com.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.entity.Hospital;
import com.medicine.service.HospitalService;

@RestController
@RequestMapping("/list")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping("/hospitals/{location}")
	public List<Hospital> getAllHospitals(@PathVariable String location)
	{
		return hospitalService.getAllBylocation(location);
	}

}
