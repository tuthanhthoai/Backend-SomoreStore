package com.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.LoginEntity;

public interface RoleRepository extends JpaRepository<LoginEntity, Long> {
	
}
