package com.store.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.demo.entity.*;

public interface AccountDAO extends JpaRepository<Account, String>{
	@Query("SELECT DISTINCT ar.account  FROM Authorities ar WHERE ar.role.id IN ('1', '2','3')")
	List<Account> getAdministrators();

}
