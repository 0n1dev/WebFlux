package com.example.chap2.beans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;

import com.example.chap2.domain.Item;

public class TemplateDatabaseLoader {

	@Bean
	public CommandLineRunner initialize(MongoOperations mongo) {
		return args -> {
			mongo.save(new Item("test", 19.99));
			mongo.save(new Item("test2", 20.00));
		};
	}
}
