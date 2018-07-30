package com.joe.sam.service;

import java.util.List;

import com.joe.sam.po.Book;

public interface IBookService {
	Book add(Book book);
	Book update(Book book);
	Book deleteById(String bookId);
	List<Book> listAll();
	Book listOneById(String bookId);
}
