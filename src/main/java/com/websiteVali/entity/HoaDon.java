package com.websiteVali.entity;

import java.sql.Date;
import java.util.ArrayList;
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
@Table(name = "HoaDons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hoaDon_generator")
	@GenericGenerator(name = "hoaDon_generator", strategy = "com.websiteVali.util.MyGenerator", parameters = {
			@Parameter(name = MyGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = MyGenerator.VALUE_PREFIX_PARAMETER, value = "HD"),
			@Parameter(name = MyGenerator.NUMBER_FORMAT_PARAMETER, value = "%06d") })
	@Column(name = "hoa_don_id")
	private String id;
	

	@Column(name = "ngay_lap_hd")
	private Date ngayLapHoaDon;

	@Column(name = "dia_chi_giao_hang", columnDefinition = "NVARCHAR(MAX)")
	private String diaChiGiaoHang;

	@Column(name = "trang_thai", columnDefinition = "NVARCHAR(MAX)")
	private String trangThai;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nguoi_dung_id")
	private NguoiDung nguoiDung;

	@OneToMany(mappedBy = "hoaDon")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<ChiTietHoaDon>();

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}


	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}


	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}


	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}


	public String getTrangThai() {
		return trangThai;
	}


	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}


	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}


	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}


	public List<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}


	public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}


	@Override
	public String toString() {
		return "HoaDon [id=" + id + ", ngayLapHoaDon=" + ngayLapHoaDon + ", diaChiGiaoHang=" + diaChiGiaoHang
				+ ", trangThai=" + trangThai + ", nguoiDung=" + nguoiDung + ", chiTietHoaDons=" + chiTietHoaDons + "]";
	}


	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HoaDon(String id, Date ngayLapHoaDon, String diaChiGiaoHang, String trangThai, NguoiDung nguoiDung,
			List<ChiTietHoaDon> chiTietHoaDons) {
		super();
		this.id = id;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.trangThai = trangThai;
		this.nguoiDung = nguoiDung;
		this.chiTietHoaDons = chiTietHoaDons;
	}


	public double tinhTongTien() {
		double tongTien = 0;
		for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDons) {
			tongTien += chiTietHoaDon.tinhTien();
		}
		
		return tongTien;
	}
}
