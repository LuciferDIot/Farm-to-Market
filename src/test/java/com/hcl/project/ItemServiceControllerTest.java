package com.hcl.project;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hcl.project.model.Item;


@FixMethodOrder
public class ItemServiceControllerTest extends AbstractTest {

	@Test
	public void phase1_createProduct() throws Exception{
		String uri = "/create/item";
		Item item = new Item();
		item.setItemId(0);
		item.setItemName("tomato");
		item.setPhotoUrl("no image");
		item.setDescription("organic");
		item.setQuantity(10);
		String inputJson = super.mapToJson(item);
		super.setUp();
		MvcResult mvcResult = mvc.perform
				(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content
						(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is created successsfully");
	}

	@Test
	public void phase2_getProduct() throws Exception{
		String uri = "/viewall/item";
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Item[] itemList = super.mapFromJson(content, Item[].class);
		assertTrue(itemList.length > 0);
	}

	@Test
	public void phase3_updateProduct() throws Exception {
		String uri = "/update/item/1";
		Item item = new Item();
		item.setItemName("carrot");
		item.setPhotoUrl("no image");
		item.setDescription("organic");
		item.setQuantity(25);
		String inputJson = super.mapToJson(item);
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is updated successfully");
	}

	@Test
	public void phase4_deleteProduct() throws Exception {
		String uri = "/deleteItem/1";
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is deleted successsfully");
	}

}
