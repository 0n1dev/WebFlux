package com.example.chap1.service;

import org.springframework.stereotype.Service;

import com.example.chap1.domain.Dish;

import reactor.core.publisher.Flux;

@Service
public class KitchenService {

	public Flux<Dish> getDishes() {
		return Flux.just(
			new Dish("치킨"),
			new Dish("피자"),
			new Dish("햄버거")
		);
	}
}
