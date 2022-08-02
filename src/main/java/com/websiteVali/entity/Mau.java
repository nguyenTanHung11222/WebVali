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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Maus")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Mau {

	@Id
	@Column(name = "mau_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ten_mau", columnDefinition = "NVARCHAR(MAX)")
	private String tenMau;
	
	@OneToMany(mappedBy = "mau", fetch = FetchType.EAGER) /// đã doi tu lazy qua eager
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<MauSanPham> mauSanPhams;

	public Mau(int id, String tenMau) {
		super();
		this.id = id;
		this.tenMau = tenMau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenMau() {
		return tenMau;
	}

	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}

	public List<MauSanPham> getMauSanPhams() {
		return mauSanPhams;
	}

	public void setMauSanPhams(List<MauSanPham> mauSanPhams) {
		this.mauSanPhams = mauSanPhams;
	}

	public Mau(int id, String tenMau, List<MauSanPham> mauSanPhams) {
		super();
		this.id = id;
		this.tenMau = tenMau;
		this.mauSanPhams = mauSanPhams;
	}

	public Mau() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Mau [id=" + id + ", tenMau=" + tenMau + ", mauSanPhams=" + mauSanPhams + "]";
	} 
	
	
}
