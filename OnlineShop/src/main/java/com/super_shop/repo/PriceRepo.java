package com.super_shop.repo;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.super_shop.entity.Product;
import com.super_shop.entity.Price;

public interface PriceRepo extends JpaRepository<Price, Long>{

	Price findByProductItemId(Long itemId);

}
