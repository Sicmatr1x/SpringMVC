package com.joe.sam.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joe.sam.dao.ExampleDao;
import com.joe.sam.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{
	
	@Resource(name="exampleDao")
	private ExampleDao exampleDao;

	@Override
	public void example() {
		exampleDao.example();
		
	}

}
