package com.websiteVali.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websiteVali.converter.MauSanPhamConverter;
import com.websiteVali.dto.MauSanPhamDTO;
import com.websiteVali.entity.Mau;
import com.websiteVali.entity.MauSanPham;
import com.websiteVali.repository.MauSanPhamRepository;
import com.websiteVali.service.ChiTietHoaDonService;
import com.websiteVali.service.MauSanPhamService;

@Service
public class MauSanPhamServiceImpl implements MauSanPhamService {

	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	@Autowired
	private MauSanPhamRepository mauSanPhamRepository;
	@Autowired
	private MauSanPhamConverter mauSanPhamConverter;

	@Override
	public List<MauSanPham> getMauSanPhamTheoMaSanPham(String id) {
		return mauSanPhamRepository.findBySanPhamId(id);
	}

	@Override
	public Mau getMauSanPhamTheoTenMau(String tenMau) {
		return mauSanPhamRepository.findByMauTenMau(tenMau);
	}

	@Override
	public void themMauSanPham(MauSanPham mauSanPham) {
		mauSanPhamRepository.save(mauSanPham);

	}

	@Override
	public void xoaMauSanPham(String idSanPham, int idMau) {
			MauSanPham mauSanPham = mauSanPhamRepository.findBySanPhamIdAndMauId(idSanPham, idMau);
			mauSanPhamRepository.delete(mauSanPham);
	}

	@Override
	public void capNhatMauSanPham(MauSanPham mauSanPham) {
		mauSanPhamRepository.save(mauSanPham);

	}

	@Override
	public MauSanPham getMauSanPhamTheoMaSanPhamVaMaMau(String maSanPham, int maMau) {
		return mauSanPhamRepository.findBySanPhamIdAndMauId(maSanPham, maMau);
	}

	@Override
	public List<MauSanPhamDTO> getMauSanPhamDTOTheoMaSanPham(String id) {
		List<MauSanPhamDTO> mauSanPhamDTOs = new ArrayList<MauSanPhamDTO>();
		mauSanPhamRepository.findBySanPhamId(id).forEach(mauSanPham -> {
			MauSanPhamDTO mauSanPhamDTO = mauSanPhamConverter.toMauSanPhamDTO(mauSanPham);
			mauSanPhamDTOs.add(mauSanPhamDTO);
		});
		return mauSanPhamDTOs;
	}

	@Override
	public List<MauSanPham> getDanhSachSoLuongIdMauTheoMaSanPham(String id) {
//		return mauSanPhamRepository.getDanhSachSoLuongMauBySanPhamId(id);
		return null;
	}

	@Override
	public List<MauSanPham> getDanhSachTheoMaMau(int id) {
		return mauSanPhamRepository.findByMauId(id);
	}

}
