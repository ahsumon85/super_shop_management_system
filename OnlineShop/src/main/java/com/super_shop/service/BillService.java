package com.super_shop.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.super_shop.dto.BillDTO;
import com.super_shop.dto.PriceDTO;
import com.super_shop.dto.SalesDTO;
import com.super_shop.entity.Bill;
import com.super_shop.entity.Price;
import com.super_shop.entity.Sales;
import com.super_shop.repo.BillRepo;
import com.super_shop.repo.PriceRepo;
import com.super_shop.repo.SalesRepo;

@Service
@Transactional
public class BillService {

	@Autowired
	private BillRepo billRepo;

	@Autowired
	private SalesRepo salesRepo;
	
	@Autowired
	private PriceRepo priceRepo;

	private List<BillDTO> billDTOs;
	
	private List<PriceDTO> priceDTOs;
	
	public List<BillDTO> findAllCutomerBill() {
		billDTOs = new ArrayList<>();
		billDTOs = billRepo.findAll().stream().map(bill -> copyEntityToDto(bill)).collect(Collectors.toList());
		Collections.reverse(billDTOs);
		return billDTOs;
	}
	
	public List<SalesDTO> findBillDetails(Long billID) {
		List<SalesDTO> salesDTOs = new ArrayList<>();
		salesDTOs=salesRepo.findAll().stream().map(sale -> saleEntityToDto(sale)).filter(bill -> bill.getBill().getBillId().equals(billID)).collect(Collectors.toList());
		return salesDTOs;
	}
	
	public List<BillDTO> findUniqueDate(){
		if (billDTOs==null) {
			findAllCutomerBill();
		}
		return billDTOs.stream().distinct().collect(Collectors.toList());
	}
	
	public BillDTO copyEntityToDto(Bill bill) {
		BillDTO billDTO = new BillDTO();
		DateFormat dateFormat = new SimpleDateFormat("MMM-YYYY");
		String formattedDate = dateFormat.format(bill.getCreateDate());
		billDTO.setDate(formattedDate);
		BeanUtils.copyProperties(bill, billDTO);
		return billDTO;
	}
	
	public List<PriceDTO> findAllPrice(PriceDTO priceDTO){
		priceDTOs=priceRepo.findAll().stream().map(price -> priceEntityToDto(price)).collect(Collectors.toList());
		return priceDTOs;
	}
	
	
	public PriceDTO priceEntityToDto(Price price){
		PriceDTO priceDTO=new PriceDTO();
		BeanUtils.copyProperties(price, priceDTO);
		return priceDTO;
	}
	
	public SalesDTO saleEntityToDto(Sales sales) {
		float totalPrice=0;
		SalesDTO saDto = new SalesDTO();
		Price price=new Price();
		price=priceRepo.findOne(sales.getPrice().getPriceId());
		saDto.setPurchase_price(price.getRetails_price());
		totalPrice +=price.getRetails_price() * sales.getQuantity();
		saDto.setTotualPrice(totalPrice);
		saDto.setProductName(sales.getPrice().getProduct().getItemName());
		BeanUtils.copyProperties(sales, saDto);
		return saDto;
	}

}
