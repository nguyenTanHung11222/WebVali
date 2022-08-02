package com.websiteVali.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.websiteVali.entity.NguoiDung;
import com.websiteVali.repository.NguoiDungRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private NguoiDungRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// lấy người dùng có user là có username
		NguoiDung nguoiDung = userRepository.findByEmail(username);

		if (nguoiDung == null || !nguoiDung.isTrangThai())
			throw new UsernameNotFoundException("Tài khoản không tồn tại hoặc chưa kích hoạt");

		CustomUserDetails customUserDetails = new CustomUserDetails(nguoiDung);
		
		return customUserDetails;
	}

}
