package com.github.edersantana.productcatalog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.edersantana.productcatalog.exceptions.ProductAlreadyRegisteredException;
import com.github.edersantana.productcatalog.exceptions.ProductNotFoundException;
import com.github.edersantana.productcatalog.model.Product;
import com.github.edersantana.productcatalog.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

	private ProductRepository productRepository;

	public Product save(Product product) throws ProductAlreadyRegisteredException {
		verifyIfIsAlreadyRegistered(product.getId());
		return productRepository.save(product);
	}

	public Product findById(Long id) throws ProductNotFoundException {
		return productRepository.findById(id).orElseThrow(() -> 
			new ProductNotFoundException(String.format("Product with id %d not found in the system.", id)));
	}

	private void verifyIfIsAlreadyRegistered(Long id) throws ProductAlreadyRegisteredException {
		Optional<Product> obj = productRepository.findById(id);

		if (obj.isPresent()) {
			throw new ProductAlreadyRegisteredException(
					String.format("Product with id %d and name %s already registered in the system.", obj.get().getId(),
							obj.get().getName()));
		}

	}



}
