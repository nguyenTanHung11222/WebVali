package com.websiteVali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websiteVali.entity.ChiTietHoaDon;
import com.websiteVali.entity.ChiTietHoaDon_PK;

public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, ChiTietHoaDon_PK> {

	public List<ChiTietHoaDon> findByMauSanPhamSanPhamId(String id);
	
	public List<ChiTietHoaDon> findByMauSanPhamSanPhamIdAndMauSanPhamMauId(String idSanPham, int idMau);
	
	public List<ChiTietHoaDon> findByHoaDonId(String id);

	public void deleteByHoaDonId(String maHoaDon);
	
	public ChiTietHoaDon findFirstByMauSanPhamSanPhamId(String idSanPham);
	
}
