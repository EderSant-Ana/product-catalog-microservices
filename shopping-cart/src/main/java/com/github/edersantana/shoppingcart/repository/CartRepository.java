package com.github.edersantana.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.edersantana.shoppingcart.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer>{

}
