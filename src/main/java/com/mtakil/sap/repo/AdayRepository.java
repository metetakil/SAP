package com.mtakil.sap.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mtakil.sap.entity.Aday;


public interface AdayRepository extends CrudRepository<Aday, Long> {

	public Aday findByTcno(String tcno);
	
}
