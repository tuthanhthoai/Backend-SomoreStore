package com.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.convert.LoginEntity_TO_LoginDTO;
import com.backend.dto.LoginDTO;
import com.backend.entity.LoginEntity;
import com.backend.repository.LoginRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private LoginEntity_TO_LoginDTO loginDTO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginDTO newLogin = new LoginDTO();
		LoginEntity input = loginRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		newLogin=loginDTO.toDTO(input);
		return UserDetailsImpl.build(newLogin);
	}

}
