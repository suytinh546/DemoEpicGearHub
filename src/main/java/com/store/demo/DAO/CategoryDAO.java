package com.store.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.demo.entity.*;


public interface CategoryDAO extends JpaRepository<Category, String>{

}
