package com.poc.boldconnect.controller;

import com.poc.boldconnect.exception.GlobalExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {
 private MockMvc mockMvc;

    @Autowired
    private AccountController serviceController;

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

 }

 @Test
 public void givenLookupOfAccount161640ThenAccount161640IsReturned() {

 }

 @Test
 public void givenLookupOfAccount123456ThenAccountNotFoundIsReturned() {
 }
}