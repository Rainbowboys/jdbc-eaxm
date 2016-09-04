package com.oracle.jdbc.exam.entity;

public class Purcase {
	@Override
	public String toString() {
		return "Purcase [customer_id=" + customer_id + ", product_id=" + product_id + ", num=" + num + "]";
	}

	private int customer_id;
	private int product_id;
	private int num;

	public Purcase() {
	}

	public Purcase(int customer_id, int product_id, int num) {
		super();
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.num = num;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
