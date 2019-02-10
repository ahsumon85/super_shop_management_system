package com.super_shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.super_shop.entity.Bill;

public interface BillRepo extends JpaRepository<Bill, Long>{

}
