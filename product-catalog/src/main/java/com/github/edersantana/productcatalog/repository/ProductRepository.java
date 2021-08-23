package com.github.edersantana.productcatalog.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.edersantana.productcatalog.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{



}
