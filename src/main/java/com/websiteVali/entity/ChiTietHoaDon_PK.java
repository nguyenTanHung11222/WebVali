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
public class ChiTietHoaDon_PK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MauSanPham_PK mauSanPham;
	private String hoaDon;
	public MauSanPham_PK getMauSanPham() {
		return mauSanPham;
	}
	public void setMauSanPham(MauSanPham_PK mauSanPham) {
		this.mauSanPham = mauSanPham;
	}
	public String getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(String hoaDon) {
		this.hoaDon = hoaDon;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ChiTietHoaDon_PK(MauSanPham_PK mauSanPham, String hoaDon) {
		super();
		this.mauSanPham = mauSanPham;
		this.hoaDon = hoaDon;
	}
	public ChiTietHoaDon_PK() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon_PK [mauSanPham=" + mauSanPham + ", hoaDon=" + hoaDon + "]";
	}

}
