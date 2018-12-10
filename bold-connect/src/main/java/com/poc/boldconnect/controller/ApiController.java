package com.poc.boldconnect.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Profile({"dev1","dev2","dev3","default"})
public class ApiController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getApiInfo() {
		return new ModelAndView("redirect:/swagger-ui.html");
	}
}