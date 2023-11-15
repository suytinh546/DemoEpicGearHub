package com.store.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.store.demo.entity.*;


public interface ProductDAO extends JpaRepository<Product, Integer>{
	@Query("select p from Product p where p.category.id = ?1")
	List<Product> findByCategoryId(String cid);
}
