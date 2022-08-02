package com.websiteVali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websiteVali.entity.Mau;

public interface MauRepository extends JpaRepository<Mau, Integer> {

	public List<Mau> findAll();

	public Mau findMauByTenMau(String tenMau);
	
}
