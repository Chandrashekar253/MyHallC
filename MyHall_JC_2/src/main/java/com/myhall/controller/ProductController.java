package com.myhall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myhall.model.Product;
import com.myhall.model.ProductDetails;
import com.myhall.model.ProductList;
import com.myhall.model.UserLogin;
import com.myhall.model.UserRegistration;
import com.myhall.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	public HttpSession subCatSession;
	
//	@RequestMapping(value="/products", method= RequestMethod.GET)
//	public @ResponseBody List<Product> getAllProducts(){
//		
//		return productService.getProducts();
//	}
	
	 @RequestMapping(value = "/products", method = RequestMethod.GET)
	    public ResponseEntity<List<Product>> getAllProducts2() {
	        List<Product> prod = productService.getProducts();
	        if(prod.isEmpty()){
	            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);// 
	        }
	        return new ResponseEntity<List<Product>>(prod, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/subcategories/{category}", method = RequestMethod.POST)
	    public ResponseEntity<List<Product>> getsubCategories(@PathVariable("category") String category, HttpSession subCatSession) {
	        List<Product> prod = productService.getSubCategories(category);
	        //System.out.println(prod);
	        subCatSession.setAttribute("subCatSession", category);
			System.out.println("Category session :"+subCatSession.getAttribute("subCatSession"));

	        if(prod.isEmpty()){
	        	System.out.println("Null Catched");
	            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);// 
	        }
	        return new ResponseEntity<List<Product>>(prod, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/hallslist", method = RequestMethod.GET)
	    public ResponseEntity<List<ProductList>> getAllProductsList() {
		// System.out.println(subCatSession.getAttribute("subCatSession"));
	        List<ProductList> prod = productService.getproductList();
	        if(prod.isEmpty()){
	            return new ResponseEntity<List<ProductList>>(HttpStatus.NO_CONTENT);// 
	        }
	        return new ResponseEntity<List<ProductList>>(prod, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/Halldetails/{id}", method = RequestMethod.POST)
	    public ResponseEntity<List<ProductDetails>> getsubCategories(@PathVariable("id") int id) {
	        List<ProductDetails> prod = productService.getDetails(id);
	        System.out.println(prod);
	        if(prod.isEmpty()){
	            return new ResponseEntity<List<ProductDetails>>(HttpStatus.NO_CONTENT);// 
	        }
	        return new ResponseEntity<List<ProductDetails>>(prod, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value="/loginprocess/", method = RequestMethod.POST)
	 public ResponseEntity<Void>  testlogin(@RequestBody UserLogin user, HttpSession LoginSession){
		 
		 
		boolean status = productService.loginCheck(user);
		 
		if(status==false) {
		 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		LoginSession.setAttribute("LoginSession", user.getUserName());
		System.out.println(LoginSession.getAttribute("LoginSession"));
		return new ResponseEntity<Void>(HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/registrationprocess/", method = RequestMethod.POST)
	 public ResponseEntity<Void> registerUser(@RequestBody UserRegistration user){
		 
		int status = productService.registration(user);
		 
		if(status==0) {
		 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		 
		return new ResponseEntity<Void>(HttpStatus.OK);
	 }
	 
}
