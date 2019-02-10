package com.super_shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.impl.SLF4JLocationAwareLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.super_shop.dto.PriceDTO;
import com.super_shop.dto.ProductDTO;
import com.super_shop.dto.SalesDTO;
import com.super_shop.entity.Sales;
import com.super_shop.service.BillService;
import com.super_shop.service.CustomerService;
import com.super_shop.service.PriceService;
import com.super_shop.service.SalesService;


@Controller
public class SalesController {

	@Autowired
	SalesService salesService;

	@Autowired
	private BillService billService;

	@Autowired
	PriceService priceServicece;

	@Autowired
	CustomerService customerService;

	List<SalesDTO> salesList;

	@RequestMapping(path = "/sales", method = RequestMethod.GET)
	public String sales(Model model, SalesDTO salesDTO) {
		model.addAttribute("salesDTO", new SalesDTO());
		model.addAttribute("prices", salesService.findAllPricesProduct());
		model.addAttribute("customers", customerService.findAllCustomer());
		return "saleAdd";
	}

	@RequestMapping(path = "/salesList", method = RequestMethod.POST)
	public String item(Model model, @ModelAttribute SalesDTO salesDTO){
		try {
			model.addAttribute("salesDTO", new SalesDTO());
			model.addAttribute("prices", salesService.findAllPricesProduct());
			salesList = salesService.prepareTempProducts(salesDTO);
			model.addAttribute("salesList", salesList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "saleAdd";
	}
	
	@RequestMapping(path="/sales/{saleId}", method=RequestMethod.GET)
	public String editCategory(Model model, @PathVariable(value="saleId") Long saleId){
		try {
//			model.addAttribute("salesDTO", new SalesDTO());
			for (SalesDTO s : salesList) {
				SalesDTO saDto=new SalesDTO();
				if (s.getSaleId().equals(saleId)) {
					saDto.setSaleId(s.getSaleId());
					saDto=null;
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/salesList";
	}

	@RequestMapping(value = "/saveSales", method = RequestMethod.POST)
	public String itemSave() {
		try {
			salesService.saveSales();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/sales";

	}

	@RequestMapping(value = "/allSaleslist", method = RequestMethod.GET)
	public String allSales(Model model) {
		try {
			model.addAttribute("billList", billService.findUniqueDate());
			model.addAttribute("allSalesList", salesService.findAllSales());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "totalSales";

	}

	@RequestMapping(value = "/resetList", method = RequestMethod.GET)
	public String itemReset() {
		try {
			salesService.resetSales();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/sales";

	}
	
	
	public String downloadSellDetails(){
		
		Map<String, Object> map=new HashMap();
		map.put("name", "online super shop");
		map.put("address", "dhanmondi, Dhaka.");
//		JasperUtil jasperUtil=new JasperUtil();	 
		List<SalesDTO> salesDTOs=new ArrayList<>();
		for(SalesDTO s: salesDTOs){
			SalesDTO salesDTO=new SalesDTO();
			salesDTO.setProductName(s.getProductName());
			salesDTO.setQuantity(s.getQuantity());
			salesDTO.setPurchase_price(s.getPurchase_price());
			salesDTO.setTotualPrice(s.getTotualPrice());
			salesDTOs.add(salesDTO);
		}try {
//			jasperUtil.jasperPrint(salesDTOs, map, "com/super_shop/report/billReport.jasper", "Bill Details");
			salesDTOs=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "saleAdd";
	}
}
