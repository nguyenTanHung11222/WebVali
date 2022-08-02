package com.websiteVali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websiteVali.entity.LienHe;

public interface LienHeRepository extends JpaRepository<LienHe, String> {

	public List<LienHe> findAll();
	
}
