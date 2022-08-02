package com.websiteVali.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websiteVali.converter.NguoiDungConverter;
import com.websiteVali.dto.NguoiDungDTO;
import com.websiteVali.dto.ThuongHieuDTO;
import com.websiteVali.entity.DongSanPham;
import com.websiteVali.entity.LoaiSanPham;
import com.websiteVali.entity.NguoiDung;
import com.websiteVali.service.DongSanPhamService;
import com.websiteVali.service.LoaiSanPhamService;
import com.websiteVali.service.NguoiDungService;
import com.websiteVali.util.CustomUserDetails;

@Controller
@RequestMapping("/tai-khoan")
public class NguoiDungCotroller {

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private LoaiSanPhamService LoaiSanPhamService;

	@Autowired
	private DongSanPhamService dongSanPhamService;

	@Autowired
	private NguoiDungConverter nguoiDungConverter;

	@GetMapping("/thong-tin-tai-khoan")
	private String chiTietNguoiDung(Model model) {

		Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (pricipal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) pricipal).getUsername();
		} else {
			email = pricipal.toString();
		}

		NguoiDung nguoiDung = nguoiDungService.getNguoiDungTheoEmail(email);
		NguoiDungDTO user = nguoiDungConverter.toNguoiDungDTO(nguoiDung);

		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();

		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();
		model.addAttribute("map", map);
		model.addAttribute("dongSanPhams", dongSanPhams);

		model.addAttribute("user", user);

		return "/user/ThongTinTaiKhoan";
	}

	@PostMapping("/thong-tin-tai-khoan")
	private String capNhatThongTinNguoiDung(@ModelAttribute("user") NguoiDungDTO nguoiDungDTO) {

		NguoiDung nguoiDung = nguoiDungConverter.toUpdateUser(nguoiDungDTO);
		nguoiDungService.capNhatNguoiDung(nguoiDung);
		return "redirect:/tai-khoan/thong-tin-tai-khoan";
	}

}
