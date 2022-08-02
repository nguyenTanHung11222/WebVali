package com.websiteVali.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.websiteVali.entity.BinhLuan;
import com.websiteVali.entity.BinhLuan_PK;

public interface BinhLuanRepository extends JpaRepository<BinhLuan, BinhLuan_PK> {

	public List<BinhLuan> findBySanPhamId(String id, Sort sort);
	
}
