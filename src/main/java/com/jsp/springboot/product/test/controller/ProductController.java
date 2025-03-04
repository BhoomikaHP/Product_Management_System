package com.jsp.springboot.product.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.product.test.dto.ProductRequest;
import com.jsp.springboot.product.test.model.Product;
import com.jsp.springboot.product.test.service.ProductService;
import com.jsp.springboot.product.test.utility.ResponseStructure;

@RestController
public class ProductController {
	//	@Autowired
	private ProductService productService;



	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping(value = "/products")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody ProductRequest productRequest){
		return productService.saveProduct(productRequest);
	}

	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> findByProductId(@PathVariable int productId) {
		return productService.findByProductId(productId);
	}

	@PutMapping(value = "/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(@PathVariable int productId , @RequestBody ProductRequest productRequest){
		return productService.updateByProductId(productId, productRequest);
	}


	@DeleteMapping(value = "/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(@PathVariable int productId){
		return productService.deleteByProductId(productId);
	}


	@GetMapping(value = "/products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts(){
		return productService.findAllProducts();
	}

}
