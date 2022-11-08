package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.entity.BrandEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long>{

}
