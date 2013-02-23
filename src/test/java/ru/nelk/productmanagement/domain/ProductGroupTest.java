package ru.nelk.productmanagement.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.nelk.productmanagement.dao.ProductGroupDAO;

public class ProductGroupTest {
	
	IProductGroup prodGroup;
	IProductGroup prodGroup2;
	long id;

	@Before
	public void setUp() throws Exception {		
		prodGroup = new ProductGroup();
		prodGroup2 = new ProductGroup();
		testInsertProductGroup();
	}

	@After
	public void tearDown() throws Exception {
		testDeleteProguctGroupById();
	}

	@Test
	public void testGetProductGroups() {
		List<ProductGroupDAO> pgList = prodGroup.getProductGroups();
		for (int i=0; i< pgList.size(); i++) {
			System.out.println("ProductGroup id: "+ pgList.get(i).getPgroup_id());
			
		}
		
	}

	@Test
	public void testGetProguctGroupById() {
		ProductGroupDAO pg = prodGroup.getProguctGroupById(id);
		assertEquals(pg.getPgroup_name(), "Goup 1");
		System.out.println("testGetProguctGroupById: "+pg.getPgroup_name());
	}

	public void testInsertProductGroup() {
		id = prodGroup.insertProductGroup("Goup 1");
		long id2 = prodGroup2.insertProductGroup("Group 2");
		System.out.println("Inserted groups Ids: "+ id + " , " + id2);
		
	}

	public void testDeleteProguctGroupById() {
		prodGroup.deleteProductGroupById(id);
	}
	
	@Test
	public void testUpdateProductGroup() {
		
		prodGroup.updateProductGroup(id, "updated group");
		System.out.println("testUpdateProductGroup: "+prodGroup.getProguctGroupById(id).getPgroup_name());
	}

}
