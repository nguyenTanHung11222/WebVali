package com.websiteVali.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "LoaiSanPhams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoaiSanPham {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loaiSanPham_generator")
	@GenericGenerator(name = "loaiSanPham_generator", strategy = "com.websiteVali.util.MyGenerator", parameters = {
			@Parameter(name = MyGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = MyGenerator.VALUE_PREFIX_PARAMETER, value = "LSP"),
			@Parameter(name = MyGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(name = "loai_san_pham_id")
	private String id;

	@Column(name = "ten_loai_san_pham", columnDefinition = "NVARCHAR(MAX)")
	private String tenLoaiSanPham;

//	@OneToMany(mappedBy = "danhMuc", fetch = FetchType.LAZY)
//	@ToString.Exclude
//	@EqualsAndHashCode.Exclude
//	private List<SanPham> sanPhams;

	@OneToMany(mappedBy = "loaiSanPham", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<DongSanPham> dongSanPhams;

	/**
	 * @param id
	 */
	public LoaiSanPham(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenLoaiSanPham() {
		return tenLoaiSanPham;
	}

	public void setTenLoaiSanPham(String tenLoaiSanPham) {
		this.tenLoaiSanPham = tenLoaiSanPham;
	}

	public List<DongSanPham> getDongSanPhams() {
		return dongSanPhams;
	}

	public void setDongSanPhams(List<DongSanPham> dongSanPhams) {
		this.dongSanPhams = dongSanPhams;
	}

	public LoaiSanPham(String id, String tenLoaiSanPham, List<DongSanPham> dongSanPhams) {
		super();
		this.id = id;
		this.tenLoaiSanPham = tenLoaiSanPham;
		this.dongSanPhams = dongSanPhams;
	}

	@Override
	public String toString() {
		return "LoaiSanPham [id=" + id + ", tenLoaiSanPham=" + tenLoaiSanPham + ", dongSanPhams=" + dongSanPhams + "]";
	}

	public LoaiSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

}
