package com.websiteVali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MauDTO {
	private int id;
	private String tenMau;
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
	public MauDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MauDTO(int id, String tenMau) {
		super();
		this.id = id;
		this.tenMau = tenMau;
	}
	@Override
	public String toString() {
		return "MauDTO [id=" + id + ", tenMau=" + tenMau + "]";
	}

}
