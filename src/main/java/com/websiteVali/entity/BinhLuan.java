package com.websiteVali.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BinhLuans")
@IdClass(BinhLuan_PK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinhLuan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nguoi_dung_id")
	private NguoiDung nguoiDung;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "san_pham_id")
	private SanPham sanPham;

	@Column(name = "binh_luan", columnDefinition = "NVARCHAR(MAX)")
	private String binhLuan;

	@Column(name = "ngay_binh_luan")
	private Date ngayBinhLuan;
	
	@Column(name = "danh_gia")
	private int danhGia;

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public String getBinhLuan() {
		return binhLuan;
	}

	public void setBinhLuan(String binhLuan) {
		this.binhLuan = binhLuan;
	}

	public Date getNgayBinhLuan() {
		return ngayBinhLuan;
	}

	public void setNgayBinhLuan(Date ngayBinhLuan) {
		this.ngayBinhLuan = ngayBinhLuan;
	}

	public int getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(int danhGia) {
		this.danhGia = danhGia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BinhLuan(NguoiDung nguoiDung, SanPham sanPham, String binhLuan, Date ngayBinhLuan, int danhGia) {
		super();
		this.nguoiDung = nguoiDung;
		this.sanPham = sanPham;
		this.binhLuan = binhLuan;
		this.ngayBinhLuan = ngayBinhLuan;
		this.danhGia = danhGia;
	}

	public BinhLuan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BinhLuan [nguoiDung=" + nguoiDung + ", sanPham=" + sanPham + ", binhLuan=" + binhLuan
				+ ", ngayBinhLuan=" + ngayBinhLuan + ", danhGia=" + danhGia + "]";
	}

}
