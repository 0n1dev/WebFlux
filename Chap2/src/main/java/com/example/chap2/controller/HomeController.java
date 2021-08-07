package com.example.chap2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;

import com.example.chap2.domain.Cart;
import com.example.chap2.repository.CartRepository;
import com.example.chap2.repository.ItemRepository;

import reactor.core.publisher.Mono;

@Controller
public class HomeController {

	private final ItemRepository itemRepository;
	private final CartRepository cartRepository;

	public HomeController(ItemRepository itemRepository,
		CartRepository cartRepository) {
		this.itemRepository = itemRepository;
		this.cartRepository = cartRepository;
	}

	@GetMapping
	public Mono<Rendering> home() {
		return Mono.just(Rendering.view("home.html")
			.modelAttribute("item",
				this.itemRepository.findAll())
			.modelAttribute("cart",
				this.cartRepository.findById("My Cart")
			.defaultIfEmpty(new Cart("My Cart"))
		).build());
	}
}
