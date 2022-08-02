package com.websiteVali.dto;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class SanPhamDTO {

	private String id;

	private String tenSanPham;

	private String moTa;

	@Setter(AccessLevel.NONE)
	private double giaNhap;

	@Setter(AccessLevel.NONE)
	private double giaBan;

	private String xuatXu;

	private boolean trangThai;

	@Setter(AccessLevel.NONE)
	private int baoHanh;

	@Setter(AccessLevel.NONE)
	private int namSanXuat;


	private String maDongSanPham;
	
	private String tenDongSanPham;
	
	private String maLoaiSanPham;
	
	private String tenLoaiSanPham;
	
	private String maThuongHieu;
	
	private String tenThuongHieu;
	
	private String hinhAnhBase64;
	
	private List<MauSanPhamDTO> listMauSanPhamDTOs;
	
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



	public String getMaDongSanPham() {
		return maDongSanPham;
	}

	public void setMaDongSanPham(String maDongSanPham) {
		this.maDongSanPham = maDongSanPham;
	}

	public String getTenDongSanPham() {
		return tenDongSanPham;
	}

	public void setTenDongSanPham(String tenDongSanPham) {
		this.tenDongSanPham = tenDongSanPham;
	}

	public String getMaLoaiSanPham() {
		return maLoaiSanPham;
	}

	public void setMaLoaiSanPham(String maLoaiSanPham) {
		this.maLoaiSanPham = maLoaiSanPham;
	}

	public String getTenLoaiSanPham() {
		return tenLoaiSanPham;
	}

	public void setTenLoaiSanPham(String tenLoaiSanPham) {
		this.tenLoaiSanPham = tenLoaiSanPham;
	}

	public String getMaThuongHieu() {
		return maThuongHieu;
	}

	public void setMaThuongHieu(String maThuongHieu) {
		this.maThuongHieu = maThuongHieu;
	}

	public String getTenThuongHieu() {
		return tenThuongHieu;
	}

	public void setTenThuongHieu(String tenThuongHieu) {
		this.tenThuongHieu = tenThuongHieu;
	}

	public String getHinhAnhBase64() {
		return hinhAnhBase64;
	}

	public void setHinhAnhBase64(String hinhAnhBase64) {
		this.hinhAnhBase64 = hinhAnhBase64;
	}

	public List<MauSanPhamDTO> getListMauSanPhamDTOs() {
		return listMauSanPhamDTOs;
	}

	public void setListMauSanPhamDTOs(List<MauSanPhamDTO> listMauSanPhamDTOs) {
		this.listMauSanPhamDTOs = listMauSanPhamDTOs;
	}

	public int getTongSoLuong() {
		return tongSoLuong;
	}

	public void setTongSoLuong(int tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}

	private int tongSoLuong;
	
	
	
	public SanPhamDTO(String id, String tenSanPham, String moTa) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
	}

	public SanPhamDTO(String id, String tenSanPham, String xuatXu, String loaiSanPham, String thuongHieu) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.xuatXu = xuatXu;
		this.maLoaiSanPham = loaiSanPham;
		this.maThuongHieu = thuongHieu;
	}

	
	public SanPhamDTO(String id, String tenSanPham, String moTa, double giaNhap, double giaBan, String xuatXu,
			boolean trangThai, int baoHanh, int namSanXuat,
			String maDongSanPham, String tenDongSanPham, String maLoaiSanPham, String tenLoaiSanPham,
			String maThuongHieu, String tenThuongHieu, String hinhAnhBase64) {
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
		this.maDongSanPham = maDongSanPham;
		this.tenDongSanPham = tenDongSanPham;
		this.maLoaiSanPham = maLoaiSanPham;
		this.tenLoaiSanPham = tenLoaiSanPham;
		this.maThuongHieu = maThuongHieu;
		this.tenThuongHieu = tenThuongHieu;
		this.hinhAnhBase64 = hinhAnhBase64;
	}

	public SanPhamDTO(String id, String tenSanPham, String xuatXu, String tenLoaiSanPham, String tenThuongHieu,
			int tongSoLuong) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.xuatXu = xuatXu;
		this.tenLoaiSanPham = tenLoaiSanPham;
		this.tenThuongHieu = tenThuongHieu;
		this.tongSoLuong = tongSoLuong;
	}

	public SanPhamDTO(String id, String tenSanPham, String moTa, double giaNhap, double giaBan, String xuatXu,
			boolean trangThai, int baoHanh, int namSanXuat,
			String maDongSanPham, String tenDongSanPham, String maLoaiSanPham, String tenLoaiSanPham,
			String maThuongHieu, String tenThuongHieu, String hinhAnhBase64, List<MauSanPhamDTO> listMauSanPhamDTOs) {
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
		this.maDongSanPham = maDongSanPham;
		this.tenDongSanPham = tenDongSanPham;
		this.maLoaiSanPham = maLoaiSanPham;
		this.tenLoaiSanPham = tenLoaiSanPham;
		this.maThuongHieu = maThuongHieu;
		this.tenThuongHieu = tenThuongHieu;
		this.hinhAnhBase64 = hinhAnhBase64;
		this.listMauSanPhamDTOs = listMauSanPhamDTOs;
	}

	public SanPhamDTO() {
		this.giaNhap = 0;
		this.giaBan = 0;
		this.baoHanh = 0;
		this.namSanXuat = 0;
	}
	public void setNamSanXuat(Integer namSanXuat) {
		
		if (namSanXuat == null) {
			this.namSanXuat = 0;
			return;
		}
		
		this.namSanXuat = namSanXuat;
	}

	public void setGiaNhap(Double giaNhap) {
		
		if (giaNhap == null) {
			this.giaNhap = 0;
			return;
		}
		this.giaNhap = giaNhap;
	}

	public void setGiaBan(Double giaBan) {
		if (giaBan == null) {
			this.giaBan = 0;
			return;
		}
		this.giaBan = giaBan;
	}

	public void setBaoHanh(Integer baoHanh) {
		if (baoHanh == null) {
			this.baoHanh = 0;
			return;
		}
		this.baoHanh = baoHanh;
	}

	@Override
	public String toString() {
		return "SanPhamDTO [id=" + id + ", tenSanPham=" + tenSanPham + ", moTa=" + moTa + ", giaNhap=" + giaNhap
				+ ", giaBan=" + giaBan + ", xuatXu=" + xuatXu + ", trangThai=" + trangThai + ", baoHanh=" + baoHanh
				+ ", namSanXuat=" + namSanXuat 
				+ ", maDongSanPham=" + maDongSanPham + ", tenDongSanPham=" + tenDongSanPham + ", maLoaiSanPham="
				+ maLoaiSanPham + ", tenLoaiSanPham=" + tenLoaiSanPham + ", maThuongHieu=" + maThuongHieu
				+ ", tenThuongHieu=" + tenThuongHieu + ", hinhAnhBase64=" + hinhAnhBase64 + ", listMauSanPhamDTOs="
				+ listMauSanPhamDTOs + ", tongSoLuong=" + tongSoLuong + "]";
	}


}
