package com.websiteVali.dto;

import java.util.List;

import com.websiteVali.entity.DongSanPham;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class ThuongHieuDTO {
	private String id;
	private String tenThuongHieu;
	private String hinhAnhBase64;
	private List<DongSanPham> dongSanPhams;

	public ThuongHieuDTO(String id, String tenThuongHieu) {
		super();
		this.id = id;
		this.tenThuongHieu = tenThuongHieu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<DongSanPham> getDongSanPhams() {
		return dongSanPhams;
	}

	public void setDongSanPhams(List<DongSanPham> dongSanPhams) {
		this.dongSanPhams = dongSanPhams;
	}

	/**
	 * @param id
	 * @param tenThuongHieu
	 * @param hinhAnhBase64
	 */
	public ThuongHieuDTO(String id, String tenThuongHieu, String hinhAnhBase64) {
		super();
		this.id = id;
		this.tenThuongHieu = tenThuongHieu;
		this.hinhAnhBase64 = hinhAnhBase64;
	}

	public ThuongHieuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ThuongHieuDTO [id=" + id + ", tenThuongHieu=" + tenThuongHieu + ", hinhAnhBase64=" + hinhAnhBase64
				+ ", dongSanPhams=" + dongSanPhams + "]";
	}


}
