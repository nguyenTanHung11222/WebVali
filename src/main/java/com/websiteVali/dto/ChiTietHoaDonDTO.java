package com.websiteVali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietHoaDonDTO {

	private String maHoaDon;

	private MauSanPhamDTO mauSanPhamDTO;

	private int soLuong;

	private double giaBan;

	public ChiTietHoaDonDTO(String maHoaDon, MauSanPhamDTO mauSanPhamDTO, int soLuong) {
		super();
		this.maHoaDon = maHoaDon;
		this.mauSanPhamDTO = mauSanPhamDTO;
		this.soLuong = soLuong;
	}

	public ChiTietHoaDonDTO(String maHoaDon, MauSanPhamDTO mauSanPhamDTO, int soLuong, double giaBan) {
		super();
		this.maHoaDon = maHoaDon;
		this.mauSanPhamDTO = mauSanPhamDTO;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
	}

	
	@Override
	public String toString() {
		return "ChiTietHoaDonDTO [maHoaDon=" + maHoaDon + ", mauSanPhamDTO=" + mauSanPhamDTO + ", soLuong=" + soLuong
				+ ", giaBan=" + giaBan + "]";
	}

	public double tinhTien() {
		return soLuong * giaBan;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public MauSanPhamDTO getMauSanPhamDTO() {
		return mauSanPhamDTO;
	}

	public void setMauSanPhamDTO(MauSanPhamDTO mauSanPhamDTO) {
		this.mauSanPhamDTO = mauSanPhamDTO;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

}
