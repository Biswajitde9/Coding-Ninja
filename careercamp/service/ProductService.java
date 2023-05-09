package com.careercamp.service;

import com.careercamp.dao.ProductDao;
import com.careercamp.dto.Product;

public class ProductService {
    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void deleteProduct(int prodId) throws ProductNotFoundException {
        productDao.deleteProduct(prodId);
    }

    public void updateProduct(Product product) throws ProductNotFoundException {
        productDao.updateProduct(product);
    }

    public Product searchProductById(int prodId) throws ProductNotFoundException {
        return productDao.searchProductById(prodId);
    }

    public Product searchProductByName(String prodName) throws ProductNotFoundException {
        return productDao.searchProductByName(prodName);
    }

    public Product[] getAllProducts() {
        return productDao.getAllProducts();
    }

    public Product[] getProductsByPriceOrder(boolean ascending) {
        return productDao.getProductsByPriceOrder(ascending);
    }

    public Product[] getProductsByDiscountOrder(boolean ascending) {
        return productDao.getProductsByDiscountOrder(ascending);
    }
}

