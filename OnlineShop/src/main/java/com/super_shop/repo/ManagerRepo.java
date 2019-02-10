package com.super_shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.super_shop.entity.ManagerInfo;

public interface ManagerRepo extends JpaRepository<ManagerInfo, Long>{

	ManagerInfo findByManagerId(Long managerId);


}
