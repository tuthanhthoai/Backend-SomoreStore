package com.backend.convert;

import com.backend.dto.LoginDTO;
import com.backend.entity.LoginEntity;

public class LoginEntity_TO_LoginDTO {
	public LoginDTO toDTO(LoginEntity loginEntity) {
		LoginDTO x = new LoginDTO();
		x.setCustomer_id(loginEntity.getCustomer().getId());
		x.setUsername(loginEntity.getUsername());
		x.setPassword(loginEntity.getPassword());
		x.setRole(loginEntity.getRole());
		x.setSession(loginEntity.getSession());
		x.setAuth_provider(loginEntity.getProvider());
		return x;
	}
	
	public LoginEntity toEntity(LoginDTO loginDTO) {
		LoginEntity x = new LoginEntity();
		x.setUsername(loginDTO.getUsername());
		x.setPassword(loginDTO.getPassword());
		x.setRole(loginDTO.getRole());
		x.setSession(loginDTO.getSession());
		x.setProvider(loginDTO.getAuth_provider());
		return x;
	}
}
