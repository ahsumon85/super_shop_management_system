package com.super_shop.service;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.super_shop.dto.CategoryDTO;
import com.super_shop.entity.Category;
import com.super_shop.repo.CategoryRepo;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryRepo cateRepo;

	public void saveCate(CategoryDTO cateDTO) {
		cateDTO.setCreateDate(new Date());
		cateDTO.setCreateBy("admin");
		cateRepo.save(copyDtoToEntity(cateDTO));
	}

	public List<CategoryDTO> findAllCate() {
		List<CategoryDTO> cateList=new LinkedList<>();
		cateList=cateRepo.findAll().parallelStream().map(category -> copyEntityToDto(category)).collect(Collectors.toList());
		Collections.reverse(cateList);
		return cateList;
	}
	
	public CategoryDTO findCateId(Long cateId){
		return copyEntityToDto(cateRepo.findOne(cateId));		
	}
	
	public CategoryDTO copyEntityToDto(Category category){
		CategoryDTO categoryDTO=new CategoryDTO();
		BeanUtils.copyProperties(category, categoryDTO);
		return categoryDTO;
	}
	
	public Category copyDtoToEntity(CategoryDTO categoryDTO){
		Category cgory=new Category();
		BeanUtils.copyProperties(categoryDTO, cgory);
		return cgory;	
	}

}
