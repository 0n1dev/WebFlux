package com.example.chap2.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.chap2.domain.Item;

public interface CartItemRepository extends CrudRepository<Item, String> {
}
