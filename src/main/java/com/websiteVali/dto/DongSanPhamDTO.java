package com.websiteVali.dto;

import java.util.List;

import com.websiteVali.entity.SanPham;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class DongSanPhamDTO {
	
	private String id;

	String thuongHieu;

	String loaiSanPham;

	private String tenDongSanPham;

	private float thue;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<SanPham> sanPhams;

	/**
	 * @param id
	 * @param thuongHieu
	 * @param loaiSanPham
	 * @param tenDongSanPham
	 * @param thue
	 */
	public DongSanPhamDTO(String id, String thuongHieu, String loaiSanPham, String tenDongSanPham, float thue) {
		super();
		this.id = id;
		this.thuongHieu = thuongHieu;
		this.loaiSanPham = loaiSanPham;
		this.tenDongSanPham = tenDongSanPham;
		this.thue = thue;
	}

	@Override
	public String toString() {
		return "DongSanPhamDTO [id=" + id + ", thuongHieu=" + thuongHieu + ", loaiSanPham=" + loaiSanPham
				+ ", tenDongSanPham=" + tenDongSanPham + ", thue=" + thue + ", sanPhams=" + sanPhams + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public String getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(String loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public String getTenDongSanPham() {
		return tenDongSanPham;
	}

	public void setTenDongSanPham(String tenDongSanPham) {
		this.tenDongSanPham = tenDongSanPham;
	}

	public float getThue() {
		return thue;
	}

	public void setThue(float thue) {
		this.thue = thue;
	}

	public List<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	
	
}
