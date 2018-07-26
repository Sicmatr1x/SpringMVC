package com.joe.sam.dao.impl;

import org.springframework.stereotype.Repository;

import com.joe.sam.dao.ExampleDao;

@Repository("exampleDao")
public class ExampleDaoImpl implements ExampleDao {

	@Override
	public void example() {
		// TODO Auto-generated method stub
		System.out.println("ExampleDaoImpl:example");
	}

}
