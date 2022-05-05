package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductDao;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}
	
	public String storeProductInfo(Product prod) {
				
						if(productDao.existsById(prod.getPid())) {
									return "Product id must be unique";
						}else {
									productDao.save(prod);
									return "Product stored successfully";
						}
	}
	
	public String deleteProductInfo(int pid) {
		if(!productDao.existsById(pid)) {
			return "Product details not present";
			}else {
			productDao.deleteById(pid);
			return "Product deleted successfully";
			}	
	}
	
	public String updateProductInfo(Product prod) {
		if(!productDao.existsById(prod.getPid())) {
			return "Product details not present";
			}else {
			Product p	= productDao.getById(prod.getPid());	// if product not present it will give exception 
			p.setPrice(prod.getPrice());						// existing product price change 
			productDao.saveAndFlush(p);				// save and flush method to update the existing product
			return "Product updated successfully";
			}	
	}
	
	public List<Product> findProductUsingPrice(float price) {
		return productDao.getProductByPrice(price);
	}
	
	public List<Product> findProductUsingName(String pname) {
		return productDao.findBypname(pname);
	}
	
	public List<Product> findProductUsingPartialName(String pname) {
		return productDao.findBypnameLike(pname);
	}
	
	public List<Product> fetchProductByIdRange(int min,int max) {
		return productDao.fetchProductBypIdRange(min, max);
	}
	
	public List<Product> findProductBypIdRange(int min,int max) {
		return productDao.findProductBypIdRange(min, max);
	}
	
	public List<Product> fetchByname(String name1,String name2,String name3) {
		return productDao.fetchByname(name1, name2, name3);
	}
	
	public List<String> findProductNameById(int min,int max) {
		return productDao.findProductNameById(min, max);
	}
	
	public Object findProductPartialDataByName(String pname) {
		return productDao.findProductPartialDataByName(pname);
	}
	
	public float fetchMaxPrice() {
		return productDao.fetchMaxPrice();
		
	}
	
	public Object fetchAggregateData() {
		return productDao.fetchAggregateData();
		
	}
	
	
	
	
}
