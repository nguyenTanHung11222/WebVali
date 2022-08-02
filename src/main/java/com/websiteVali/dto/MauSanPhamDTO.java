package com.websiteVali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MauSanPhamDTO {
	private int maMau;
	
	private String tenMau;

	private String maSanPham;
	
	private String tenSanPham;

	private int soLuong;

	private String hinhAnhBase64;

	public MauSanPhamDTO(String maSanPham) {
		super();
		this.maSanPham = maSanPham;
	}

	public int getMaMau() {
		return maMau;
	}

	public void setMaMau(int maMau) {
		this.maMau = maMau;
	}

	public String getTenMau() {
		return tenMau;
	}

	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getHinhAnhBase64() {
		return hinhAnhBase64;
	}

	public void setHinhAnhBase64(String hinhAnhBase64) {
		this.hinhAnhBase64 = hinhAnhBase64;
	}

	public MauSanPhamDTO(int maMau, String tenMau, String maSanPham, String tenSanPham, int soLuong,
			String hinhAnhBase64) {
		super();
		this.maMau = maMau;
		this.tenMau = tenMau;
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.hinhAnhBase64 = hinhAnhBase64;
	}

	public MauSanPhamDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MauSanPhamDTO [maMau=" + maMau + ", tenMau=" + tenMau + ", maSanPham=" + maSanPham + ", tenSanPham="
				+ tenSanPham + ", soLuong=" + soLuong + ", hinhAnhBase64=" + hinhAnhBase64 + "]";
	}
	
}
