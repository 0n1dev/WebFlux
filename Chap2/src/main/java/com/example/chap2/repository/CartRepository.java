package com.example.chap2.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.chap2.domain.Cart;

public interface CartRepository extends ReactiveCrudRepository<Cart, String> {
}
