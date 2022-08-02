package com.websiteVali.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websiteVali.converter.ThuongHieuConverter;
import com.websiteVali.dto.NguoiDungDTO;
import com.websiteVali.dto.QuangCaoDTO;
import com.websiteVali.dto.SanPhamDTO;
import com.websiteVali.dto.ThuongHieuDTO;
import com.websiteVali.entity.DongSanPham;
import com.websiteVali.entity.LoaiSanPham;
import com.websiteVali.entity.ThuongHieu;
import com.websiteVali.service.DongSanPhamService;
import com.websiteVali.service.LoaiSanPhamService;
import com.websiteVali.service.NguoiDungService;
import com.websiteVali.service.QuangCaoService;
import com.websiteVali.service.SanPhamService;
import com.websiteVali.service.ThuongHieuService;
import com.websiteVali.util.CustomUserDetails;

@Controller
public class TrangChuController {
	@Autowired
	private NguoiDungService userService;

	@Autowired
	private LoaiSanPhamService LoaiSanPhamService;

	@Autowired
	private ThuongHieuService thuongHieuService;

	@Autowired
	private DongSanPhamService dongSanPhamService;

	@Autowired
	private QuangCaoService quangCaoService;
	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private ThuongHieuConverter thuongHieuConverter;

	@RequestMapping("/trang-chu")
	public String hienThiTrangChu(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}

		NguoiDungDTO user = userService.getByEmail(email);
		List<LoaiSanPham> loaiSanPhams = LoaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		List<ThuongHieuDTO> thuongHieuDTOs = new ArrayList<ThuongHieuDTO>();
		thuongHieus.forEach(th -> {
			ThuongHieuDTO thuongHieuDTO = thuongHieuConverter.toThuongHieuDTO(th);
			thuongHieuDTOs.add(thuongHieuDTO);
		});

		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();

		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();

		List<QuangCaoDTO> quangCaoDTOs = quangCaoService.get6QuangCao();
		List<SanPhamDTO> sanPhamBanChays = sanPhamService.danhSachSanPhamBanChay(0, 15);

		Map<String, List<SanPhamDTO>> sanPhamLoaiSanPham = new HashMap<String, List<SanPhamDTO>>();

		if (loaiSanPhams.size() > 0) // vua them vao de tranh viec loi out of index
			for (int i = 0; i < 3; i++) {
//				String maLoai = loaiSanPhams.get(i).getId();
//				List<SanPhamDTO> sanPhamDTOs = sanPhamService.getDanhSachSanPhamTheoLoaiThuongHieuDong(maLoai, 0, 10);
//				sanPhamLoaiSanPham.put(loaiSanPhams.get(i).getTenLoaiSanPham(), sanPhamDTOs);
			}

		model.addAttribute("map", map);
		model.addAttribute("pageTitle", "Trang chủ");
		model.addAttribute("user", user);
		model.addAttribute("loaiSanPhams", loaiSanPhams);
		model.addAttribute("thuongHieus", thuongHieuDTOs);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("quangCaoDTOs", quangCaoDTOs);
		model.addAttribute("sanPhamBanChays", sanPhamBanChays);
		model.addAttribute("sanPhamLoaiSanPham", sanPhamLoaiSanPham);

		return "user/home";
	}


}
