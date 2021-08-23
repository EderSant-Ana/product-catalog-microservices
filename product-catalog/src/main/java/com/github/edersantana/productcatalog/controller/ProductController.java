package com.github.edersantana.productcatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.edersantana.productcatalog.exceptions.ProductAlreadyRegisteredException;
import com.github.edersantana.productcatalog.exceptions.ProductNotFoundException;
import com.github.edersantana.productcatalog.model.Product;
import com.github.edersantana.productcatalog.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/product")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

	private ProductService productService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) throws ProductAlreadyRegisteredException {
		return productService.save(product);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product findById(@PathVariable Long id) throws ProductNotFoundException {
		Product product = productService.findById(id);
		return product;
	}


}
