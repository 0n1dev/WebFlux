package com.example.chap1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.chap1.server.PoliteServer;
import com.example.chap1.service.KitchenService;

// @SpringBootApplication
public class Chap1Application {

	public static void main(String[] args) {
		// SpringApplication.run(Chap1Application.class, args);
		PoliteServer server =
			new PoliteServer(new KitchenService());

		server.doingMyJob().subscribe(
			dish -> System.out.println("Consuming "  + dish),
			System.err::println
		);
	}

}
