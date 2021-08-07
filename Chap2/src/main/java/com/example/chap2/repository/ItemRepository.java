package com.example.chap2.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.chap2.domain.Item;

public interface ItemRepository extends ReactiveCrudRepository<Item, String> {
}
