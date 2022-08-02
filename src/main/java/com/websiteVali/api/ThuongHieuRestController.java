package com.websiteVali.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websiteVali.converter.ThuongHieuConverter;
import com.websiteVali.dto.ThuongHieuDTO;
import com.websiteVali.entity.DongSanPham;
import com.websiteVali.entity.ThuongHieu;
import com.websiteVali.service.DongSanPhamService;
import com.websiteVali.service.ThuongHieuService;

@RestController
@RequestMapping("/api/thuong-hieu")
public class ThuongHieuRestController {

	@Autowired
	private ThuongHieuService thuongHieuService;

	@Autowired
	private ThuongHieuConverter thuongHieuConverter;

	@Autowired
	private DongSanPhamService dongSanPhamService;

	@GetMapping("/danh-sach")
	public List<ThuongHieuDTO> getDanhSachThuongHieuBangTenThuongHieu(
			@RequestParam("tenThuongHieu") String tenThuongHieu) {
		List<ThuongHieu> thuongHieus = thuongHieuService.getDanhSachThuongHieuBangTenThuongHieu(tenThuongHieu, 0, 10);
		List<ThuongHieuDTO> thuongHieuDTOs = new ArrayList<ThuongHieuDTO>();
		for (ThuongHieu th : thuongHieus) {
			ThuongHieuDTO thuongHieuDTO = thuongHieuConverter.toThuongHieuDTO(th);
			thuongHieuDTO.setDongSanPhams(null);
			thuongHieuDTOs.add(thuongHieuDTO);
		}
		return thuongHieuDTOs;
	}

	@DeleteMapping("/xoa")
	public int deleteThuongHieu(@RequestParam("id") String id) {
		List<DongSanPham> dongSanPhams = dongSanPhamService.getDongSanPhamBangIdThuongHieu(id);
		if (dongSanPhams.size() > 0)
			return -1;
		
		thuongHieuService.XoaThuonghieu(id);
		return 1;
	}
}
