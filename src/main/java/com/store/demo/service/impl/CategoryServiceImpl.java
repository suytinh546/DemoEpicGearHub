package com.store.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.demo.DAO.CategoryDAO;
import com.store.demo.entity.Category;
import com.store.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

		@Autowired
		CategoryDAO cdao;

		@Override
		public List<Category> findAll() {
			// TODO Auto-generated method stub
			return cdao.findAll();
		}
}
