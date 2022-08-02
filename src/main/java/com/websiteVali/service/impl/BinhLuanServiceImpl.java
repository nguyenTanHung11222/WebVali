package com.websiteVali.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.websiteVali.entity.BinhLuan;
import com.websiteVali.repository.BinhLuanRepository;
import com.websiteVali.service.BinhLuanService;

@Service
public class BinhLuanServiceImpl implements BinhLuanService {

	@Autowired
	BinhLuanRepository binhLuanRepository;

	@Override
	public List<BinhLuan> getBinhLuanTheoMaSanPham(String id) {
		return binhLuanRepository.findBySanPhamId(id, Sort.by(Sort.Direction.DESC, "ngayBinhLuan"));
	}

	@Override
	public void themBinhLuan(BinhLuan binhLuan) {
		binhLuanRepository.save(binhLuan);
	}

}
