package com.websiteVali.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.websiteVali.converter.SanPhamConverter;
import com.websiteVali.dto.SanPhamDTO;
import com.websiteVali.entity.MauSanPham;
import com.websiteVali.entity.SanPham;
import com.websiteVali.repository.ChiTietHoaDonRepository;
import com.websiteVali.repository.MauSanPhamRepository;
import com.websiteVali.repository.SanPhamRepository;
import com.websiteVali.service.SanPhamService;
import com.websiteVali.util.SanPhamSpecification;

@Service
public class SanPhamServiceImpl implements SanPhamService {

	@Autowired
	SanPhamRepository sanPhamRepository;

	@Autowired
	MauSanPhamRepository mauSanPhamRepository;

	@Autowired
	ChiTietHoaDonRepository chiTietHoaDonRepository;
	
	@Autowired
	SanPhamConverter sanPhamConverter;
	

	@Override
	public void themSanPham(SanPham sanPham, MauSanPham mauSanPham) {

		SanPham affterSave = sanPhamRepository.save(sanPham);
		sanPhamRepository.flush();

		String id = affterSave.getId();


		if (mauSanPham.getSanPham() == null) {
			SanPham temp = sanPhamRepository.getOne(id);
			mauSanPham.setSanPham(temp);
		}
		mauSanPhamRepository.save(mauSanPham);

	}

	
	@Override
	public void capNhatSanPham(SanPham sanPham) {
		sanPhamRepository.save(sanPham);
	}

	@Override
	public List<SanPham> timKiemSanPham(String tenSanPham, String maLoaiSanPham, String xuatXu, String maThuongHieu,
			int page, int size) {
		Pageable firstPageWithTwoElements = PageRequest.of(page, size);
		List<SanPham> sanPhams = sanPhamRepository
				.findByTenSanPhamContainingAndXuatXuContainingAndDongSanPhamThuongHieuIdContainingAndDongSanPhamLoaiSanPhamIdContaining(
						tenSanPham, xuatXu, maThuongHieu, maLoaiSanPham, firstPageWithTwoElements);

		return sanPhams;
	}

	@Override
	public List<SanPham> getTatCaSanPham() {

		return sanPhamRepository.findAll();
	}

	@Override
	public SanPham getSanPhamTheoID(String id) {
		return sanPhamRepository.findById(id).get();
	}

	@Override
	public SanPhamDTO getSanPhamDTOTheoID(String id) {

		SanPhamDTO sanPhamDTO = sanPhamRepository.findById(id).map(sanPham -> sanPhamConverter.toSanPhamDTO(sanPham))
				.orElse(null);
		return sanPhamDTO;
	}

	@Override
	public List<SanPhamDTO> getDanhSachSanPhamTheoLoaiThuongHieuDong(String id, int page, int size) {
		List<SanPhamDTO> sanPhamDTOs = new ArrayList<SanPhamDTO>();
		List<SanPham> sanPhams = sanPhamRepository
				.findByDongSanPhamLoaiSanPhamIdOrDongSanPhamIdOrDongSanPhamThuongHieuId(id, id, id,
						PageRequest.of(page, size));

		sanPhams.forEach(sp -> {
			SanPhamDTO sanPhamDTO = sanPhamConverter.toSanPhamDTO(sp);
			sanPhamDTOs.add(sanPhamDTO);
		});

		return sanPhamDTOs;
	}

	@Override
	public List<SanPhamDTO> getTatCaSanPham(int page, int size) {
		List<SanPhamDTO> sanPhamDTOs = new ArrayList<SanPhamDTO>();
		List<SanPham> sanPhams = sanPhamRepository.findAll(PageRequest.of(page, size)).getContent();
		sanPhams.forEach(sp -> {
			SanPhamDTO sanPhamDTO = sanPhamConverter.toSanPhamDTO(sp);
			sanPhamDTOs.add(sanPhamDTO);
		});
		return sanPhamDTOs;
	}

	@Override
	public Set<String> getDanhSachXuatXu() {
		return sanPhamRepository.getDanhSachXuatXu();
	}

	@Override
	public List<SanPhamDTO> getDanhSachSanPhamTheoLoaiThuongHieu(String maLoaiSanPham, String maThuongHieu, int page,
			int size) {
		List<SanPhamDTO> sanPhamDTOs = new ArrayList<SanPhamDTO>();
		List<SanPham> sanPhams = sanPhamRepository.findByDongSanPhamLoaiSanPhamIdAndDongSanPhamThuongHieuId(
				maLoaiSanPham, maThuongHieu, PageRequest.of(page, size));

		sanPhams.forEach(sp -> {
			SanPhamDTO sanPhamDTO = sanPhamConverter.toSanPhamDTO(sp);
			sanPhamDTOs.add(sanPhamDTO);
		});

		return sanPhamDTOs;
	}
	
	@Override
	public boolean xoaSanPham(String id) {

//		if (chiTietHoaDonRepository.findByMauSanPhamSanPhamId(id).size() > 0)
//			return false;
		if(chiTietHoaDonRepository.findFirstByMauSanPhamSanPhamId(id) != null)
			return false;
//		mauSanPhamRepository.customXoaMauSanPhamBySanPhamId(id);
		List<MauSanPham> listMauSP = mauSanPhamRepository.findBySanPhamId(id);
		listMauSP.forEach(t->{
			mauSanPhamRepository.delete(t);
		});

		sanPhamRepository.deleteById(id);
		return true;
	}


	@Override
	public List<SanPhamDTO> danhSachSanPhamBanChay(int page, int size) {
		List<String> sanPhamId = sanPhamRepository.getDanhSachSanPhamBanChay(PageRequest.of(page, size));
		
		List<SanPhamDTO> sanPhamDTOs = new ArrayList<SanPhamDTO>();
		
		sanPhamId.forEach(id ->{
			SanPham sanPham = sanPhamRepository.findById(id).get();
			SanPhamDTO sanPhamDTO = sanPhamConverter.toSanPhamDTO(sanPham);
			sanPhamDTOs.add(sanPhamDTO);
		});
		return sanPhamDTOs;
	}

	@Override
	public List<SanPhamDTO> timKiemSanPhamTheoNhieuDieuKien(String tenSanPham, List<String> xuatXus, double giaDau,
			double giaCuoi, List<String> listDongSanPhamId, List<String> listThuongHieuId,
			List<String> listLoaiSanPhamId, int page, int size, int sort) {

		Specification<SanPham> dieuKien = Specification
				.where(SanPhamSpecification.timKiemSanPhamTheoTenSanPham(tenSanPham))
				.and(SanPhamSpecification.timKiemSanPhamTheoTenSanPham(tenSanPham))
				.and(SanPhamSpecification.timKiemSanPhamTheoXuatXu(xuatXus))
				.and(SanPhamSpecification.timKiemSanPhamTheoKhoangGia(giaDau, giaCuoi))
				.and(SanPhamSpecification.timKiemSanPhamTheoDongSanPham(listDongSanPhamId))
				.and(SanPhamSpecification.timKiemSanPhamTheoThuongHieu(listThuongHieuId))
				.and(SanPhamSpecification.timKiemSanPhamTheoLoaiSanPham(listLoaiSanPhamId));
		
		List<SanPham> sanPhams = null;
		
		switch (sort) {
		case 1:
			sanPhams = sanPhamRepository.findAll(dieuKien, PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "giaBan"))).getContent();
			break;
		case 2:
			sanPhams = sanPhamRepository.findAll(dieuKien, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "giaBan"))).getContent();
			break;

		default:
			sanPhams = sanPhamRepository.findAll(dieuKien, PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "giaBan"))).getContent();
			break;
		}
		
		return sanPhams.stream().map(sp -> sanPhamConverter.toSanPhamDTO(sp)).collect(Collectors.toList());
		
//		List<SanPhamDTO> sanPhamDTOs = new ArrayList<SanPhamDTO>();
//		
//		sanPhams.forEach(sp -> {
//			SanPhamDTO sanPhamDTO = sanPhamConverter.toSanPhamDTO(sp);
//			sanPhamDTOs.add(sanPhamDTO);
//		});
		
	}



}
