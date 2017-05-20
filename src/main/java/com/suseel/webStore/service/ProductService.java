package com.suseel.webStore.service;

import java.util.List;
import java.util.Map;

import com.suseel.webStore.domain.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public void addProduct(Product product);
	public Product getProductById(String productID);
	public List<Product> getProductsByCategory(String category);
	public List <Product> getProductsByManufacturer(String manufacturer);
	List<Product> getProductsByFilter(Map<String,
			List<String>> filterParams);
}
