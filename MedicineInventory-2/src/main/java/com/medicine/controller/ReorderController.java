package com.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.dao.ReorderDao;
import com.medicine.entity.Reorder;
import com.medicine.service.ReorderService;

@RequestMapping("/ord")
@RestController 
public class ReorderController {
	@Autowired
	private ReorderDao reorderDao;
	@Autowired
	private ReorderService reorderService;
	@PostMapping("/placereOrder")
	public ResponseEntity<String>
	placereOrder(@RequestBody Reorder reorder){
		try{
			reorderService.placeOrder(reorder);
			System.out.println("Reorder"+reorder);
			return ResponseEntity.ok().body("Reorder placed successfully");
			//System.out.println("Order Placed");
			} 
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
			}
	}
	@GetMapping("/allreorders")
	public List<Reorder> 
	findAllReorders(){
		return reorderDao.findAll();
		}

}
