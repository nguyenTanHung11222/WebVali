package com.websiteVali.entity;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "QuangCaos")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class QuangCao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quang_cao_id")
	private int id;
	
	@Lob
	@Column(name = "hinh_anh")
	private Blob hinhAnh;
	
	@Column(name = "ngay_them")
	private Date ngayThem;
	
	@Column(name = "link")
	private String link;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Blob getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(Blob hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Date getNgayThem() {
		return ngayThem;
	}

	public void setNgayThem(Date ngayThem) {
		this.ngayThem = ngayThem;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public QuangCao(int id, Blob hinhAnh, Date ngayThem, String link) {
		super();
		this.id = id;
		this.hinhAnh = hinhAnh;
		this.ngayThem = ngayThem;
		this.link = link;
	}

	public QuangCao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "QuangCao [id=" + id + ", hinhAnh=" + hinhAnh + ", ngayThem=" + ngayThem + ", link=" + link + "]";
	}

}
