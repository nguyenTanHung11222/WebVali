package com.websiteVali.entity;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "ThuongHieus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThuongHieu {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "thuongHieu_generator")
	@GenericGenerator(name = "thuongHieu_generator", strategy = "com.websiteVali.util.MyGenerator", parameters = {
			@Parameter(name = MyGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = MyGenerator.VALUE_PREFIX_PARAMETER, value = "TH"),
			@Parameter(name = MyGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") }) // Tạo id có dạng TH00001, TH00002,...
	@Column(name = "thuong_hieu_id")
	private String id;

	@Column(name = "ten_thuong_hieu", columnDefinition = "NVARCHAR(MAX)")
	private String tenThuongHieu;
	
	@Lob
	@Column(name = "hinh_anh")
	private Blob hinhAnh;

	@OneToMany(mappedBy = "thuongHieu", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<DongSanPham> dongSanPhams;

	/**
	 * @param id
	 */
	public ThuongHieu(String id) {
		super();
		this.id = id;
	}

	/**
	 * @param id
	 * @param tenThuongHieu
	 */
	public ThuongHieu(String id, String tenThuongHieu) {
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

	public Blob getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(Blob hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public List<DongSanPham> getDongSanPhams() {
		return dongSanPhams;
	}

	public void setDongSanPhams(List<DongSanPham> dongSanPhams) {
		this.dongSanPhams = dongSanPhams;
	}

	public ThuongHieu(String id, String tenThuongHieu, Blob hinhAnh, List<DongSanPham> dongSanPhams) {
		super();
		this.id = id;
		this.tenThuongHieu = tenThuongHieu;
		this.hinhAnh = hinhAnh;
		this.dongSanPhams = dongSanPhams;
	}

	public ThuongHieu() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ThuongHieu [id=" + id + ", tenThuongHieu=" + tenThuongHieu + ", hinhAnh=" + hinhAnh + ", dongSanPhams="
				+ dongSanPhams + "]";
	}

}
