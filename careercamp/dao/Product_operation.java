package com.careercamp.dao;
import java.util.ArrayList;
import java.util.List;

import com.careercamp.dto.Product;
public class Product_operation {
	private static final List<Product>products=new ArrayList<>();
 public void add_product(Product product) {
	 products.add(product);
 }
 public List<Product>getAllProducts(){
	 return products;
 }
 public void deleteProduct(int proId) {
	 boolean isDeleted=products.remove(products)
 }
}
