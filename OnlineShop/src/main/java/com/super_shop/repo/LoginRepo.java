package com.super_shop.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.super_shop.entity.Login;
import com.super_shop.entity.ManagerInfo;

public interface LoginRepo extends JpaRepository<Login, Long>{

	public Login findByUserName(String userName);


}
