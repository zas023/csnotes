package com.thmub.shop.bean;

public class Product {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 数量
	 */
	private int number;

	public Product() {
	}

	public Product(int id, String name, int number) {
		this.id = id;
		this.name = name;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
