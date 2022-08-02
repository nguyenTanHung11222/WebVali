package com.websiteVali.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.websiteVali.util.MyGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "SanPhams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sanPham_generator")
	@GenericGenerator(name = "sanPham_generator", strategy = "com.websiteVali.util.MyGenerator", parameters = {
			@Parameter(name = MyGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = MyGenerator.VALUE_PREFIX_PARAMETER, value = "SP"),
			@Parameter(name = MyGenerator.NUMBER_FORMAT_PARAMETER, value = "%06d") })
	@Column(name = "san_pham_id")
	private String id;

	@Column(name = "ten_san_pham", columnDefinition = "NVARCHAR(MAX)")
	private String tenSanPham;

	@Column(name = "mo_ta", columnDefinition = "NTEXT")
	private String moTa;

	@Column(name = "gia_nhap")
	private double giaNhap;

	@Column(name = "gia_ban")
	private double giaBan;

	@Column(name = "xuat_xu", columnDefinition = "NVARCHAR(MAX)")
	private String xuatXu;

	@Column(name = "trang_thai")
	private boolean trangThai;

	@Column(name = "bao_hanh")
	private int baoHanh;

	@Column(name = "nam_san_xuat")
	private int namSanXuat;


	@OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<BinhLuan> binhLuans;

//	@OneToMany(mappedBy = "sanPham")
//	@ToString.Exclude
//	@EqualsAndHashCode.Exclude
//	private List<ChiTietHoaDon> chiTietHoaDons;



	@OneToMany(mappedBy = "sanPham")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<MauSanPham> mauSanPhams;

	@ManyToOne
	@JoinColumn(name = "dong_san_pham_id")
	private DongSanPham dongSanPham;

	public SanPham(String id, String tenSanPham, String moTa, double giaNhap, double giaBan, String xuatXu,
			boolean trangThai, int baoHanh, int namSanXuat, DongSanPham dongSanPham) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.xuatXu = xuatXu;
		this.trangThai = trangThai;
		this.baoHanh = baoHanh;
		this.namSanXuat = namSanXuat;
		this.dongSanPham = dongSanPham;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public int getBaoHanh() {
		return baoHanh;
	}

	public void setBaoHanh(int baoHanh) {
		this.baoHanh = baoHanh;
	}

	public int getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(int namSanXuat) {
		this.namSanXuat = namSanXuat;
	}


	public List<BinhLuan> getBinhLuans() {
		return binhLuans;
	}

	public void setBinhLuans(List<BinhLuan> binhLuans) {
		this.binhLuans = binhLuans;
	}

	public List<MauSanPham> getMauSanPhams() {
		return mauSanPhams;
	}

	public void setMauSanPhams(List<MauSanPham> mauSanPhams) {
		this.mauSanPhams = mauSanPhams;
	}

	public DongSanPham getDongSanPham() {
		return dongSanPham;
	}

	public void setDongSanPham(DongSanPham dongSanPham) {
		this.dongSanPham = dongSanPham;
	}

	public SanPham(String id, String tenSanPham, String moTa, double giaNhap, double giaBan, String xuatXu,
			boolean trangThai, int baoHanh, int namSanXuat, List<BinhLuan> binhLuans,
			List<MauSanPham> mauSanPhams, DongSanPham dongSanPham) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.xuatXu = xuatXu;
		this.trangThai = trangThai;
		this.baoHanh = baoHanh;
		this.namSanXuat = namSanXuat;
		this.binhLuans = binhLuans;
		this.mauSanPhams = mauSanPhams;
		this.dongSanPham = dongSanPham;
	}

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SanPham [id=" + id + ", tenSanPham=" + tenSanPham + ", moTa=" + moTa + ", giaNhap=" + giaNhap
				+ ", giaBan=" + giaBan + ", xuatXu=" + xuatXu + ", trangThai=" + trangThai + ", baoHanh=" + baoHanh
				+ ", namSanXuat=" + namSanXuat + ", binhLuans=" + binhLuans
				+ ", mauSanPhams=" + mauSanPhams + ", dongSanPham=" + dongSanPham + "]";
	}
	
	

}

