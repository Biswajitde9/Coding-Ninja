package com.careercamp.dao;
import com.careercamp.dto.Product;
import com.careercamp.service.ProductNotFoundException;
import java.util.Arrays;
public class InMemoryProductDao implements ProductDao {
	    private Product[] products;
	    private int currentIndex;

	    public InMemoryProductDao(int capacity) {
	        products = new Product[capacity];
	        currentIndex = 0;
	    }

	    @Override
	    public void addProduct(Product product) {
	        products[currentIndex] = product;
	        currentIndex++;
	    }

	    @Override
	    public void deleteProduct(int prodId) throws ProductNotFoundException {
	        int index = findProductIndexById(prodId);
	        if (index == -1) {
	            throw new ProductNotFoundException("Product with ID " + prodId + " not found");
	        }
	        System.arraycopy(products, index + 1, products, index, currentIndex - index - 1);
	        currentIndex--;
	    }

	    @Override
	    public void updateProduct(Product product) throws ProductNotFoundException {
	        int index = findProductIndexById(product.getProdId());
	        if (index == -1) {
	            throw new ProductNotFoundException("Product with ID " + product.getProdId() + " not found");
	        }
	        products[index] = product;
	    }

	    @Override
	    public Product searchProductById(int prodId) throws ProductNotFoundException {
	        int index = findProductIndexById(prodId);
	        if (index == -1) {
	            throw new ProductNotFoundException("Product with ID " + prodId + " not found");
	        }
	        return products[index];
	    }

	    @Override
	    public Product searchProductByName(String prodName) throws ProductNotFoundException {
	        for (int i = 0; i < currentIndex; i++) {
	            if (products[i].getProdName().equalsIgnoreCase(prodName)) {
	                return products[i];
	            }
	        }
	        throw new ProductNotFoundException("Product with name " + prodName + " not found");
	        @Override
	        public Product[] getAllProducts() {
	            return Arrays.copyOf(products, currentIndex);
	        }

	        @Override
	        public Product[] getProductsByPriceOrder(boolean ascending) {
	            Product[] sortedProducts = Arrays.copyOf(products, currentIndex);
	            Arrays.sort(sortedProducts, (p1, p2) -> {
	                if (ascending) {
	                    return Double.compare(p1.getPrice(), p2.getPrice());
	                } else {
	                    return Double.compare(p2.getPrice(), p1.getPrice());
	                }
	            });
	            return sortedProducts;
	        }

	        @Override
	        public Product[] getProductsByDiscountOrder(boolean ascending) {
	            Product[] sortedProducts = Arrays.copyOf(products, currentIndex);
	            Arrays.sort(sortedProducts, (p1, p2) -> {
	                if (ascending) {
	                    return Double.compare(p1.getdiscount(), p2.getdiscount());
	                } else {
	                    return Double.compare(p2.getdiscount(), p1.getdiscount());
	                }
	            });
	            return sortedProducts;
	        }

	        private int findProductIndexById(int prodId) {
	            for (int i = 0; i < currentIndex; i++) {
	                if (products[i].getProdId() == prodId) {
	                    return i;
	                }
	            }
	            return -1;
	        }


}
