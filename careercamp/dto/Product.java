package com.careercamp.dto;

public class Product {
	private int prodId;
	private String prodName;
	private double price;
	private int quantity;
	private double discount;
	public Product(int prodId,String prodName,double price,int quantity,double discount) {
		this.prodId=prodId;
		this.prodName=prodName;
		this.price=price;
		this.quantity=quantity;
		this.discount=discount;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		 this.prodId=prodId;
	}
	public String getprodName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		 this.prodName=prodName;
	}
	public double getprice() {
		return price;
	}
	public void setprice(double price) {
		 this.price=price;
	}
	public int getquantity() {
		return quantity;
	}
	public void setquantity(int quantity) {
		 this.quantity=quantity;
	}
	public double getdiscount() {
		return discount;
	}
	public void setdiscount(double discount) {
		 this.discount=discount;
	}
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", price=" + price + ", quantity=" + quantity
				+ ", discount=" + discount + "]";
	}
	
	public void printProduct() {
		System.out.println("Product with ID " + this.prodId + " found: " + this.getprodName() + " " + this.getprice() + " " + this.getdiscount()+" ");
	}
	
}

