package com.websiteVali.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websiteVali.entity.Mau;
import com.websiteVali.repository.MauRepository;
import com.websiteVali.service.MauService;

@Service
public class MauServiceImpl implements MauService{

	@Autowired
	private MauRepository mauRepository;

	@Override
	public List<Mau> getTatCamau() {
		return mauRepository.findAll();
	}

	@Override
	public Mau getMauTheoTenMau(String tenMau) {
		return mauRepository.findMauByTenMau(tenMau);
	}

	@Override
	public void themMau(Mau mau) {
		mauRepository.save(mau);
	}

	@Override
	public void xoaMau(int id) {
		mauRepository.deleteById(id);
	}

	@Override
	public void capNhatMau(Mau mau) {
		mauRepository.save(mau);
	}

	@Override
	public Mau getMauTheoId(int id) {
		
		return mauRepository.findById(id).get();
	}

}
