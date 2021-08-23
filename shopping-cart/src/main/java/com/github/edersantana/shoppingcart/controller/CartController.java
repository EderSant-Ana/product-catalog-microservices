package com.github.edersantana.shoppingcart.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.edersantana.shoppingcart.model.Cart;
import com.github.edersantana.shoppingcart.model.Item;
import com.github.edersantana.shoppingcart.repository.CartRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

	private CartRepository cartRepository;
	
	@PostMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cart addItem(@PathVariable Integer id, @RequestBody Item item) {
		Optional<Cart> savedCart = cartRepository.findById(id);
		Cart cart;
		if(savedCart.isEmpty()) {
			cart = new Cart(id);
		}else {
			cart = savedCart.get();
		}
		cart.getItems().add(item);
		return cartRepository.save(cart);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Cart> findById(@PathVariable Integer id){
		return cartRepository.findById(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id){
		cartRepository.deleteById(id);
	}
}



