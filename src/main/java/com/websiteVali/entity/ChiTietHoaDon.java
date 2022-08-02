package com.websiteVali.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "ChiTietHoaDons")
@IdClass(ChiTietHoaDon_PK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChiTietHoaDon {

	@Id
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "san_pham_id", referencedColumnName = "san_pham_id"),
			@JoinColumn(name = "mau_id", referencedColumnName = "mau_id") })
	private MauSanPham mauSanPham;

	@Id
	@ManyToOne
	@JoinColumn(name = "hoa_don_id")
	private HoaDon hoaDon;

	@Column(name = "so_luong")
	private int soLuong;

	public MauSanPham getMauSanPham() {
		return mauSanPham;
	}

	public void setMauSanPham(MauSanPham mauSanPham) {
		this.mauSanPham = mauSanPham;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public ChiTietHoaDon(MauSanPham mauSanPham, HoaDon hoaDon, int soLuong) {
		super();
		this.mauSanPham = mauSanPham;
		this.hoaDon = hoaDon;
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [mauSanPham=" + mauSanPham + ", hoaDon=" + hoaDon + ", soLuong=" + soLuong + "]";
	}

	public double tinhTien() {
		return getSoLuong() * mauSanPham.getSanPham().getGiaBan();
	}
}
