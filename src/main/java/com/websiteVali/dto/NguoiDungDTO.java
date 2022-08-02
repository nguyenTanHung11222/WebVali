package com.websiteVali.dto;

import com.websiteVali.entity.ROLE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDungDTO {

	private String userId;

	private String fullName;
	
	private String email;
	
	private String phone;
	
	private String password;
	
	private String passwordConf;
	
	private ROLE role;
	
	private boolean enabled;
	
	private String tinhThanhPho;

	private String quanHuyen;

	private String phuongXa;

	private String diaChi;
	

	public NguoiDungDTO(String userId) {
		super();
		this.userId = userId;

	}

	public NguoiDungDTO(String userId, String fullName, String phone, String email, ROLE role,
			boolean enabled) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.enabled = enabled;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConf() {
		return passwordConf;
	}

	public void setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
	}

	public ROLE getRole() {
		return role;
	}

	public void setRole(ROLE role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public NguoiDungDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NguoiDungDTO [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", passwordConf=" + passwordConf + ", role=" + role + ", enabled="
				+ enabled + ", tinhThanhPho=" + tinhThanhPho + ", quanHuyen=" + quanHuyen + ", phuongXa=" + phuongXa
				+ ", diaChi=" + diaChi + "]";
	}

}
