package com.hcl.project;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hcl.project.model.Equipment;
import com.hcl.project.model.Farmer;
import com.hcl.project.model.Item;

@FixMethodOrder
public class FarmerServiceControllerTest extends AbstractTest {
	
	@Test
	public void phase1_createFarmer_01() throws Exception{
		String uri = "/farmer/create";
		Farmer farmer = new Farmer();
		farmer.setUserId(0);
		farmer.setFirstName("John");
		farmer.setLastName("Cena");
		farmer.setUserName("johnCena");
		farmer.setPassword("john123");
		farmer.setState("California");
		farmer.setCity("LA");
		farmer.setPinCode("1234");
		farmer.setMobileNumber("1234567890");
		String inputJson = super.mapToJson(farmer);
		super.setUp();
		MvcResult mvcResult = mvc.perform
				(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content
				(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(201, status);
		assertEquals(content, "Farmer is created successfully");
	}
	
	
	
	@Test
	public void phase2_updateFarmerEquipment_02() throws Exception{
		String uri = "/farmer/2/add/1";
		Equipment equipment = new Equipment();
		String inputJson = super.mapToJson(equipment);
		super.setUp();
		MvcResult mvcResult = mvc.perform
				(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content
				(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(200, status);
		assertEquals(content, "Equipment is added to Farmer list");
	}
	
	@Test
	public void phase3_getFarmerEquipments_02() throws Exception{
		String uri = "/farmer/2/viewEquipment";
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		Equipment[] equipmentList = super.mapFromJson(content, Equipment[].class);
		assertEquals(200, status);
		assertTrue(equipmentList.length > 0);
	}
	
	@Test
	public void phase4_deleteFarmerEquipment_01() throws Exception {
		String uri = "/farmer/2/delete/equipment/1";
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(200, status);
		assertEquals(content, "Equipment is deleted");
	}
	

	@Test
	public void phase5_createFarmerItem_03() throws Exception{
		String uri = "/farmer/2/create/item";
		Item item = new Item();
		item.setItemId(0);
		item.setItemName("Carrot");
		item.setPhotoUrl("carrot_img");
		item.setDescription("organic");
		item.setQuantity(12);
		String inputJson = super.mapToJson(item);
		super.setUp();
		MvcResult mvcResult = mvc.perform
				(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content
				(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(200, status);
		assertEquals(content, "Item is created");
	}
	
	@Test
	public void phase6_getFarmerItems_03() throws Exception{
		String uri = "/farmer/2/viewItem";
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		Item[] itemList = super.mapFromJson(content, Item[].class);
		assertEquals(200, status);
		assertTrue(itemList.length > 0);
	}
	

	@Test
	public void phase7_updateFarmerItem_01() throws Exception {
		String uri = "/farmer/2/item/update/1"; //check farmer id if error while running
		Item item = new Item();
		item.setItemName("tomato");
		item.setPhotoUrl("tomato_img");
		item.setDescription("organic");
		item.setQuantity(25);
		String inputJson = super.mapToJson(item);
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(200, status);
		assertEquals(content, "Item is updated");
	}
	
	@Test
	public void phase8_deleteFarmerEquipment_02() throws Exception {
		String uri = "/farmer/2/delete/item/1";
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(200, status);
		assertEquals(content, "Item is deleted");
	}

}
