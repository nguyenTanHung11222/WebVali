package com.websiteVali.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuangCaoDTO {
	private int id;
	
	private Date ngayThem;

	private String link;
	
	private String hinhAnhBase64;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getHinhAnhBase64() {
		return hinhAnhBase64;
	}

	public void setHinhAnhBase64(String hinhAnhBase64) {
		this.hinhAnhBase64 = hinhAnhBase64;
	}

	public QuangCaoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuangCaoDTO(int id, Date ngayThem, String link, String hinhAnhBase64) {
		super();
		this.id = id;
		this.ngayThem = ngayThem;
		this.link = link;
		this.hinhAnhBase64 = hinhAnhBase64;
	}

	@Override
	public String toString() {
		return "QuangCaoDTO [id=" + id + ", ngayThem=" + ngayThem + ", link=" + link + ", hinhAnhBase64="
				+ hinhAnhBase64 + "]";
	}

}
