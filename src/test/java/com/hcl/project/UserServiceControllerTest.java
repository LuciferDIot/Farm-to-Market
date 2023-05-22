package com.hcl.project;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hcl.project.model.User;

@FixMethodOrder
public class UserServiceControllerTest extends AbstractTest {
	
	@Test
	public void phase1_createUser() throws Exception{
		String uri = "/create/user";
		User user = new User();
		user.setUserId(01);
		user.setFirstName("John");
		user.setLastName("Cena");
		user.setUserName("johnCena");
		user.setPassword("john123");
		user.setState("California");
		user.setCity("LA");
		user.setPinCode("1234");
		user.setMobileNumber("1234567");
		String inputJson = super.mapToJson(user);
		super.setUp();
		MvcResult mvcResult = mvc.perform
				(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content
				(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "User is created successfully");
	}
	
	@Test
	public void phase2_getUsers() throws Exception{
		String uri = "/viewall/user";
		super.setUp();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		User[] userList = super.mapFromJson(content, User[].class);
		assertTrue(userList.length > 0);
	}
}
