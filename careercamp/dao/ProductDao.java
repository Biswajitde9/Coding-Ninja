package com.careercamp.dao;
import com.careercamp.dto.Product;
import com.careercamp.service.ProductNotFoundException;
public interface ProductDao {
	void addProduct(Product product);
    void deleteProduct(int prodId) throws ProductNotFoundException;
    void updateProduct(Product product) throws ProductNotFoundException;
    Product searchProductById(int prodId) throws ProductNotFoundException;
    Product searchProductByName(String prodName) throws ProductNotFoundException;
    Product[] getAllProducts();
    Product[] getProductsByPriceOrder(boolean ascending);
    Product[] getProductsByDiscountOrder(boolean ascending);
}
