package com.super_shop.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.super_shop.dto.ProductDTO;
import com.super_shop.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{


//	List<Product> findByCategoryCateId(Long id);
	

}
