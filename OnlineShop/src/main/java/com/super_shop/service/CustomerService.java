package com.super_shop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.super_shop.dto.CustomerDTO;
import com.super_shop.entity.Customer;
import com.super_shop.repo.CustomerRepo;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;

	public List<CustomerDTO> findAllCustomer() {
		return customerRepo.findAll().stream().map(customer -> copyEntityToDTO(customer)).collect(Collectors.toList());
	}
	
	public CustomerDTO copyEntityToDTO(Customer customer){
		CustomerDTO customerDTO=new CustomerDTO();
		BeanUtils.copyProperties(customer, customerDTO);
		return customerDTO;
		
	}
	
	public Customer copyDtoToEntity(CustomerDTO customerDTO){
		Customer customer=new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		return customer;
	}

}
