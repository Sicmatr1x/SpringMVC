package com.joe.sam.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joe.sam.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	@Resource(name="exampleService")
	private ExampleService exampleService;
	
	@RequestMapping("/ex")
	public void example(){
		exampleService.example();
	}
}
