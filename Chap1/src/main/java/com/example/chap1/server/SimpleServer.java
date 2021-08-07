package com.example.chap1.server;

import com.example.chap1.domain.Dish;
import com.example.chap1.service.KitchenService;

import reactor.core.publisher.Flux;

public class SimpleServer {

	private final KitchenService kitchenService;

	public SimpleServer(KitchenService kitchenService) {
		this.kitchenService = kitchenService;
	}

	Flux<Dish> doingMyJob() {
		return this.kitchenService.getDishes()
			.map(Dish::deliver);
	}
}
