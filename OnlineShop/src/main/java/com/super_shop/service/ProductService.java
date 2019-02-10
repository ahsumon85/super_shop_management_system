package com.super_shop.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.super_shop.dto.ProductDTO;
import com.super_shop.entity.Product;
import com.super_shop.repo.CategoryRepo;
import com.super_shop.repo.ProductRepo;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	CategoryRepo categoryRepo;

	List<ProductDTO> productList;

	public Boolean saveitem(ProductDTO productDTO) {
		Boolean save = true;
		productDTO.setItemCode(makeCustomerID());
		productDTO.setIsValid(1);
		productDTO.setCreateDate(new Date());
		productDTO.setCreateBy("admin");
		productRepo.save(copyDtoToEntity(productDTO));
		return save;
	}

	public List<ProductDTO> findProduct() throws Exception {
		productList = new LinkedList<>();
		productList = productRepo.findAll().stream().map(product -> copyEntityToDto(product))
				.collect(Collectors.toList());
		Collections.reverse(productList);
		return productList;
	}

	public List<ProductDTO> findProductById(Long id) throws Exception {
		if (productList == null) {
			findProduct();
		}
		return productList.stream().filter(product -> product.getCategory().getCateId().equals(id))
				.collect(Collectors.toList());
	}

	public ProductDTO findByStudentID(Long itemId) {
		return copyEntityToDto(productRepo.findOne(itemId));
	}

	public Product copyDtoToEntity(ProductDTO productDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		return product;
	}

	public ProductDTO copyEntityToDto(Product product) {
		ProductDTO productDTO = new ProductDTO();
		BeanUtils.copyProperties(product, productDTO);
		return productDTO;
	}

	public String makeCustomerID() {
		long currentId = 10 + new Date().getTime();
		String customerId = "P00" + currentId;
		return customerId;
	}

}
