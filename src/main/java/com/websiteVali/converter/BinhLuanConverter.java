package com.websiteVali.converter;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.websiteVali.dto.BinhLuanDTO;
import com.websiteVali.entity.BinhLuan;
import com.websiteVali.entity.NguoiDung;
import com.websiteVali.entity.SanPham;
import com.websiteVali.service.NguoiDungService;
import com.websiteVali.service.SanPhamService;

@Component
public class BinhLuanConverter {

	@Autowired
	private NguoiDungService nguoiDungService;
	@Autowired
	private SanPhamService sanPhamService;

	public BinhLuan toBinhLuan(BinhLuanDTO binhLuanDTO) {

		if (binhLuanDTO == null)
			return null;

		String maNguoiDung = binhLuanDTO.getMaNguoiDung();
		String maSanPham = binhLuanDTO.getMaSanPham();
		Date ngayBinhLuan = binhLuanDTO.getNgayBinhLuan();
		String noiDung = binhLuanDTO.getNoiDung();
		int danhGia = binhLuanDTO.getDanhGia();
		
		NguoiDung nguoiDung = nguoiDungService.getNguoiDungById(maNguoiDung);
		SanPham sanPham = sanPhamService.getSanPhamTheoID(maSanPham);
		

		BinhLuan binhLuan = new BinhLuan(nguoiDung, sanPham, noiDung, ngayBinhLuan, danhGia);
		return binhLuan;
	}

	public BinhLuanDTO toBinhLuanDTO(BinhLuan binhLuan) {

		if (binhLuan == null)
			return null;

		String maNguoiDung = binhLuan.getNguoiDung().getId();
		String maSanPham = binhLuan.getSanPham().getId();
		Date ngayBinhLuan = binhLuan.getNgayBinhLuan();
		String noiDung = binhLuan.getBinhLuan();
		int danhGia = binhLuan.getDanhGia();
		
		BinhLuanDTO binhLuanDTO = new BinhLuanDTO(maNguoiDung, maSanPham, ngayBinhLuan, noiDung, danhGia);

		return binhLuanDTO;
	}
	
}
