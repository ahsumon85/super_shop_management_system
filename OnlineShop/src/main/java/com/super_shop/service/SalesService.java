package com.super_shop.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.super_shop.dto.BillDTO;
import com.super_shop.dto.PriceDTO;
import com.super_shop.dto.SalesDTO;
import com.super_shop.entity.Bill;
import com.super_shop.entity.Customer;
import com.super_shop.entity.Price;
import com.super_shop.entity.Product;
import com.super_shop.entity.Sales;
import com.super_shop.repo.BillRepo;
import com.super_shop.repo.PriceRepo;
import com.super_shop.repo.SalesRepo;

@Service
@Transactional
public class SalesService {

	@Autowired
	private PriceRepo priceRepo;

	@Autowired
	private SalesRepo salesRepo;

	@Autowired
	private BillRepo billRepo;

	private List<SalesDTO> salesDTOs;

	private List<Price> priceList;
	
	long id=1;

	public List<SalesDTO> prepareTempProducts(SalesDTO salesDTO) {
		if (salesDTOs == null) {
			salesDTOs = new ArrayList<>();
		}
		salesDTOs.add(prepareProductList(salesDTO));
		return salesDTOs;
	}

	public List<SalesDTO> saveSales() {
		List<Sales> salesEntityList = new ArrayList<>();
		Bill bill = new Bill();
		bill = billInfo();
		for (SalesDTO s : salesDTOs) {
			Sales sales = new Sales();
			sales.setPrice(prvidePrice(s.getPrice().getPriceId()));
			sales.setQuantity(s.getQuantity());
			sales.setBill(bill);
			salesEntityList.add(sales);
		}
		salesRepo.save(salesEntityList);

		priceRepo.save(salesEntityList.stream().map(sales -> prepareTempPrice(sales)).collect(Collectors.toList()));
		if (salesDTOs != null) {
			salesDTOs = null;
		}
		return salesDTOs;
	}
	
	public Price prepareTempPrice(Sales sales) {
		Price price = providePriceBySales(sales);
		price.setPriceId(sales.getPrice().getPriceId());
		price.setBar_code(price.getBar_code());
		price.setCreate_date(price.getCreate_date());
		price.setItem_quantity(price.getItem_quantity() - sales.getQuantity());
		price.setProductSize(price.getProductSize());
		price.setRetails_price(price.getRetails_price());
		return price;
	}

	public List<SalesDTO> resetSales() {
		if (salesDTOs != null) {
			salesDTOs = null;
		}
		return salesDTOs;
	}

	public Bill billInfo() {
		Bill bill = new Bill();
		BillDTO billDTO = new BillDTO();
		billDTO.setCustBillId(makeCustBillId());
		billDTO.setCreateDate(new Date());
		BeanUtils.copyProperties(billDTO, bill);
		bill = billRepo.save(bill);
		return bill;
	}

	public SalesDTO prepareProductList(SalesDTO salesDTO) {
		if (priceList == null) {
			priceList = findAllPricesProduct();
		}
		Price price = findAllPriceById(salesDTO, priceList);
		if(price.getItem_quantity() <= salesDTO.getQuantity()){
			salesDTO.setQuantity(price.getItem_quantity());
		}else {
			salesDTO.setQuantity(salesDTO.getQuantity());
		}	
		salesDTO.setSaleId(id++);
		salesDTO.setProductName(price.getProduct().getItemName());
		salesDTO.setPurchase_price(price.getRetails_price());
		salesDTO.setTotualPrice((float) (price.getRetails_price() * salesDTO.getQuantity()));
		return salesDTO;
	}

	public Price findAllPriceById(SalesDTO salesDTO, List<Price> priceList) {
		return priceList.stream().filter(price -> price.getProduct().getItemId() == salesDTO.getPrice().getPriceId())
						.collect(Collectors.toList()).get(0);
	}

	public Price providePriceBySales(Sales sales) {
		return priceList.stream().filter(price -> price.getProduct().getItemId() == sales.getPrice().getPriceId())
						.collect(Collectors.toList()).get(0);
	}

	public List<SalesDTO> findAllSales() {
		return salesRepo.findAll().stream().map(sale -> saleEntityToDto(sale)).collect(Collectors.toList());
	}

	public SalesDTO saleEntityToDto(Sales sales) {
		
		SalesDTO salesDTO = new SalesDTO();

		float profite = sales.getPrice().getRetails_price() - sales.getPrice().getPurchase_price();
		salesDTO.setIndividual_profit((double) (sales.getQuantity() * profite));
		salesDTO.setTotualPrice((float) (sales.getPrice().getRetails_price() * sales.getQuantity()));
		BeanUtils.copyProperties(sales, salesDTO);
		return salesDTO;
	}

	public Price prvidePrice(Long priceId) {
		Price price = new Price();
		price.setPriceId(priceId);
		return price;
	}

	public List<PriceDTO> findAllPrice() {
		if (priceList == null) {
			priceList = findAllPricesProduct();
		}
		return priceList.stream().map(price -> copyPriceToPriceDTO(price)).collect(Collectors.toList());
	}

	public List<Price> findAllPricesProduct() {
		return priceRepo.findAll();
	}

	public PriceDTO copyPriceToPriceDTO(Price price) {
		PriceDTO priceDTO = new PriceDTO();
		priceDTO.setTotal_price((float) (price.getRetails_price() * price.getItem_quantity()));
		priceDTO.setTotal_capital((float) (price.getPurchase_price() * price.getItem_quantity()));
		priceDTO.setIndividual_profit((int) (priceDTO.getTotal_price() - priceDTO.getTotal_capital()));
		int totalCapita = 0, totalProfit = 0;
		totalProfit += priceDTO.getTotal_price();
		totalCapita += priceDTO.getTotal_capital();
		priceDTO.setTotal_profit(totalProfit - totalCapita);
		if (price.getItem_quantity() != 0) {
			String item = String.valueOf(price.getItem_quantity());
			priceDTO.setStrignQuantity(item);
		} else {
			priceDTO.setStrignQuantity("stock empty..!");
		}

		BeanUtils.copyProperties(price, priceDTO);
		return priceDTO;
	}

	public String makeCustBillId() {
		long currentId = 16 + new Date().getTime();
		String customerId = "B0" + currentId;
		return customerId;
	}

	
}
