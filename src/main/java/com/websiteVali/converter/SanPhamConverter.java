package com.websiteVali.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.websiteVali.dto.MauSanPhamDTO;
import com.websiteVali.dto.SanPhamDTO;
import com.websiteVali.entity.DongSanPham;

import com.websiteVali.entity.SanPham;
import com.websiteVali.service.DongSanPhamService;
import com.websiteVali.service.MauSanPhamService;


@Component
public class SanPhamConverter {


	@Autowired
	DongSanPhamService dongSanPhamService;
	
	@Autowired
	MauSanPhamService mauSanPhamService;

	@Autowired
	MauSanPhamConverter mauSanPhamConverter;

	public SanPham toSanPham(SanPhamDTO sanPhamDTO) {

		if (sanPhamDTO == null)
			return null;

		String id = sanPhamDTO.getId();
		String tenSanPham = sanPhamDTO.getTenSanPham();
		String moTa = sanPhamDTO.getMoTa();
		double giaBan = sanPhamDTO.getGiaBan();
		double giaNhap = sanPhamDTO.getGiaNhap();
		String xuatXu = sanPhamDTO.getXuatXu();
		boolean trangThai = sanPhamDTO.isTrangThai();
		int baoHanh = sanPhamDTO.getBaoHanh();
		int namSanXuat = sanPhamDTO.getNamSanXuat();
		DongSanPham dongSanPham = dongSanPhamService.getDongSanPhamBangMa(sanPhamDTO.getMaDongSanPham());


		SanPham sanPham = new SanPham(id, tenSanPham, moTa, giaNhap, giaBan, xuatXu, trangThai, baoHanh, namSanXuat,
				 dongSanPham);


		return sanPham;
	}

	public SanPhamDTO toSanPhamDTO(SanPham sanPham) {

		if (sanPham == null)
			return null;

		String id = sanPham.getId();
		String tenSanPham = sanPham.getTenSanPham();
		String moTa = sanPham.getMoTa();
		double giaNhap = sanPham.getGiaNhap();
		double giaBan = sanPham.getGiaBan();
		String xuatXu = sanPham.getXuatXu();
		boolean trangThai = sanPham.isTrangThai();
		int baoHanh = sanPham.getBaoHanh();
		int namSanXuat = sanPham.getNamSanXuat();
		String maDongSanPham = sanPham.getDongSanPham().getId();
		String tenDongSanPham = sanPham.getDongSanPham().getTenDongSanPham();
		String maLoaiSanPham = sanPham.getDongSanPham().getLoaiSanPham().getId();
		String tenLoaiSanPham = sanPham.getDongSanPham().getLoaiSanPham().getTenLoaiSanPham();
		String maThuongHieu = sanPham.getDongSanPham().getThuongHieu().getId();
		String tenThuongHieu = sanPham.getDongSanPham().getThuongHieu().getTenThuongHieu();
		String hinhAnhBase64 = "";

		List<MauSanPhamDTO> mauSanPhamDTOs = mauSanPhamService.getMauSanPhamDTOTheoMaSanPham(id);
		
		if(mauSanPhamDTOs.size() > 0) {
			hinhAnhBase64 = mauSanPhamDTOs.get(0).getHinhAnhBase64();
		}
		
		return new SanPhamDTO(id, tenSanPham, moTa, giaNhap, giaBan, xuatXu, trangThai, baoHanh, namSanXuat,
				 maDongSanPham, tenDongSanPham, maLoaiSanPham, tenLoaiSanPham, maThuongHieu, tenThuongHieu, hinhAnhBase64);
		
	}
	
	public SanPhamDTO toSanPhamDTO_TrangSanPham(SanPham sanPham) {

		if (sanPham == null)
			return null;

		String id = sanPham.getId();
		String tenSanPham = sanPham.getTenSanPham();
		String xuatXu = sanPham.getXuatXu();
		String tenLoaiSanPham = sanPham.getDongSanPham().getLoaiSanPham().getTenLoaiSanPham();
		String tenThuongHieu = sanPham.getDongSanPham().getThuongHieu().getTenThuongHieu();
		
		return new SanPhamDTO(id, tenSanPham, xuatXu, tenLoaiSanPham, tenThuongHieu, 0);
		
	}
}
