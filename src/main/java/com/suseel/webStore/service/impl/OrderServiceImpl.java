package com.suseel.webStore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suseel.webStore.domain.Product;
import com.suseel.webStore.domain.repository.ProductRepository;
import com.suseel.webStore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void processOrder(String productId, int count) {
		Product productById = productRepository.getProductById(productId);
		
		if(productById.getUnitsInStock() < count){
			throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ productById.getUnitsInStock());
			}
		
		productById.setUnitsInStock(productById.getUnitsInStock() - count);
	}

}
