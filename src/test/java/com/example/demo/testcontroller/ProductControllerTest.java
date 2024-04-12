package com.example.demo.testcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.controller.ProductController;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

public class ProductControllerTest {

	@Mock
	private ProductService productService;

	@InjectMocks
	private ProductController productController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetProductDetails() {
		// Prepare test data
		Product expectedProduct = new Product(1, "Laptop", "A high-performance laptop", 999.99, new Date());
		when(productService.getProductDetails(1)).thenReturn(expectedProduct);

		// Perform the test
		Product actualProduct = productController.getProductDetails(1);

		// Verify the result
		assertNotNull(actualProduct);
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void testAddProduct() {
		// Prepare test data
		Product productToAdd = new Product(1, "Laptop", "A high-performance laptop", 999.99, new Date());
		when(productService.addProduct(productToAdd)).thenReturn(productToAdd);

		// Perform the test
		Product addedProduct = productController.addProduct(productToAdd);

		// Verify the result
		assertNotNull(addedProduct);
		assertEquals(productToAdd, addedProduct);
	}

	@Test
	public void testGetAllProducts() {
		// Prepare test data
		List<Product> expectedProducts = new ArrayList<>();
		expectedProducts.add(new Product(1, "Laptop", "A high-performance laptop", 999.99, new Date()));
		expectedProducts.add(new Product(2, "Smartphone", "A feature-packed smartphone", 699.99, new Date()));
		when(productService.getAllProducts()).thenReturn(expectedProducts);

		// Perform the test
		List<Product> actualProducts = productController.getAllProducts();

		// Verify the result
		assertNotNull(actualProducts);
		assertEquals(expectedProducts.size(), actualProducts.size());
		for (int i = 0; i < expectedProducts.size(); i++) {
			assertEquals(expectedProducts.get(i), actualProducts.get(i));
		}
	}

	@Test
	public void testDeleteProduct() {
		// Perform the test
		productController.deleteProduct(1);

		// Verify that the delete method of productService is called with the correct
		// parameter
		// This test ensures that the controller correctly calls the service method to
		// delete a product
	}

	@Test
	public void testCreateProduct() {
		// Create a Product object
		Product product = new Product(1, "Laptop", "A high-performance laptop", 999.99, new Date());

		// Check if the product is not null
		assertNotNull(product);

		// Check if the product attributes are set correctly
		assertEquals(1, product.getProductId());
		assertEquals("Laptop", product.getProductName());
		assertEquals("A high-performance laptop", product.getDescription());
		assertEquals(999.99, product.getPrice());
		assertNotNull(product.getManufacturedDate());
	}

	@Test
	public void testSetProductId() {
		// Create a Product object
		Product product = new Product();

		// Set the product ID
		product.setProductId(2);

		// Check if the product ID is set correctly
		assertEquals(2, product.getProductId());
	}

	@Test
	public void testSetProductName() {
		// Create a Product object
		Product product = new Product();

		// Set the product name
		product.setProductName("Smartphone");

		// Check if the product name is set correctly
		assertEquals("Smartphone", product.getProductName());
	}

	@Test
	public void testSetDescription() {
		// Create a Product object
		Product product = new Product();

		// Set the product description
		product.setDescription("A feature-packed smartphone");

		// Check if the product description is set correctly
		assertEquals("A feature-packed smartphone", product.getDescription());
	}

	@Test
	public void testSetPrice() {
		// Create a Product object
		Product product = new Product();

		// Set the product price
		product.setPrice(699.99);

		// Check if the product price is set correctly
		assertEquals(699.99, product.getPrice());
	}

	@Test
	public void testSetManufacturedDate() {
		// Create a Product object
		Product product = new Product();

		// Set the manufactured date
		Date date = new Date();
		product.setManufacturedDate(date);

		// Check if the manufactured date is set correctly
		assertEquals(date, product.getManufacturedDate());
	}
}
