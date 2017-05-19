package com.suseel.webStore.domain.repository;

import java.util.List;

import com.suseel.webStore.domain.Product;

public interface ProductRepository {
	public List<Product> getAllProducts();
	Product getProductById(String productID);

}
