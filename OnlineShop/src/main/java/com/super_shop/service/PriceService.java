package com.super_shop.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.super_shop.dto.PriceDTO;
import com.super_shop.dto.SalesDTO;
import com.super_shop.entity.Price;
import com.super_shop.repo.PriceRepo;
import com.super_shop.repo.ProductRepo;

@Service
@Transactional
public class PriceService {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private PriceRepo priceRepo;

	public Boolean savePrice(PriceDTO priceDTO) {
		Boolean status= false;
		priceDTO=priceCalculation(priceDTO);
		priceRepo.save(copyDtoToEntity(priceDTO));
		status=true;
		return status;
	}
	
	
	public PriceDTO priceCalculation(PriceDTO priceDTO){
		priceDTO.setBar_code(makePriceID());
		priceDTO.setCreate_date(new Date());
		return priceDTO;
	}

	public Price copyDtoToEntity(PriceDTO priceDTO) {
		Price price = new Price();
		BeanUtils.copyProperties(priceDTO, price);
		return price;
	}


	public String makePriceID() {
		long currentId = 14 + new Date().getTime();
		String customerId = "P00" + currentId;
		return customerId;
	}

	


}
