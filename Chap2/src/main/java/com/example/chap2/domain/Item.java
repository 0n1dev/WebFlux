package com.example.chap2.domain;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class Item {

	@Id
	private String id;
	private String name;
	private double price;

	private Item() {

	}

	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Item item = (Item)o;
		return Double.compare(item.price, price) == 0 && id.equals(item.id) && Objects.equals(name,
			item.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}