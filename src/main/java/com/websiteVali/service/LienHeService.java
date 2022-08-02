package com.websiteVali.service;

import java.util.List;

import com.websiteVali.entity.LienHe;

public interface LienHeService {
	public List<LienHe> getTatCaLienHe();

	public LienHe getLienHeTheoId(String id);

	public LienHe getLienHe();

	public void xoaLienHe(String id);

	public void themLienHe(LienHe lienHe);

}
