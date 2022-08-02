package com.websiteVali.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BinhLuanDTO {

	private String maNguoiDung;

	private String maSanPham;

	private Date ngayBinhLuan;

	private String noiDung;

	private int danhGia;

	public BinhLuanDTO(String maNguoiDung, String maSanPham, String noiDung, int danhGia) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.maSanPham = maSanPham;
		this.noiDung = noiDung;
		this.danhGia = danhGia;
	}
	

	public BinhLuanDTO(String maNguoiDung, String maSanPham, Date ngayBinhLuan, String noiDung, int danhGia) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.maSanPham = maSanPham;
		this.ngayBinhLuan = ngayBinhLuan;
		this.noiDung = noiDung;
		this.danhGia = danhGia;
	}


	public String getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public Date getNgayBinhLuan() {
		return ngayBinhLuan;
	}

	public void setNgayBinhLuan(Date ngayBinhLuan) {
		this.ngayBinhLuan = ngayBinhLuan;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public int getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(int danhGia) {
		this.danhGia = danhGia;
	}
	
}
