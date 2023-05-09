package com.careercamp.service;
import com.careercamp.dao.InMemoryProductDao;
import com.careercamp.dto.Product;
import com.careercamp.service.ProductNotFoundException;
import com.careercamp.service.ProductService;

import java.util.Scanner;
import java.util.*;;
public class Main {

	public static void main(String[] args) {
		        InMemoryProductDao productDao = new InMemoryProductDao(10);
		        ProductService productService = new ProductService(productDao);
		        Scanner scanner = new Scanner(System.in);

		        int choice;
		        do {
		            System.out.println("----- Product Management System -----");
		            System.out.println("1. Add Product");
		            System.out.println("2. Display All Products");
		            System.out.println("3. Delete Product by Product ID");
		            System.out.println("4. Update Product");
		            System.out.println("5. Search Product by Product ID");
		            System.out.println("6. Search Product by Product Name");
		            System.out.println("7. Display All Products by Price Order");
		            System.out.println("8. Display All Products by Discount Order");
		            System.out.println("0. Exit");
		            System.out.print("Enter your choice: ");
		            choice = scanner.nextInt();

		            switch (choice) {
		                case 1:
		                    addProduct(scanner, productService);
		                    break;
		                case 2:
		                    displayAllProducts(productService);
		                    break;
		                case 3:
		                    deleteProductById(scanner, productService);
		                    break;
		                case 4:
		                    updateProduct(scanner, productService);
		                    break;
		                case 5:
		                    searchProductById(scanner, productService);
		                    break;
		                case 6:
		                    searchProductByName(scanner, productService);
		                    break;
		                case 7:
		                    displayAllProductsByPriceOrder(scanner, productService);
		                    break;
		                case 8:
		                    displayAllProductsByDiscountOrder(scanner, productService);
		                    break;
		                case 0:
		                    System.out.println("Exiting...");
		                    break;
		                default:
		                    System.out.println("Invalid choice! Please try again.");
		                    break;
		            }
		            System.out.println();
		        } while (choice != 0);

		        scanner.close();
		    }

		    private static void addProduct(Scanner scanner, ProductService productService) {
		        System.out.print("Enter Product ID: ");
		        int prodId = scanner.nextInt();
		        scanner.nextLine(); // Consume the newline character
		        System.out.print("Enter Product Name: ");
		        String prodName = scanner.nextLine();
		        System.out.print("Enter Price: ");
		        double price = scanner.nextDouble();
		        System.out.print("Enter Quantity: ");
		        int quantity = scanner.nextInt();
		        System.out.print("Enter Discount: ");
		        double discount = scanner.nextDouble();

		        Product product = new Product(prodId, prodName, price, quantity, discount);
		        productService.addProduct(product);
		        System.out.println("Product added successfully!");
		    }

		    private static void displayAllProducts(ProductService productService) {
		        Product[] products = productService.getAllProducts();
		        if (products.length == 0) {
		            System.out.println("No products found!");
		        } else {
		            System.out.println("----- All Products -----");
		            for (Product product : products) {
		                System.out.println(product);
		            }
		        }
		    }

		    private static void deleteProductById(Scanner scanner, ProductService productService) {
		        System.out.print("Enter Product ID: ");
		        int prodId = scanner.nextInt();

		        try {
		            productService.deleteProduct(prodId);
		            System.out.println("Product deleted successfully!");
		        } catch (ProductNotFoundException e) {
		            System.out.println(e.getMessage());
		        }
		    }

		    private static void updateProduct(Scanner scanner, ProductService productService) {
		    	System.out.print("Enter Product ID: ");
		    	int prodId = scanner.nextInt();
		    	scanner.nextLine(); // Consume the newline character
		    	System.out.print("Enter Product Name: ");
		    	String prodName = scanner.nextLine();
		    	System.out.print("Enter Price: ");
		    	double price = scanner.nextDouble();
		    	System.out.print("Enter Quantity: ");
		    	int quantity = scanner.nextInt();
		    	System.out.print("Enter Discount: ");
		    	double discount = scanner.nextDouble();
		        Product product = new Product(prodId, prodName, price, quantity, discount);

		        try {
		            productService.updateProduct(product);
		            System.out.println("Product updated successfully!");
		        } catch (ProductNotFoundException e) {
		            System.out.println(e.getMessage());
		        }
		    }

		    private static void searchProductById(Scanner scanner, ProductService productService) {
		        System.out.print("Enter Product ID: ");
		        int prodId = scanner.nextInt();

		        try {
		            Product product = productService.searchProductById(prodId);
		            System.out.println("----- Product -----");
		            System.out.println(product);
		        } catch (ProductNotFoundException e) {
		            System.out.println(e.getMessage());
		        }
		    }

		    private static void searchProductByName(Scanner scanner, ProductService productService) {
		        System.out.print("Enter Product Name: ");
		        String prodName = scanner.nextLine();

		        try {
		            Product product = productService.searchProductByName(prodName);
		            System.out.println("----- Product -----");
		            System.out.println(product);
		        } catch (ProductNotFoundException e) {
		            System.out.println(e.getMessage());
		        }
		    }

		    private static void displayAllProductsByPriceOrder(Scanner scanner, ProductService productService) {
		        System.out.print("Enter 'asc' for ascending order or 'desc' for descending order: ");
		        String order = scanner.nextLine();

		        boolean ascending = order.equalsIgnoreCase("asc");
		        Product[] products = productService.getProductsByPriceOrder(ascending);

		        if (products.length == 0) {
		            System.out.println("No products found!");
		        } else {
		            System.out.println("----- Products by Price " + (ascending ? "Ascending" : "Descending") + " Order -----");
		            for (Product product : products) {
		                System.out.println(product);
		            }
		        }
		    }

		    private static void displayAllProductsByDiscountOrder(Scanner scanner, ProductService productService) {
		        System.out.print("Enter 'asc' for ascending order or 'desc' for descending order: ");
		        String order = scanner.nextLine();

		        boolean ascending = order.equalsIgnoreCase("asc");
		        Product[] products = productService.getProductsByDiscountOrder(ascending);

		        if (products.length == 0) {
		            System.out.println("No products found!");
		        } else {
		            System.out.println("----- Products by Discount " + (ascending ? "Ascending" : "Descending") + " Order -----");
		            for (Product product : products) {
		                System.out.println(product);
		            }
		        }
		    }


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
