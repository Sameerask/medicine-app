package com.medicine.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.medicine.dao.OrderDao;
import com.medicine.dto.OrderDto;
import com.medicine.entity.Order;

@Service
public class OrderService{
	@Autowired
	private OrderDao orderDao;
	/*public void placeOrder(Order order){
		Order ord = new Order();
		ord.setStatus(order.getStatus());
		order.setQuantity(order.getQuantity());
		order.setMedicine(order.getMedicine());
		orderDao.save(order);
		}*/
	
	public void placeOrder(Order order)
	{
		order.setStatus("Ordered");
		order.setQuantity(order.getQuantity());
		order.setMedicine(order.getMedicine());
		orderDao.save(order);
	}
	public List<OrderDto> getAllOrders() {
		// TODO Auto-generated method stub
		Iterable<Order> iterable = orderDao.findAll();
		List<OrderDto> orders = StreamSupport.stream(iterable.spliterator(),false).map(order->{
			OrderDto dto = new OrderDto();
			BeanUtils.copyProperties(order, dto);
			return dto;
		}).collect(Collectors.toList());
		return null;
	}
	public void acceptOrder(Order order) {
		order.setStatus("Order Accepted");
		orderDao.save(order);
		}
	public void rejectOrder(Order order) {
		order.setStatus("Order Rejected");
		orderDao.save(order);
		}
	/*public List<Order> getOrdersByPaymentStatus(String paymentStatus) {
		return orderDao.findByPaymentStatus(paymentStatus);}
	public Order getOrdersByPaymentStatus(String paymentStatus){
		return orderDao.findByPaymentStatus(paymentStatus);
		}*/
	


}
