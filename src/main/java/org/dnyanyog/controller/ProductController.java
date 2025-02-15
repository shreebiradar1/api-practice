package org.dnyanyog.controller;

import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/product")
public class ProductController {
	@Autowired
	ProductService service;
	
	@PostMapping(path ="/product")
	public ProductResponse saveProduct(@RequestBody ProductRequest req) {
		
		return service.saveProduct(req);
	}
}
