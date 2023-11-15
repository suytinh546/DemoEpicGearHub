package com.store.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import com.store.demo.entity.*;

public interface AuthoritiesDAO extends JpaRepository<Authorities, String>{

}
