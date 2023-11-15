package com.store.demo.service;


import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import com.store.demo.entity.Order;

public interface OrderService {
	public Order create(JsonNode orderData) ;
	
	public Order findById(Integer id) ;
	
	public List<Order> findByUsername(String username) ;
}
