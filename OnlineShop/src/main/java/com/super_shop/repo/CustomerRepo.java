package com.super_shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.super_shop.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
