package org.dnyanyog.service;

import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.entity.Product;
import org.dnyanyog.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
	@Autowired
	ProductRepo repo;
	@Autowired
	Product product;
	@Autowired
	ProductResponse response;
	
	public ProductResponse saveProduct(ProductRequest req) {
		product.setProduct_id(req.getId());
		product.setName(req.getProductName());
		product.setPrice(req.getPrice());
		product.setQuantity(req.getQuantity());
		product.setCategory(req.getCategory());
		
		repo.save(product);
		
		response.setCode("0000");
		response.setMsg("Everthing is working fine");
		response.setRequest(req);
		
		return response;
		
	}
}
