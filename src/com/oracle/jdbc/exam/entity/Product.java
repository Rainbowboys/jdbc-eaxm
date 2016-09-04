package com.oracle.jdbc.exam.entity;

public class Product {
	private int ID;
	private String product_name;
	private String product_category;
	private double product_unitprice;

	public Product() {
	}

	public Product(int iD, String product_name, String product_category, double product_unitprice) {
		super();
		ID = iD;
		this.product_name = product_name;
		this.product_category = product_category;
		this.product_unitprice = product_unitprice;
	}
	public Product(String product_name, String product_category, double product_unitprice) {
		super();
		this.product_name = product_name;
		this.product_category = product_category;
		this.product_unitprice = product_unitprice;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public double getProduct_unitprice() {
		return product_unitprice;
	}

	public void setProduct_unitprice(double product_unitprice) {
		this.product_unitprice = product_unitprice;
	}

	@Override
	public String toString() {
		return "Product [ID=" + ID + ", product_name=" + product_name + ", product_category=" + product_category
				+ ", product_unitprice=" + product_unitprice + "]";
	}
	
}
