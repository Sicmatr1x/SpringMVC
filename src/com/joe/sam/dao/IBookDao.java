package com.joe.sam.dao;

import java.util.List;

import com.joe.sam.po.Book;



public interface IBookDao {
	Book save(Book book);
	Book update(Book book);
	Book deleteById(String bookId);
	List<Book> queryAll();
	Book queryOneById(String bookId);
}
