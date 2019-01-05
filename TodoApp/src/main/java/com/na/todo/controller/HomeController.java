package com.na.todo.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private static final Logger logger = Logger.getLogger("HomeController");
	
	@RequestMapping("/TodoApp")
	private String home() {
		logger.fine("Request to /TodoApp arrived. Redirecting to index page");
		return "index";
	}
}