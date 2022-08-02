package com.websiteVali.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class BinhLuan_PK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nguoiDung;
	private String sanPham;
	public String getNguoiDung() {
		return nguoiDung;
	}
	public void setNguoiDung(String nguoiDung) {
		this.nguoiDung = nguoiDung;
	}
	public String getSanPham() {
		return sanPham;
	}
	public void setSanPham(String sanPham) {
		this.sanPham = sanPham;
	}
	

}
