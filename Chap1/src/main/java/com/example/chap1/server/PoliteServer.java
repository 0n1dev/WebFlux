package com.example.chap1.server;

import com.example.chap1.domain.Dish;
import com.example.chap1.service.KitchenService;

import reactor.core.publisher.Flux;

public class PoliteServer {

	private final KitchenService kitchenService;

	public PoliteServer(KitchenService kitchenService) {
		this.kitchenService = kitchenService;
	}

	public Flux<Dish> doingMyJob() {
		return this.kitchenService.getDishes()
			.doOnNext(dish -> {
				System.out.println("thx " + dish + "!");
				System.out.println("Marking the ticket as done.");
			})
			.map(Dish::deliver);
	}
}
