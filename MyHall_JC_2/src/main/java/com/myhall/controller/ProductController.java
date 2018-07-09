package com.myhall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myhall.model.Product;
import com.myhall.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/products", method= RequestMethod.GET)
	public @ResponseBody List<Product> getAllProducts(){
		
		return productService.getProducts();
	}
	
	 @RequestMapping(value = "/newproducts", method = RequestMethod.GET)
	    public ResponseEntity<List<Product>> getAllProducts2() {
	        List<Product> prod = productService.getProducts();
	        if(prod.isEmpty()){
	            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Product>>(prod, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/subcategories/{category}", method = RequestMethod.POST)
	    public ResponseEntity<List<Product>> getsubCategories(@PathVariable("category") String category) {
	        List<Product> prod = productService.getSubCategories(category);
	        System.out.println(prod);
	        if(prod.isEmpty()){
	            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Product>>(prod, HttpStatus.OK);
	    }
	 
}
