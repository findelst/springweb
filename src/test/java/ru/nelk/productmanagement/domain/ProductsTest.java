package ru.nelk.productmanagement.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.nelk.productmanagement.dao.ProductGroupDAO;
import ru.nelk.productmanagement.dao.ProductsDAO;

public class ProductsTest {
	IProducts product;
	IProducts product2;
	long prod_id;
	long prod_id2;
	long pg;

	@Before
	public void setUp() throws Exception {
		product = new Products();
		product2 = new Products();
		testInsertProduct();
	}

	@After
	public void tearDown() throws Exception {
		testDeleteProduct();
	}
	
	public void testInsertProduct() {
		ProductGroup productGroup = new ProductGroup();
		pg = productGroup.insertProductGroup("product group test Product");
		System.out.println("Insertrd product group = "+ pg);
		prod_id = product.insertProduct("Product 1", "111-112", productGroup.getProguctGroupById(pg));
		System.out.println("testInsertProduct: productID = "+ prod_id);
		
		prod_id2 = product2.insertProduct("Product 2", "22222-22", productGroup.getProguctGroupById(pg));
		System.out.println("testInsertProduct: productID = "+ prod_id2);
	}

	public void testDeleteProduct() {
		product.deleteProduct(prod_id);
		product.deleteProduct(prod_id2);
		
	}

	@Test
	public void testGetProductById() {
		assertEquals(product.getProductById(prod_id).getProduct_name(), "Product 1");
	}

	@Test
	public void testGetProductsList() {
		List<ProductsDAO> productList = product.getProductsList();
		for(int i=0;i<productList.size();i++) {
			System.out.println("Product: " + productList.get(i).getProduct_name());		
		}
	}

	@Test
	public void testGetProductsFromGroup() {
		List<ProductsDAO> productList = product.getProductsFromGroup(pg);
		for (int i=0;i<productList.size();i++) {
			System.out.println("testGetProductsFromGroup: product = " + productList.get(i).getProduct_name());
			
		}
	}
	
	@Test
	public void testUpdateProduct() {
		ProductGroup productGroup = new ProductGroup();
		pg = productGroup.insertProductGroup("product group test update");		
		product.updateProduct(prod_id, "updated product", "updated serial_number", productGroup.getProguctGroupById(pg));
		System.out.println("testUpdateProduct: "+product.getProductById(prod_id).getProduct_name());
		
		
	}
	

}
