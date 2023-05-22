package com.hcl.project;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hcl.project.model.Item;
import com.hcl.project.model.Trader;
import com.hcl.project.model.User;

@FixMethodOrder
public class TraderServiceControllerTest extends AbstractTest {
	
	@Test
	public void phase1_createUser() throws Exception{
		String uri = "/trader/create";
		Trader trader = new Trader();
		trader.setUserId(0);
		trader.setFirstName("steve");
		trader.setLastName("smith");
		trader.setUserName("ss");
		trader.setPassword("smith123");
		trader.setState("Western");
		trader.setCity("colombo");
		trader.setPinCode("2244");
		trader.setMobileNumber("009134567");
		String inputJson = super.mapToJson(trader);
		super.setUp();
		MvcResult mvcResult = mvc.perform
				(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content
				(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Trader is created successfully");
	}
	
	
	@Test
	public void phase2_updateTraderItem() throws Exception{
		String uri = "/trader/6/add/3";
		Item item = new Item();
		String inputJson = super.mapToJson(item);
		super.setUp();
		MvcResult mvcResult = mvc.perform
				(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content
						(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Item added to trader");
	}
	
	@Test
	public void phase3_getAllItems_01() throws Exception{
		String uri = "/trader/viewAll/item";
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Item[] itemList = super.mapFromJson(content, Item[].class);
		assertTrue(itemList.length > 0);
	}
	
	@Test
	public void phase4_getTraderItems_02() throws Exception{
		String uri = "/trader/6/viewItem";
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Item[] traderitemList = super.mapFromJson(content, Item[].class);
		assertTrue(traderitemList.length > 0);
	}
}
