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
public class MauSanPham_PK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int mau;
	private String sanPham;
	public int getMau() {
		return mau;
	}
	public void setMau(int mau) {
		this.mau = mau;
	}
	public String getSanPham() {
		return sanPham;
	}
	public void setSanPham(String sanPham) {
		this.sanPham = sanPham;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public MauSanPham_PK(int mau, String sanPham) {
		super();
		this.mau = mau;
		this.sanPham = sanPham;
	}
	public MauSanPham_PK() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MauSanPham_PK [mau=" + mau + ", sanPham=" + sanPham + "]";
	}

}
