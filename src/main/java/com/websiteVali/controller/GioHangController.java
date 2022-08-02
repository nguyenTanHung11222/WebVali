package com.websiteVali.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.websiteVali.dto.ChiTietHoaDonDTO;
import com.websiteVali.dto.HoaDonDTO;
import com.websiteVali.dto.NguoiDungDTO;
import com.websiteVali.dto.SanPhamDTO;
import com.websiteVali.dto.ThuongHieuDTO;
import com.websiteVali.entity.DongSanPham;
import com.websiteVali.entity.LoaiSanPham;
import com.websiteVali.entity.NguoiDung;
import com.websiteVali.service.DongSanPhamService;
import com.websiteVali.service.LoaiSanPhamService;
import com.websiteVali.service.NguoiDungService;
import com.websiteVali.service.SanPhamService;
import com.websiteVali.util.CustomUserDetails;

@Controller
public class GioHangController {

	@Autowired
	NguoiDungService UserService;
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	private LoaiSanPhamService LoaiSanPhamService;

	@Autowired
	private DongSanPhamService dongSanPhamService;

	@GetMapping("/gio-hang")
	public String hienThiGioHang(Model model, HttpSession httpSession) {

		Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (pricipal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) pricipal).getUsername();
		} else {
			email = pricipal.toString();
		}

		NguoiDungDTO user = UserService.getByEmail(email);
		NguoiDung nguoiDung = UserService.getNguoiDungTheoEmail(email);

		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			if (nguoiDung != null) {

				hoaDonDTO.setDiaChiGiaoHang(nguoiDung.getDiaChi());
			}
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}

		Map<ChiTietHoaDonDTO, SanPhamDTO> mapCTHD = new HashMap<ChiTietHoaDonDTO, SanPhamDTO>();
		hoaDonDTO.getChiTietHoaDonDTOs().forEach(cthd -> {
			String maSP = cthd.getMauSanPhamDTO().getMaSanPham();
			SanPhamDTO sanPhamDTO = sanPhamService.getSanPhamDTOTheoID(maSP);

			mapCTHD.put(cthd, sanPhamDTO);
		});

		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();

		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();
		
		model.addAttribute("map", map);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("mapCTHD", mapCTHD);
		model.addAttribute("pageTitle", "Giỏ hàng");
		model.addAttribute("user", user);

		return "user/GioHang";
	}

}
