package com.websiteVali.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HoaDonDTO {

	private String id;

	private Date ngayLapHD;

	private String diaChiGiaoHang;

	private String trangThai;

	private NguoiDungDTO nguoiDung;

	private List<ChiTietHoaDonDTO> chiTietHoaDonDTOs;
	
	private double tongTien;

	public HoaDonDTO() {
		super();
		this.chiTietHoaDonDTOs = new ArrayList<ChiTietHoaDonDTO>();
	}
	
	public HoaDonDTO(String id, Date ngayLapHD, String diaChiGiaoHang, String trangThai, NguoiDungDTO nguoiDung,
			List<ChiTietHoaDonDTO> chiTietHoaDonDTOs, double tongTien) {
		super();
		this.id = id;
		this.ngayLapHD = ngayLapHD;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.trangThai = trangThai;
		this.nguoiDung = nguoiDung;
		this.chiTietHoaDonDTOs = chiTietHoaDonDTOs;
		this.tongTien = tongTien;
	}

	public HoaDonDTO(String id, Date ngayLapHD, String diaChiGiaoHang, String trangThai, NguoiDungDTO nguoiDung,
			List<ChiTietHoaDonDTO> chiTietHoaDonDTOs) {
		super();
		this.id = id;
		this.ngayLapHD = ngayLapHD;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.trangThai = trangThai;
		this.nguoiDung = nguoiDung;
	}

	public boolean themChiTietHoaDonDTO(MauSanPhamDTO mauSanPhamDTO) {
		if(mauSanPhamDTO.getSoLuong() == 0)
			return false;
		
		for (ChiTietHoaDonDTO chiTietHoaDon : chiTietHoaDonDTOs) {
			// náº¿u Ä‘Ã£ cÃ³ trong giá»� hÃ ng
			if (chiTietHoaDon.getMauSanPhamDTO().equals(mauSanPhamDTO)) {

				if (chiTietHoaDon.getSoLuong() >= mauSanPhamDTO.getSoLuong())
					return false;

				chiTietHoaDon.setSoLuong(chiTietHoaDon.getSoLuong() + 1);
				return true;
			}

		}
		// chÆ°a cÃ³ trong giá»� hÃ ng
		ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO(this.id, mauSanPhamDTO, 1);
		chiTietHoaDonDTOs.add(chiTietHoaDonDTO);
		return true;
	}
	
	public boolean xoaChiTietHoaDon(MauSanPhamDTO mauSanPhamDTO) {
		int index = -1;
		for (ChiTietHoaDonDTO chiTietHoaDonDTO : chiTietHoaDonDTOs) {
			if (chiTietHoaDonDTO.getMauSanPhamDTO().equals(mauSanPhamDTO)) {
				index = chiTietHoaDonDTOs.indexOf(chiTietHoaDonDTO);
				break;
			}
		}
		if(index != -1) {
			chiTietHoaDonDTOs.remove(index);
			return true;
		}else {
			return false;
		}
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}

	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}

	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public NguoiDungDTO getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDungDTO nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public List<ChiTietHoaDonDTO> getChiTietHoaDonDTOs() {
		return chiTietHoaDonDTOs;
	}

	public void setChiTietHoaDonDTOs(List<ChiTietHoaDonDTO> chiTietHoaDonDTOs) {
		this.chiTietHoaDonDTOs = chiTietHoaDonDTOs;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public String toString() {
		return "HoaDonDTO [id=" + id + ", ngayLapHD=" + ngayLapHD + ", diaChiGiaoHang=" + diaChiGiaoHang
				+ ", trangThai=" + trangThai + ", nguoiDung=" + nguoiDung + ", chiTietHoaDonDTOs=" + chiTietHoaDonDTOs
				+ ", tongTien=" + tongTien + "]";
	}



	



	
}
