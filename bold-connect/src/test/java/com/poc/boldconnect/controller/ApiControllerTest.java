package com.poc.boldconnect.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ApiControllerTest {
	private MockMvc mockMvc;
	
	@Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new ApiController()).build();
    }
	
	@Test
	public void testGetApiInfo(){
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");
		ResultActions result;
		try {
			result = mockMvc.perform(builder);
	        result.andDo(print());
	        result.andExpect(status().is3xxRedirection());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
