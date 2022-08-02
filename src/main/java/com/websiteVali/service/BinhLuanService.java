package com.websiteVali.service;

import java.util.List;

import com.websiteVali.entity.BinhLuan;

public interface BinhLuanService {
	public List<BinhLuan> getBinhLuanTheoMaSanPham(String id);

	public void themBinhLuan(BinhLuan binhLuan);

}
