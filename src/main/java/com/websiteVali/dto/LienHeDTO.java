package com.websiteVali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class LienHeDTO {
	
	private String id;
	
	private String email;
	
	private String soDienThoai;
	
	private String tinhThanhPho;

	private String quanHuyen;

	private String phuongXa;

	private String diaChi;

	public LienHeDTO(String email, String soDienThoai, String tinhThanhPho, String quanHuyen, String phuongXa,
			String diaChi) {
		super();
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.tinhThanhPho = tinhThanhPho;
		this.quanHuyen = quanHuyen;
		this.phuongXa = phuongXa;
		this.diaChi = diaChi;
	}

	public LienHeDTO(String id, String email, String soDienThoai, String tinhThanhPho, String quanHuyen,
			String phuongXa, String diaChi) {
		super();
		this.id = id;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.tinhThanhPho = tinhThanhPho;
		this.quanHuyen = quanHuyen;
		this.phuongXa = phuongXa;
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "LienHeDTO [id=" + id + ", email=" + email + ", soDienThoai=" + soDienThoai + ", tinhThanhPho="
				+ tinhThanhPho + ", quanHuyen=" + quanHuyen + ", phuongXa=" + phuongXa + ", diaChi=" + diaChi + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTinhThanhPho() {
		return tinhThanhPho;
	}

	public void setTinhThanhPho(String tinhThanhPho) {
		this.tinhThanhPho = tinhThanhPho;
	}

	public String getQuanHuyen() {
		return quanHuyen;
	}

	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

	public String getPhuongXa() {
		return phuongXa;
	}

	public void setPhuongXa(String phuongXa) {
		this.phuongXa = phuongXa;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	
}
