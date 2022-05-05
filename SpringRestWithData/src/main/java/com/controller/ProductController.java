package com.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Product;
import com.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(value = "getAllProduct",
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllProductInfo() {
		return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	@PostMapping(value = "storeProduct",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> storeProductInfo(@Valid @RequestBody Product prod) {
		
				return new ResponseEntity<String>(productService.storeProductInfo(prod),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "deleteProduct/{pid}")
	public ResponseEntity<String> storeProductInfo(@PathVariable("pid") int pid) {
					return new ResponseEntity<String>(productService.deleteProductInfo(pid),HttpStatus.OK);
	}
	
	@PatchMapping(value = "updateProduct")
	public ResponseEntity<String> updateProductInfo(@RequestBody Product prod) {
					return new ResponseEntity<String>(productService.updateProductInfo(prod),HttpStatus.OK);
	}
	
	@GetMapping(value = "findProdutByPrice/{price}")
	public ResponseEntity<List<Product>> findProductByPrice(@PathVariable("price") float price) {
		return new ResponseEntity<List<Product>>(productService.findProductUsingPrice(price),HttpStatus.OK);
	}
	
	@GetMapping(value = "findProdutByName/{pname}")
	public ResponseEntity<List<Product>> findProductByName(@PathVariable("pname") String pname) {
		return new ResponseEntity<List<Product>>(productService.findProductUsingName(pname),HttpStatus.OK);
	}
	
	@GetMapping(value = "findProductUsingPartialName/{pname}")
	public ResponseEntity<List<Product>> findProductUsingPartialName(@PathVariable("pname") String pname) {
		return new ResponseEntity<List<Product>>(productService.findProductUsingPartialName(pname),HttpStatus.OK);
	}
	
	@GetMapping(value = "fetchProductByIdRange")
	public ResponseEntity<List<Product>> fetchProductByIdRange() {
		return new ResponseEntity<List<Product>>(productService.fetchProductByIdRange(1,2),HttpStatus.OK);
	}
	
	
	@GetMapping(value = "findProductBypIdRange")
	public ResponseEntity<List<Product>> findProductBypIdRange() {
		return new ResponseEntity<List<Product>>(productService.findProductBypIdRange(2,3),HttpStatus.OK);
	}
	
	@GetMapping(value = "fetchByname")
	public ResponseEntity<List<Product>> fetchByname() {
		return new ResponseEntity<List<Product>>(productService.fetchByname("laptop","airpods","headsets"),HttpStatus.OK);
	}
	
	@GetMapping(value = "findProductNameById")
	public ResponseEntity<List<String>> findProductNameById() {
		return new ResponseEntity<List<String>>(productService.findProductNameById(1,3),HttpStatus.OK);
	}
	
	@GetMapping(value = "findProductPartialDataByName/{pname}")
	public ResponseEntity<Object> findProductPartialDataByName(@PathVariable("pname") String pname) {
		return new ResponseEntity<Object>(productService.findProductPartialDataByName(pname),HttpStatus.OK);
	}
	@GetMapping(value = "fetchMaxPrice")
	public float fetchMaxPrice() {
		return productService.fetchMaxPrice();
		
	}
	@GetMapping(value = "fetchAggregateData")
	public ResponseEntity<Object> fetchAggregateData() {
		return new ResponseEntity<Object>(productService.fetchAggregateData(),HttpStatus.OK);
		
	}
}



