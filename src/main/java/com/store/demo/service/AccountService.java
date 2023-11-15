package com.store.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.demo.entity.Account;
@Service
public interface AccountService {
	public List<Account> findAll() ;
	public Account findById(String username) ;
	public List<Account> getAdministrators() ;
}
