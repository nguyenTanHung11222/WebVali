package com.websiteVali.controller.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websiteVali.converter.ChiTietHoaDonConverter;
import com.websiteVali.converter.HoaDonConverter;
import com.websiteVali.dto.ChiTietHoaDonDTO;
import com.websiteVali.dto.HoaDonDTO;
import com.websiteVali.entity.ChiTietHoaDon;
import com.websiteVali.entity.HoaDon;
import com.websiteVali.service.ChiTietHoaDonService;
import com.websiteVali.service.HoaDonService;
import com.websiteVali.service.NguoiDungService;
import com.websiteVali.util.Constant;

@Controller
@RequestMapping("/admin")
public class QuanLyController {
	@Autowired
	private HoaDonService hoaDonService;

	@Autowired
	NguoiDungService userService;

	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;

	@Autowired
	private HoaDonConverter hoaDonConverter;

	@Autowired
	private ChiTietHoaDonConverter chiTietHoaDonConverter;


	@RequestMapping("/quan-ly")
	public String getUser(Model model) {

		List<HoaDon> hoaDons = hoaDonService.getDanhSachTheoTrangThai("", 0, 5);

		List<HoaDonDTO> hoaDonDTOs = new ArrayList<HoaDonDTO>();
		hoaDons.forEach(hd -> {
			HoaDonDTO hoaDonDTO = hoaDonConverter.toHoaDonDTO(hd);
			List<ChiTietHoaDonDTO> chiTietHoaDonDTOs = new ArrayList<ChiTietHoaDonDTO>();
			List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonService.getChiTietHoaDonTheoMaHoaDon(hoaDonDTO.getId());

			chiTietHoaDons.forEach(cthd -> {
				ChiTietHoaDonDTO chiTietHoaDonDTO = chiTietHoaDonConverter.toChiTietHoaDonDTO(cthd);
				chiTietHoaDonDTOs.add(chiTietHoaDonDTO);
			});
			hoaDonDTO.setChiTietHoaDonDTOs(chiTietHoaDonDTOs);

			hoaDonDTOs.add(hoaDonDTO);
		});

		List<String> trangThais = new ArrayList<String>(Arrays.asList(Constant.DANG_CHO_XU_LY, Constant.DA_TIEP_NHAN,
				Constant.DANG_DONG_GOI, Constant.BAN_GIAO_VAN_CHUYEN, Constant.GIAO_THANH_CONG, Constant.DA_HUY));
		model.addAttribute("trangThais", trangThais);
		model.addAttribute("hoaDonDTOs", hoaDonDTOs);
		model.addAttribute("page", 0);

		return "admin/quanlydonhang/danhsachdonhang";

	}
}
