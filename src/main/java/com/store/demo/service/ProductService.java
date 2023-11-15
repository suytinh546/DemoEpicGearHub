package com.store.demo.service;

import java.util.List;
import java.util.Optional;

import com.store.demo.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);


}
