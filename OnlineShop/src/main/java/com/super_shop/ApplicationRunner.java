package com.super_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@SpringBootApplication
public class ApplicationRunner {
	
	public static void main(String args[]){
		SpringApplication.run(ApplicationRunner.class, args);
		  System.out.println ("Spring Boot Runing....!");
	}
	
}
