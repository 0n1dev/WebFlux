package com.example.chap11.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chap11.domain.Dish;
import com.example.chap11.service.KitchenService;

import reactor.core.publisher.Flux;

@RestController
public class ServerController {

	private final KitchenService kitchen;

	public ServerController(KitchenService kitchen) {
		this.kitchen = kitchen;
	}

	/**
	 * delivered 필드 false
	 * @return
	 */
	@GetMapping(value = "/server", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Dish> serveDishes() {
		return this.kitchen.getDishes();
	}

	/**
	 * delivered 필드 true
	 * @return
	 */
	@GetMapping(value = "/served/dishes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Dish> diliverDishes() {
		return this.kitchen.getDishes()
			.map(Dish::deliver);
	}
}
