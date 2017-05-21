package com.suseel.webStore.comtroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suseel.webStore.domain.Product;
import com.suseel.webStore.domain.repository.ProductRepository;
import com.suseel.webStore.service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
	
	@RequestMapping("")
	public String envalidRequest(Model model) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing web store");
		model.addAttribute("errorMessage", "you have entered wrong parameter please pass correct one");
		return "welcome";
	}
	
	@RequestMapping("/all")
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
	return "products";
	}
	
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
	return "products";
	}
	
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String, List<String>> filterParams,
	Model model) {
		
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
	return "products";
	}
	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id")String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
	return "product";
	}
	
	@RequestMapping("/{category}/manufacturer")
	public String filterProducts(Model model, @PathVariable("category") String productCategory,
	@RequestParam("manufacturer") String manufacturer) {
		List<Product> products = new ArrayList<Product>();
		
		products = productService.getProductsByCategory(productCategory);
		products.retainAll(productService.getProductsByManufacturer(manufacturer));
		model.addAttribute("products", products);
		return "products";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
	return "addProduct";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded,
			BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		productService.addProduct(productToBeAdded);
	return "redirect:/products/all";
	}

}
