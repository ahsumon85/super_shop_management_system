package com.super_shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.super_shop.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
