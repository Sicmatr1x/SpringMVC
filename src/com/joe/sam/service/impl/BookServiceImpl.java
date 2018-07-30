package com.joe.sam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joe.sam.dao.IBookDao;
import com.joe.sam.po.Book;
import com.joe.sam.service.IBookService;

@Service("bookService")
@Transactional // 声明式事务
public class BookServiceImpl implements IBookService {
	
	@Resource(name="bookDao")
	private IBookDao dao;

	@Override
	public Book add(Book book) {
		// TODO Auto-generated method stub
		return dao.save(book);
	}

	@Override
	public Book update(Book book) {
		// TODO Auto-generated method stub
		return dao.update(book);
	}

	@Override
	public Book deleteById(String bookId) {
		// TODO Auto-generated method stub
		return dao.deleteById(bookId);
	}

	@Override
	public List<Book> listAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

	@Override
	public Book listOneById(String bookId) {
		// TODO Auto-generated method stub
		return dao.queryOneById(bookId);
	}

}
