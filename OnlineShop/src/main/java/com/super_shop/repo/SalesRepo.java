package com.super_shop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.super_shop.entity.Sales;

public interface SalesRepo extends JpaRepository<Sales, Long>{


}
