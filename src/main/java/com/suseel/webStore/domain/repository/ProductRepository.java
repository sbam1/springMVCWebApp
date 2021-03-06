package com.suseel.webStore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.suseel.webStore.domain.Product;

public interface ProductRepository {
	public List<Product> getAllProducts();
	public void addProduct(Product product);
	public Product getProductById(String productID);
	public List<Product> getProductsByCategory(String category);
	public List <Product> getProductsByManufacturer(String manufacturer);
	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams);

}
