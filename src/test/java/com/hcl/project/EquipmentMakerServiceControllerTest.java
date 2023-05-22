package com.hcl.project;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hcl.project.model.Equipment;
import com.hcl.project.model.EquipmentMaker;

@FixMethodOrder
public class EquipmentMakerServiceControllerTest extends AbstractTest {
	@Test
	public void phase1_createEquipmentMaker_01() throws Exception{
		String uri = "/equipmentMaker/create";
		EquipmentMaker equipmentMaker = new EquipmentMaker();
		equipmentMaker.setUserId(0);
		equipmentMaker.setFirstName("Paul");
		equipmentMaker.setLastName("Heyman");
		equipmentMaker.setUserName("paulheyman");
		equipmentMaker.setPassword("paul123");
		equipmentMaker.setState("colombo");
		equipmentMaker.setCity("col");
		equipmentMaker.setPinCode("321");
		equipmentMaker.setMobileNumber("994567890");
		String inputJson = super.mapToJson(equipmentMaker);
		super.setUp();
		MvcResult mvcResult = mvc.perform
				(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content
				(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Equipment maker is created successfully");
	}
	
	@Test
	public void phase2_createEquipment_02() throws Exception{
		String uri = "/equipmentMaker/1/create/equipment";
		Equipment equipment = new Equipment();
		equipment.setEquipmentId(0);
		equipment.setEquipmentName("tractor");
		equipment.setCount(3);
		equipment.setRentPerDay(2000);
		equipment.setState("California");
		equipment.setCity("LA");
		equipment.setVillage("redwood");
		equipment.setPinCode("1234");
		equipment.setContactPerson("ben");
		equipment.setMobileNumber("1234565");
		equipment.setImageUrl("tractor_img");
		String inputJson = super.mapToJson(equipment);
		super.setUp();
		MvcResult mvcResult = mvc.perform
				(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content
				(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Equipment is created");
	}
	
	@Test
	public void phase3_getEquipmentList() throws Exception{
		String uri = "/equipmentMaker/1/viewAllEquipment";
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Equipment[] equipmentList = super.mapFromJson(content, Equipment[].class);
		assertTrue(equipmentList.length > 0);
	}
	
	@Test
	public void phase4_updateEquipment() throws Exception {
		String uri = "/equipmentMaker/1/update/1"; 
		Equipment equipment = new Equipment();
		equipment.setEquipmentName("Dozer");
		equipment.setCount(5);
		equipment.setRentPerDay(5000);
		equipment.setState("central");
		equipment.setCity("Kandy");
		equipment.setVillage("redwood");
		equipment.setPinCode("1211");
		equipment.setContactPerson("james");
		equipment.setMobileNumber("9456511");
		equipment.setImageUrl("tractor_img");
		String inputJson = super.mapToJson(equipment);
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Equipment is updated successsfully");
	}
	
	@Test
	public void phase5_deleteEquipment() throws Exception {
		String uri = "/equipmentMaker/1/delete/1";
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Equipment is deleted successsfully");
	}

}
