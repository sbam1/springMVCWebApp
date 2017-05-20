package com.suseel.webStore.domain.repository.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.suseel.webStore.domain.Product;
import com.suseel.webStore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository {
	
	private List<Product> listOfProducts = new ArrayList<Product>();
	public InMemoryProductRepository() {
	Product iphone = new Product("P1234","iPhone 5s", 500);
	iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
	iphone.setCategory("Smart Phone");
	iphone.setManufacturer("Apple");
	iphone.setUnitsInStock(1000);
	Product laptop_dell = new Product("P1235","Dell Inspiron", 1000);
	laptop_dell.setDescription("Dell Inspiron 14-inch Laptop(Black) with 3rd Generation Intel Core processors");
	laptop_dell.setCategory("Laptop");
	laptop_dell.setManufacturer("Dell");
	laptop_dell.setUnitsInStock(1000);
	Product tablet_Nexus = new Product("P1236","Nexus 7", 400);
	tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm SnapdragonTM S4 Proprocessor");
	tablet_Nexus.setCategory("Tablet");
	tablet_Nexus.setManufacturer("Google");
	tablet_Nexus.setUnitsInStock(1000);
	listOfProducts.add(iphone);
	listOfProducts.add(laptop_dell);
	listOfProducts.add(tablet_Nexus);
	}

	public List<Product> getAllProducts() {
		return listOfProducts;
	}

	public Product getProductById(String productID) {
		for(Product product :listOfProducts) {
			if(product.getProductId().equalsIgnoreCase(productID)) {
				return product;
			}
		}
		return null;
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		List<Product> result = new ArrayList<Product>();
		for(Product product : listOfProducts) {
			if(category.equalsIgnoreCase(product.getCategory())){
				System.out.println("----------------->>> category added");
				result.add(product);
			}
		}
		
		return result;
	}

	@Override
	public List<Product> getProductsByFilter(Map<String, List<String>>
	filterParams) {
		List<Product> productsByBrand = new ArrayList<Product>();
		List<Product> productsByCategory = new ArrayList<Product>();
		Set<String> criterias = filterParams.keySet();
		if(criterias.contains("brand")) {
			for(String brandName: filterParams.get("brand")) {
				for(Product product: listOfProducts) {
					if(brandName.equalsIgnoreCase(product.getManufacturer())){
						productsByBrand.add(product);
					}
				}	
			}
		}
		if(criterias.contains("category")) {
			for(String category: filterParams.get("category")) {
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		productsByCategory.addAll(productsByBrand);
	return productsByCategory;
	}

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		List<Product> result = new ArrayList<Product>();
		for(Product product : listOfProducts){
			if(product.getManufacturer().equalsIgnoreCase(manufacturer)) {
				result.add(product);
			}
		}
		return result;
	}

	@Override
	public void addProduct(Product product) {
		this.getAllProducts().add(product);
		
	}

}
