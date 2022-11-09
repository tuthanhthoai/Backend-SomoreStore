//package com.backend.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.backend.dto.LoginDTO;
//import com.backend.repository.LoginRepository;
//
//@Service
//public class LoginServiceImpl implements UserDetailsService,LoginService{
//	@Autowired
//	private LoginRepository loginRepository;
//
//	@Override
//	public ResponseEntity<String> login(LoginDTO loginDTO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		LoginDTO login = loginRepository.findByUsername(username);
//		if(login==null)
//		{
//			throw new UsernameNotFoundException("User Not Found");
//		}
//		return null;
//	}
//}
