package com.poc.boldconnect.controller;

import com.poc.boldconnect.exception.GlobalExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import com.poc.boldconnect.Application;
import com.poc.boldconnect.util.CommonUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceControllerTest {
 private MockMvc mockMvc;

    @Autowired
    private ServiceController serviceController;

    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

 @Before
 public void setUp() throws Exception {

     mockMvc = MockMvcBuilders
             .standaloneSetup(serviceController)
             .setControllerAdvice(globalExceptionHandler)
             .build();
 }


 @Test
 public void givenAccountThenCreateAccount() {
     try {
         String input = CommonUtils.getInputFromFile(Application.class.getClassLoader().getResource("SampleRequest.json").toURI());
         MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(ServiceController.RESOURCE_NAME);
         builder.header("uuid", UUID.randomUUID().toString());
         builder.content(input);
         ResultActions result = mockMvc.perform(builder);
         result.andDo(print());
         result.andExpect(status().isCreated());
     } catch (Exception ex) {
         ex.printStackTrace();
         fail();
     }
 }

 @Test
 public void givenLookupOfAccount161640ThenAccount161640IsReturned() {
     try {
         MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(ServiceController.RESOURCE_NAME + "161640");
         builder.header("uuid", UUID.randomUUID().toString());
         ResultActions result = mockMvc.perform(builder);
         result.andDo(print());
         result.andExpect(status().isOk());
         result.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
         String resultJSON = result.andReturn().getResponse().getContentAsString();
         assertTrue(resultJSON.contains("accountNumber"));
     } catch (Exception ex) {
         ex.printStackTrace();
         fail();
     }
 }

 @Test
 public void givenLookupOfAccount123456ThenAccountNotFoundIsReturned() {
     try {
         MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(ServiceController.RESOURCE_NAME + "123456");
         builder.header("uuid", UUID.randomUUID().toString());
         ResultActions result = mockMvc.perform(builder);
         result.andDo(print());
         result.andExpect(status().isNotFound());
         result.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
         String resultJSON = result.andReturn().getResponse().getContentAsString();
         assertTrue(resultJSON.contains("Look on message properties file and global exception file for error binding"));
     } catch (Exception ex) {
         ex.printStackTrace();
         fail();
     }
 }
}