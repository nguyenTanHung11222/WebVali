package com.websiteVali.service;

import java.util.List;

import com.websiteVali.entity.ChiTietHoaDon;

public interface ChiTietHoaDonService {
	public List<ChiTietHoaDon> getChiTietHoaDonTheoMaHoaDon(String id);
	
	public List<ChiTietHoaDon> getChiTietHoaDonTheoMaSanPham(String id);
	
	public List<ChiTietHoaDon> getChiTietHoaDonTheoMauSanPham(String idSanPham, int idMau);

	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);
	
	public void xoaChiTietHoaDon(String maHoaDon);

	public ChiTietHoaDon getChiTietHoaDonByMaSanPham(String maSanPham);
}
