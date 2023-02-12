package com.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.dao.OrderDao;
import com.medicine.entity.Order;
import com.medicine.service.OrderService;

@RequestMapping("/orders")
@RestController 
public class OrderController{
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDao orderDao;
	@PostMapping("/placeOrder")
	public ResponseEntity<String>
	placeOrder(@RequestBody Order order){
		try{
			orderService.placeOrder(order);
			System.out.println("Order"+order);
			return ResponseEntity.ok().body("Order placed successfully");
			//System.out.println("Order Placed");
			} 
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
			}
	}
	
	@GetMapping("/allOrders")
	public List<Order> 
	findAllOrders(){
		return orderDao.findAll();
	}
	@PostMapping("/accept")
	public ResponseEntity<String>
	acceptOrder(@RequestBody Order order)
	{
		try{
			orderService.acceptOrder(order);
			return ResponseEntity.ok().body("Order accepted");
			//System.out.println("Order Placed");
			}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
			}
		}
	@PostMapping("/reject")
	public ResponseEntity<String>
	rejectOrder(@RequestBody Order order)
	{
		try{
			orderService.rejectOrder(order);
			//qwesdSystem.out.println("Order"+order);
			return ResponseEntity.ok().body("Order rejected");
			//System.out.println("Order Placed");
			}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
			}
	}
	
	/*@GetMapping("/orders/payment-status/{paymentStatus}")
	public Order getOrdersByPaymentStatus(@PathVariable String paymentStatus) {
		return orderService.getOrdersByPaymentStatus(paymentStatus);
		}*/
	
}